package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    
    private final DriveSubsystem driveSubsystem;
    private final Joystick joystick;
    private static final double DEADBAND = 0.05;

    public DriveCommand(DriveSubsystem driveSubsystem, Joystick joystick) {
        this.driveSubsystem = driveSubsystem;
        this.joystick = joystick;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        double forward = applyDeadband(-joystick.getRawAxis(1)); // Y ekseni (ileri-geri)
        double rotation = applyDeadband(-joystick.getRawAxis(4)); // X ekseni (dönüş)
        
        driveSubsystem.arcadeDrive(forward, rotation);
    }

    private double applyDeadband(double value) {
        return (Math.abs(value) > DEADBAND) ? value : 0.0;
    }
}
