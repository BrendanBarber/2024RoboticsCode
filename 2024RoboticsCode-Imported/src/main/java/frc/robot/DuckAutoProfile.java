package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class DuckAutoProfile {
    private Command sequence;
    private Pose2d initPose;

    public DuckAutoProfile() {
        sequence = new SequentialCommandGroup();
        initPose = new Pose2d(10.14, 3.67, Rotation2d.fromDegrees(180));
    }

    public DuckAutoProfile(Command commandSequence, Pose2d initialPose) {
        sequence = commandSequence;
        initPose = initialPose;
    }

    public Command getAutoCommand() {
        return sequence;
    }

    public Pose2d getStartingPose() {
        return initPose;
    }

    public void addDelay(double waitDelaySeconds) {
        sequence = new SequentialCommandGroup(
            new WaitCommand(waitDelaySeconds),
            sequence);
    }
}