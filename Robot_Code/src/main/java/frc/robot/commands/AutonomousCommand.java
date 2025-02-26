package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;

public class AutonomousCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final RollerSubsystem rollerSubsystem;
    private final Timer timer = new Timer();

    public AutonomousCommand(DriveSubsystem driveSubsystem, RollerSubsystem rollerSubsystem){
        this.driveSubsystem = driveSubsystem;
        this.rollerSubsystem = rollerSubsystem;
        addRequirements(driveSubsystem, rollerSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        double time = timer.get();

        if (time < 8.0) { 
            driveSubsystem.tankDrive(0.5, 0.5);
        } 
        else if (time < 11.0) {
            driveSubsystem.stop();
            rollerSubsystem.setSpeed(0.5);
        } 
        else if (time < 12.0) { 
            rollerSubsystem.stop();
            driveSubsystem.tankDrive(0.5, 0.5);
        } 
        else { 
            driveSubsystem.stop();
            rollerSubsystem.stop();
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
        rollerSubsystem.stop();
    }
}
