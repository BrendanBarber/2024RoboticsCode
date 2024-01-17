package frc.robot.commands;

import java.util.List;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriverConstants;
import frc.robot.subsystems.DrivetrainSubsystem;
import swervelib.SwerveController;
import swervelib.math.SwerveMath;

public class TeleopSwerve extends Command {
        private final DrivetrainSubsystem swerveSubsystem;

        public TeleopSwerve(DrivetrainSubsystem swerveSubsystem) {
                this.swerveSubsystem = swerveSubsystem;
                addRequirements(this.swerveSubsystem);
        }

        @Override
        public void execute() {

                double vX = -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.forwardAxis) * DriverConstants.speedMetersPerSecond;
                double vY = -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.strafeAxis) * DriverConstants.speedMetersPerSecond;
                double heading = -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.turnAxis) * DriverConstants.speedRadiansPerSecond;

                ChassisSpeeds desiredSpeeds = swerveSubsystem.getTargetSpeeds(vX, vY,
                                new Rotation2d(heading * Math.PI));

                Translation2d translation = SwerveController.getTranslation2d(desiredSpeeds);
                /*
                 * translation = SwerveMath.limitVelocity(translation,
                 * swerve.getFieldVelocity(), swerve.getPose(),
                 * Constants.LOOP_TIME, Constants.ROBOT_MASS, List.of(Constants.CHASSIS),
                 * swerve.getSwerveDriveConfiguration());
                 */

                // Make the robot move
                swerveSubsystem.getSwerveDrive().drive(translation, desiredSpeeds.omegaRadiansPerSecond, true, false);

                /*
                 * swerveSubsystem.getSwerveDrive().drive(
                 * new Translation2d(-RobotContainer.driverJoystick.getRawAxis(Constants.
                 * DriverConstants.forwardAxis) * DriverConstants.speedMetersPerSecond,
                 * -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.
                 * strafeAxis) * DriverConstants.speedMetersPerSecond),
                 * -RobotContainer.driverJoystick.getRawAxis(Constants.DriverConstants.turnAxis)
                 * * DriverConstants.speedRadiansPerSecond,
                 * false,
                 * false
                 * );
                 */
        }
}
