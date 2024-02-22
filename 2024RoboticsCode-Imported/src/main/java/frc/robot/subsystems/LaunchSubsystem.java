package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LaunchSubsystem extends SubsystemBase {
    
    TalonFX launchMotor = new TalonFX(Constants.Launch.launchMotorID);
    TalonFX launchMotorFollower = new TalonFX(Constants.Launch.launchMotorFollowerID);

    TalonFXConfiguration launchMotorConfig;
    TalonFXConfiguration launchMotorFollowerConfig;

    public LaunchSubsystem(RobotContainer robotContainer){
        //config motors
        launchMotorConfig.Slot0.kP = Constants.Launch.launchMotorP;
        launchMotorConfig.Slot0.kI = Constants.Launch.launchMotorI;
        launchMotorConfig.Slot0.kD = Constants.Launch.launchMotorD;

        launchMotorFollowerConfig.Slot0.kP = Constants.Launch.launchMotorP;
        launchMotorFollowerConfig.Slot0.kI = Constants.Launch.launchMotorI;
        launchMotorFollowerConfig.Slot0.kD = Constants.Launch.launchMotorD;

        launchMotor.getConfigurator().apply(launchMotorConfig);
        launchMotorFollower.getConfigurator().apply(launchMotorFollowerConfig);

        launchMotor.setNeutralMode(NeutralModeValue.Brake);
        launchMotorFollower.setNeutralMode(NeutralModeValue.Brake);

        launchMotorFollower.setControl(new Follower(launchMotor.getDeviceID(), false));
    }

    @Override
    public void periodic() {
        
    }

    public void setLaunchMotorVelocity(int velocity){
        launchMotor.setControl(new VelocityDutyCycle(velocity));
    }

}
