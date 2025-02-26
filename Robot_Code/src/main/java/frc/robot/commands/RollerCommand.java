package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommand extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final Joystick joystick;

    public RollerCommand(RollerSubsystem rollerSubsystem, Joystick joystick) {
        this.rollerSubsystem = rollerSubsystem;
        this.joystick = joystick;
        addRequirements(rollerSubsystem);
    }

    @Override
    public void execute() {
        double speed = 0.0;

        if (joystick.getRawButton(1)) {  
            speed = 0.5;  // İleri çalıştır
        } else if (joystick.getRawButton(2)) {  
            speed = -0.5; // Geri çalıştır
        }

        rollerSubsystem.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        rollerSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false; 
    }
}
