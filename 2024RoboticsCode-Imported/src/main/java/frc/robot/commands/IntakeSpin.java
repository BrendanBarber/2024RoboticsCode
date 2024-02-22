package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeSubsystem.IntakeSpinState;

public class IntakeSpin extends Command{
    private final IntakeSubsystem intakeSubsystem;

    private IntakeSpinState state;

    public IntakeSpin(IntakeSubsystem subsystem, IntakeSpinState intakeState){
        this.intakeSubsystem = subsystem;
        this.state = intakeState;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize(){
        intakeSubsystem.setSpinState(state);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
