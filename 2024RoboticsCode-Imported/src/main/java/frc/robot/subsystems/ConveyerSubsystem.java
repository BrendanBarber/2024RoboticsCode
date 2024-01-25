package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem.IntakeSpinState;

public class ConveyerSubsystem extends SubsystemBase{
    
    public enum ConveyerState{
        STOPPED,
        HOLDING,
        TAKE_IN,
        SHOOT_OUT,
    }

    //TalonFX conveyerMotor = new TalonFX(Constants.Conveyer.conveyerID);

    ConveyerState currentConveyerState = ConveyerState.STOPPED;

    public ConveyerSubsystem(RobotContainer robotContainer){
        // configure motors
    }

    @Override
    public void periodic(){
        switch (currentConveyerState) {
            case STOPPED:
                //conveyerMotor.set(Constants.Conveyer.conveyerStoppedSpeed);    
                SmartDashboard.putString("ConveyerState", "STOPPED");
                break;
            case HOLDING:
                //conveyerMotor.set(Constants.Conveyer.conveyerStoppedSpeed);
                SmartDashboard.putString("ConveyerState", "HOLDING");
                break;
            case TAKE_IN:
                //conveyerMotor.set(Constants.Conveyer.conveyerTakeInSpeed);
                SmartDashboard.putString("ConveyerState", "TAKE IN");
                break;
            case SHOOT_OUT:
                //conveyerMotor.set(Constants.Conveyer.conveyerShootOutSpeed);  
                SmartDashboard.putString("ConveyerState", "SHOOT OUT");      
                break;
            default:
                break;
        }
    }

    public void setConveyerState(ConveyerState state){
        this.currentConveyerState = state;
    }

}
