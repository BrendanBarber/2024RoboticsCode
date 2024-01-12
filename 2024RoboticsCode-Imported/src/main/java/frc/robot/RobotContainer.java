// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriverConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.IntakeMove;
import frc.robot.commands.IntakeSpin;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeSubsystem.IntakeSpinState;

public class RobotContainer {

  public DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem(this);
  public IntakeSubsystem intakeSubsystem = new IntakeSubsystem(this);

  public SendableChooser<DuckAutoProfile> autonomousMode = new SendableChooser<>();

  public final static CommandPS4Controller driverJoystick =
      new CommandPS4Controller(DriverConstants.port);
  public final static CommandXboxController operatorJoystick =
      new CommandXboxController(OperatorConstants.port);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driverJoystick.cross().onTrue(new SequentialCommandGroup(new IntakeMove(intakeSubsystem, true), new IntakeSpin(intakeSubsystem, IntakeSpinState.TAKE_IN)));
    driverJoystick.cross().onFalse(new SequentialCommandGroup(new IntakeMove(intakeSubsystem, false), new IntakeSpin(intakeSubsystem, IntakeSpinState.STOPPED)));

    driverJoystick.circle().onTrue(new SequentialCommandGroup(new IntakeMove(intakeSubsystem, true), new IntakeSpin(intakeSubsystem, IntakeSpinState.SHOOT_OUT)));
    driverJoystick.circle().onFalse(new SequentialCommandGroup(new IntakeMove(intakeSubsystem, false), new IntakeSpin(intakeSubsystem, IntakeSpinState.STOPPED)));
  }

  public DuckAutoProfile getAutonomousProfile(){
    return autonomousMode.getSelected();
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public DrivetrainSubsystem getDrivetrainSubsystem(){
    return drivetrainSubsystem;
  }
  
}