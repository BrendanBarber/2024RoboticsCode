package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
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
    
    VictorSPX intakeSpinMotor = new VictorSPX(Constants.Intake.spinID);
    VictorSPX intakeSpinMotorFollower = new VictorSPX(Constants.Intake.spinIDFollower);

    IntakeSpinState intakeSpinState = IntakeSpinState.STOPPED;

    public IntakeSubsystem(RobotContainer robotContainer){
        configure();
    }

    private void configure(){
        intakeSpinMotor.setNeutralMode(NeutralMode.Coast);
        intakeSpinMotorFollower.setNeutralMode(NeutralMode.Coast);

        intakeSpinMotorFollower.follow(intakeSpinMotor);
    }

    @Override
    public void periodic() {
        //set the spinMotor to whatever intakeSpinState is
        switch(intakeSpinState){
            case STOPPED:
                intakeSpinMotor.set(ControlMode.PercentOutput, Constants.Intake.intakeStoppedSpeed);
                SmartDashboard.putString("SpinState", "STOPPED");
                break;
            case TAKE_IN:
                intakeSpinMotor.set(ControlMode.PercentOutput, Constants.Intake.intakeTakeInSpeed);
                SmartDashboard.putString("SpinState", "TAKE_IN");
                break;
            case SHOOT_OUT:
                intakeSpinMotor.set(ControlMode.PercentOutput, Constants.Intake.intakeShootOutSpeed);
                SmartDashboard.putString("SpinState", "SHOOT_OUT");
        }
    }

    public void setSpinState(IntakeSpinState state){
        this.intakeSpinState = state;
    }

}