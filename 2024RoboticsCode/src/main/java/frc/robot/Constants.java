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
        public static final int turnAxis = 4;

        public static final double speedMetersPerSecond = Units.feetToMeters(4);
        public static double speedRadiansPerSecond = 0.5*Math.PI;
    }
    
}
