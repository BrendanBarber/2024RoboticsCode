package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopSwerve extends CommandBase {
        private final DrivetrainSubsystem swerveSubsystem;
        public TeleopSwerve(DrivetrainSubsystem swerveSubsystem) {
                this.swerveSubsystem = swerveSubsystem;
                addRequirements(this.swerveSubsystem);
        }

        @Override
        public void execute() {
                swerveSubsystem.getSwerveDrive().drive(
                        new Translation2d(-RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.forwardAxis) * Constants.DriverConstants.speedMetersPerSecond,
                        -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.strafeAxis) * Constants.DriverConstants.speedMetersPerSecond),
                        RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.turnAxis) * Constants.DriverConstants.speedRadiansPerSecond,
                        false,
                        false
                );
        }
}
