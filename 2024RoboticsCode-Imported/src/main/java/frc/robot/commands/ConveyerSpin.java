package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ConveyerSubsystem.ConveyerState;
import frc.robot.subsystems.IntakeSubsystem.IntakeSpinState;

public class ConveyerSpin extends Command {
    
    private ConveyerSubsystem conveyerSubsystem;

    private ConveyerState state;

    public ConveyerSpin(ConveyerSubsystem subsystem, ConveyerState conveyerState){
        this.conveyerSubsystem = subsystem;
        this.state = conveyerState;
        addRequirements(conveyerSubsystem);
    }

    @Override
    public void initialize(){
        conveyerSubsystem.setConveyerState(state);
    }

    @Override
    public boolean isFinished(){
        return true;
    }

}
