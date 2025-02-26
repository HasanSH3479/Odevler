package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.RollerCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;

public class RobotContainer {
    
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final RollerSubsystem rollerSubsystem = new RollerSubsystem(Constants.ROLLER_MOTOR_ID);

    private final Joystick driverJoystick = new Joystick(Constants.DRIVER_CONTROLLER_PORT);
    private final Joystick operatorJoystick = new Joystick(Constants.OPERATOR_CONTROLLER_PORT);

    private final DriveCommand driveCommand = new DriveCommand(driveSubsystem, driverJoystick);
    private final RollerCommand rollerCommand = new RollerCommand(rollerSubsystem, operatorJoystick);

    public RobotContainer() {
        configureButtonBindings();

        driveSubsystem.setDefaultCommand(driveCommand);


        rollerSubsystem.setDefaultCommand(rollerCommand);
    }

    private void configureButtonBindings() {

        new RunCommand(
            () -> rollerSubsystem.setSpeed(Constants.ROLLER_SPEED),
            rollerSubsystem
        ).onlyWhile(() -> operatorJoystick.getRawButton(Constants.ROLLER_FORWARD_BUTTON));

        new RunCommand(
            () -> rollerSubsystem.setSpeed(Constants.ROLLER_REVERSE_SPEED),
            rollerSubsystem
        ).onlyWhile(() -> operatorJoystick.getRawButton(Constants.ROLLER_REVERSE_BUTTON));

        new RunCommand(
            rollerSubsystem::stop,
            rollerSubsystem
        ).onlyWhile(() -> !operatorJoystick.getRawButton(Constants.ROLLER_FORWARD_BUTTON) &&
                         !operatorJoystick.getRawButton(Constants.ROLLER_REVERSE_BUTTON));
    }

    public Command getAutonomousCommand() {
        return new AutonomousCommand(driveSubsystem, rollerSubsystem);
    }
}
