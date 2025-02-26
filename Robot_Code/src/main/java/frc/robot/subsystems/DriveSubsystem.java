package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSubsystem extends SubsystemBase {

    private final SparkMax leftMotor1 = new SparkMax(0, MotorType.kBrushed);
    private final SparkMax leftMotor2 = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax rightMotor1 = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax rightMotor2 = new SparkMax(3, MotorType.kBrushed);

    private final DifferentialDrive differentialDrive;
    private final Field2d field = new Field2d();
    private final DifferentialDriveOdometry odometry =
        new DifferentialDriveOdometry(new Rotation2d(), 0, 0);

    public DriveSubsystem() {
        leftMotor2.set(leftMotor1.get());
        rightMotor2.set(rightMotor1.get());

        differentialDrive = new DifferentialDrive(leftMotor1, rightMotor1);

        SmartDashboard.putData("Field", field);
    }

    @Override
    public void periodic() {
        leftMotor2.set(leftMotor1.get());
        rightMotor2.set(rightMotor1.get());
        updateOdometry();
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public void arcadeDrive(double forward, double rotation) {
        differentialDrive.arcadeDrive(forward, rotation);
    }

    public void stop() {
        differentialDrive.stopMotor();
    }

    public void updateOdometry() {
        double leftDistance = leftMotor1.getEncoder().getPosition() * 0.01;
        double rightDistance = rightMotor1.getEncoder().getPosition() * 0.01;

        odometry.update(new Rotation2d(), leftDistance, rightDistance);

        Pose2d currentPose = odometry.getPoseMeters();
        field.setRobotPose(currentPose);
        SmartDashboard.putString("Robot Pose", currentPose.toString());
    }
}
