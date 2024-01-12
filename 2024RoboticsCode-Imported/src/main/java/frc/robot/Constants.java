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

    public static class Intake {
        public static final int armID = 6;
        public static final int spinID = 7;

        public static final double armOutPosition = 0;
        public static final double armInPosition = 0;

        public static final double intakeStoppedSpeed = 0;
        public static final double intakeTakeInSpeed = 0.7;
        public static final double intakeShootOutSpeed = -0.7;
    }

    public static class Launch {
        public static final int launchMotorID = 8;
        public static final int launchMotorFollowerID = 9;
    }
    
}
