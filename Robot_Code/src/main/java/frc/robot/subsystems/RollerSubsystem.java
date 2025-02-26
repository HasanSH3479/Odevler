package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

public class RollerSubsystem extends SubsystemBase {

    private final SparkMax rollerMotor;
    private final RelativeEncoder rollerEncoder;
    private final PIDController pidController;

    public RollerSubsystem(int motorPort) {
        rollerMotor = new SparkMax(motorPort, MotorType.kBrushless);
        rollerEncoder = rollerMotor.getEncoder();
        pidController = new PIDController(0.1, 0.0, 0.0);

        SparkMaxConfig rollerConfig = new SparkMaxConfig();
        rollerConfig.smartCurrentLimit(40);
        rollerConfig.inverted(false);
        rollerMotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setSpeed(double targetSpeed) {
        double output = pidController.calculate(rollerEncoder.getVelocity(), targetSpeed);
        rollerMotor.set(output);
    }

    public void stop() {
        rollerMotor.set(0);
    }

    public double getRollerSpeed() {
        return rollerEncoder.getVelocity();
    }

    public double getRollerPosition() {
        return rollerEncoder.getPosition();
    }

    public Command runRoller(DoubleSupplier forward, DoubleSupplier reverse) {
        return Commands.run(() -> rollerMotor.set(forward.getAsDouble() - reverse.getAsDouble()), this);
    }
}
