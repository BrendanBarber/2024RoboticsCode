package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {

    public static class OperatorConstants {
        public static final int port = 1;
        public static final int movementAxis = 5;
        public static final double movementDeadband = 0.5;
        public static final int elbowMovementAxis = 1;
    }
    
    public static class DriverConstants {
        public static final int port = 0;
        public static final double deadbandLeftJoystick = 0.05;
        public static final double deadbandRightJoystick = deadbandLeftJoystick;

        public static final int forwardAxis = 1;
        public static final int strafeAxis = 0;
        public static final int turnAxis = 2;

        public static final double autoMaxSpeedMeters = 5;
        public static final double autoMaxAccelerationMeters = 3;

        public static final double speedMultiplier = 5; //must be larger, for now it is here to keep in low speed
        public static final double turnSpeedMultiplier = 5; //still not turning
        public static final double speedMetersPerSecond = Units.feetToMeters(4) * speedMultiplier;
        public static double speedRadiansPerSecond = 0.5*Math.PI * turnSpeedMultiplier;
    }

    public static class Intake {
        public static final int armID = 6;
        public static final int spinID = 7;

        // Positions
        public static final double armOutPosition = 0;
        public static final double armInPosition = 0;

        // Speeds
        public static final double intakeStoppedSpeed = 0;
        public static final double intakeTakeInSpeed = 0.6;
        public static final double intakeShootOutSpeed = -0.6;

        // PID
        public static final double armP = 0;
        public static final double armI = 0;
        public static final double armD = 0;

        public static final double intakeP = 0;
        public static final double intakeI = 0;
        public static final double intakeD = 0;
    }

    public static class Conveyer {
        public static final int conveyerID = 11;

        public static final double conveyerStoppedSpeed = 0;
        public static final double conveyerTakeInSpeed = 0.6;
        public static final double conveyerShootOutSpeed = -0.6;

        public static final double conveyerP = 0;
        public static final double conveyerI = 0;
        public static final double conveyerD = 0;
    }

    public static class Launch {
        public static final int launchMotorID = 8;
        public static final int launchMotorFollowerID = 9;
    }

    public static class AutoTrajectoryFileNames{
        public static final String TEST_STRAIGHT = "Test Straight Path";
        public static final String TEST_CURVE = "Test Curve Path";
        public static final String TWO_NOTE = "2 Note Auto";
        public static final String ONE_MORE_NOTE = "1 More Note Auto";
    }
    
}
