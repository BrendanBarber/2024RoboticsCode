package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeSubsystem extends SubsystemBase {

    public enum IntakeSpinState {
        TAKE_IN,
        SHOOT_OUT,
        STOPPED;
    }
    
    TalonFX intakeArmMotor = new TalonFX(Constants.Intake.armID);
    TalonFX intakeSpinMotor = new TalonFX(Constants.Intake.spinID);

    boolean intakeArmOut = false;

    IntakeSpinState intakeSpinState = IntakeSpinState.STOPPED;

    public IntakeSubsystem(RobotContainer robotContainer){
        //configure intake motors
    }

    @Override
    public void periodic() {
        //set armMotor position to Out or In depending on bool intakeArmOut
        if(intakeArmOut){
            intakeArmMotor.setPosition(Constants.Intake.armOutPosition);
            SmartDashboard.putBoolean("ArmOut?", true);
        }
        else{
            intakeArmMotor.setPosition(Constants.Intake.armInPosition);
            SmartDashboard.putBoolean("ArmOut?", false);
        }

        //set the spinMotor to whatever intakeSpinState is
        switch(intakeSpinState){
            case STOPPED:
                intakeSpinMotor.set(Constants.Intake.intakeStoppedSpeed);
                SmartDashboard.putString("SpinState", "STOPPED");
                break;
            case TAKE_IN:
                intakeSpinMotor.set(Constants.Intake.intakeTakeInSpeed);
                SmartDashboard.putString("SpinState", "TAKE_IN");
                break;
            case SHOOT_OUT:
                intakeSpinMotor.set(Constants.Intake.intakeShootOutSpeed);
                SmartDashboard.putString("SpinState", "SHOOT_OUT");
        }
    }

    public void setIntakeArmOut(boolean isArmOut){
        this.intakeArmOut = isArmOut;
    }

    public void setSpinState(IntakeSpinState state){
        this.intakeSpinState = state;
    }

}