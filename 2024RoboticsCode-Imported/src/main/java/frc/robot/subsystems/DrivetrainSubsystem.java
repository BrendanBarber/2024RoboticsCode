package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.TeleopSwerve;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class DrivetrainSubsystem extends SubsystemBase {
        private final double maximumSpeed = Units.feetToMeters(14.5);
        private File swerveJsonDirectory;
        private SwerveDrive swerveDrive;

        public DrivetrainSubsystem(RobotContainer robotContainer) {
                this.swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");

                SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
                try {
                        this.swerveDrive = new SwerveParser(swerveJsonDirectory).createSwerveDrive(maximumSpeed);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                swerveDrive.setHeadingCorrection(false);
                this.setDefaultCommand(new TeleopSwerve(this));
        }

        @Override
        public void periodic() {
                // This method will be called once per scheduler run
                SmartDashboard.putNumber(swerveDrive.getModules()[0].configuration.name,
                                swerveDrive.getModules()[0].getAbsolutePosition());
                SmartDashboard.putNumber(swerveDrive.getModules()[3].configuration.name,
                                swerveDrive.getModules()[3].getAbsolutePosition());
                SmartDashboard.putNumber(swerveDrive.getModules()[1].configuration.name,
                                swerveDrive.getModules()[1].getAbsolutePosition());
                SmartDashboard.putNumber(swerveDrive.getModules()[2].configuration.name,
                                swerveDrive.getModules()[2].getAbsolutePosition());

                SmartDashboard.putNumber("RobotActualSpeed", swerveDrive.getModules()[0].getDriveMotor().getVelocity());
        }

        /**
         * Get the chassis speeds based on controller input of 2 joysticks. One for
         * speeds in which direction. The other for
         * the angle of the robot.
         *
         * @param xInput   X joystick input for the robot to move in the X direction.
         * @param yInput   Y joystick input for the robot to move in the Y direction.
         * @param headingX X joystick which controls the angle of the robot.
         * @param headingY Y joystick which controls the angle of the robot.
         * @return {@link ChassisSpeeds} which can be sent to th Swerve Drive.
         */
        public ChassisSpeeds getTargetSpeeds(double xInput, double yInput, double headingX, double headingY) {
                xInput = Math.pow(xInput, 3);
                yInput = Math.pow(yInput, 3);
                return swerveDrive.swerveController.getTargetSpeeds(xInput,
                                yInput,
                                headingX,
                                headingY,
                                getHeading().getRadians(),
                                maximumSpeed);
        }

        /**
         * Get the chassis speeds based on controller input of 1 joystick and one angle.
         *
         * @param xInput X joystick input for the robot to move in the X direction.
         * @param yInput Y joystick input for the robot to move in the Y direction.
         * @param angle  The angle in as a {@link Rotation2d}.
         * @return {@link ChassisSpeeds} which can be sent to th Swerve Drive.
         */
        public ChassisSpeeds getTargetSpeeds(double xInput, double yInput, Rotation2d angle) {
                xInput = Math.pow(xInput, 3);
                yInput = Math.pow(yInput, 3);
                return swerveDrive.swerveController.getTargetSpeeds(xInput,
                                yInput,
                                angle.getRadians(),
                                getHeading().getRadians(),
                                maximumSpeed);
        }

        /**
         * Gets the current yaw angle of the robot, as reported by the imu. CCW
         * positive, not wrapped.
         *
         * @return The yaw angle
         */
        public Rotation2d getHeading() {
                return swerveDrive.getYaw();
        }

        public SwerveDrive getSwerveDrive() {
                return swerveDrive;
        }
}