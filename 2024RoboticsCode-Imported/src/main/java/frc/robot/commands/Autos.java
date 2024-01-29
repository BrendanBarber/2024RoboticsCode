package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class Autos {
    
    private static SequentialCommandGroup testStraightPath(DrivetrainSubsystem drivetrainSubsystem){
        String pathName = Constants.AutoTrajectoryFileNames.TEST_STRAIGHT;
        SequentialCommandGroup command = new SequentialCommandGroup(
            drivetrainSubsystem.getAutonomousCommand(pathName, true));;
        return command;
    }

    private static SequentialCommandGroup testCurvePath(DrivetrainSubsystem drivetrainSubsystem){
        String pathName = Constants.AutoTrajectoryFileNames.TEST_CURVE;
        SequentialCommandGroup command = new SequentialCommandGroup(
            drivetrainSubsystem.getAutonomousCommand(pathName, true));;
        return command;
    }

    private static SequentialCommandGroup twoNoteAuto(DrivetrainSubsystem drivetrainSubsystem){
        String pathName = Constants.AutoTrajectoryFileNames.TWO_NOTE;
        SequentialCommandGroup command = new SequentialCommandGroup(
            drivetrainSubsystem.getAutonomousCommand(pathName, true));;
        return command;
    }

    public static SequentialCommandGroup threeNoteAuto(DrivetrainSubsystem drivetrainSubsystem){
        String path1Name = Constants.AutoTrajectoryFileNames.TWO_NOTE;
        String path2Name = Constants.AutoTrajectoryFileNames.ONE_MORE_NOTE;
        SequentialCommandGroup command = new SequentialCommandGroup(
            drivetrainSubsystem.getAutonomousCommand(path1Name, true),
            drivetrainSubsystem.getAutonomousCommand(path2Name, false)
        );
        return command;
    }
    
    public static void pushAutosToDashboard(SendableChooser<SequentialCommandGroup> autonomousMode,
        DrivetrainSubsystem drivetrainSubsystem){

        autonomousMode.setDefaultOption("straight path", testStraightPath(drivetrainSubsystem));
        autonomousMode.addOption("curved path", testCurvePath(drivetrainSubsystem));
        autonomousMode.addOption("two note", twoNoteAuto(drivetrainSubsystem));
        autonomousMode.addOption("three note", threeNoteAuto(drivetrainSubsystem));
    }

}
