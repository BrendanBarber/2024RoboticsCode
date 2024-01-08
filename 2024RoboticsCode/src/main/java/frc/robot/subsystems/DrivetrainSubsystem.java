package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.TeleopSwerve;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class DrivetrainSubsystem extends SubsystemBase{
    private final double maximumSpeed = Units.feetToMeters(4.5);
    private File swerveJsonDirectory;
    private SwerveDrive swerveDrive;

    public DrivetrainSubsystem(RobotContainer robotContainer) {
            this.swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");

            try {
                    this.swerveDrive = new SwerveParser(swerveJsonDirectory).createSwerveDrive(maximumSpeed);
            } catch (IOException e) {
                    e.printStackTrace();
            }
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
    }

    public SwerveDrive getSwerveDrive() {
            return swerveDrive;
    }
}
