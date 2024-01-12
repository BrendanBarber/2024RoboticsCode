package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeMove extends Command{
    private final IntakeSubsystem intakeSubsystem;

    private boolean intakeOut = false;

    public IntakeMove(IntakeSubsystem subsystem, boolean setIntakeOut){
        this.intakeSubsystem = subsystem;
        this.intakeOut = setIntakeOut;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize(){
        intakeSubsystem.setIntakeArmOut(intakeOut);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
