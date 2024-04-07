package org.firstinspires.ftc.teamcode.opmode.auto;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;

// BLUE AUTO POSITIONS
@Config
public final class AutoConstants {
    public static double INITIAL_FORWARD_DISTANCE = 15.5;
    public static double CENTER_SPIKE_DISTANCE = 29;
    public static double ARM_LIFT_DELAY = -2.25;
    public static double PRELOAD_SCORE_DELAY = -2;
    public static double POST_PRELOAD_WAIT = 0.5;
    public static double STACK_PICKUP_DELAY = 2.5;
    public static double POST_APRILTAG_FORWARD = 5; // this used to be 4.5 in 2+2
    public static int APRILTAG_TIMEOUT = 2000;

    // STARTING & END POSITIONS
    public Pose2d NEAR_START;
    public Pose2d FAR_START;
    public Pose2d PARK_CORNER;
    public Pose2d PARK_CENTER;
    public Pose2d PARK_BOARD;

    // SPIKE & BACKDROP POSITIONS
    public Pose2d NEAR_LEFT_SPIKE;
    public Pose2d NEAR_RIGHT_SPIKE;
    public Pose2d FAR_LEFT_SPIKE;
    public Pose2d FAR_RIGHT_SPIKE;
    public Pose2d LEFT_BACKDROP_PRE;
    public Pose2d CENTER_BACKDROP_PRE;
    public Pose2d RIGHT_BACKDROP_PRE;
    public Pose2d LEFT_BACKDROP;
    public Pose2d CENTER_BACKDROP;
    public Pose2d RIGHT_BACKDROP;

    // MISC POSITIONS
    public Pose2d NEAR_INITIAL;
    public Pose2d FAR_INITIAL;
    public Pose2d NEAR_MID;

    public static PoseValues V_NEAR_START = new PoseValues(11.75, 62.7, 270);
    public static PoseValues V_FAR_START = new PoseValues(-35.25, 62.7, 270);
    public static PoseValues V_PARK_BOARD = new PoseValues(48, 57, 0);

    // SPIKE & BACKDROP POSITIONS
    public static PoseValues V_NEAR_LEFT_SPIKE = new PoseValues(15.5, 37, 320);
    public static PoseValues V_NEAR_RIGHT_SPIKE = new PoseValues(7.5, 37, 220);
    public static PoseValues V_FAR_LEFT_SPIKE = new PoseValues(-32, 37, 320);
    public static PoseValues V_FAR_RIGHT_SPIKE = new PoseValues(-39, 37, 220);
    public static PoseValues V_LEFT_BACKDROP_PRE = new PoseValues(37.5, 42 - 2, 0);
    public static PoseValues V_CENTER_BACKDROP_PRE = new PoseValues(48, 33.5, 0);
    public static PoseValues V_RIGHT_BACKDROP_PRE = new PoseValues(37.5, 30 - 2, 0);
    public static PoseValues V_LEFT_BACKDROP = new PoseValues(42, 42 - 2, 0);
    public static PoseValues V_CENTER_BACKDROP = new PoseValues(42, 36 - 2, 0);
    public static PoseValues V_RIGHT_BACKDROP = new PoseValues(42, 30 - 2, 0);

    // MISC POSITIONS
    public static PoseValues V_NEAR_INITIAL = new PoseValues(11.75, 44, 270);
    public static PoseValues V_FAR_INITIAL = new PoseValues(-35.25, 44, 270);
    public static PoseValues V_NEAR_MID = new PoseValues(27.5, 11, 0);

    public AutoConstants() {
        INITIAL_FORWARD_DISTANCE = 15.5;
        CENTER_SPIKE_DISTANCE = 31.5;
        ARM_LIFT_DELAY = -2.25;
        PRELOAD_SCORE_DELAY = -0.5;
        POST_PRELOAD_WAIT = 0.5;
        STACK_PICKUP_DELAY = 1;
        POST_APRILTAG_FORWARD = 6.16; // this used to be 4.5 in 2+2
        APRILTAG_TIMEOUT = 1000;

        NEAR_START = new Pose2d(V_NEAR_START.x, V_NEAR_START.y, V_NEAR_START.heading);
        FAR_START = new Pose2d(V_FAR_START.x, V_FAR_START.y, V_FAR_START.heading);
        PARK_BOARD = new Pose2d(V_PARK_BOARD.x, V_PARK_BOARD.y, V_PARK_BOARD.heading);

// SPIKE & BACKDROP POSITIONS
        NEAR_LEFT_SPIKE = new Pose2d(V_NEAR_LEFT_SPIKE.x, V_NEAR_LEFT_SPIKE.y, V_NEAR_LEFT_SPIKE.heading);
        NEAR_RIGHT_SPIKE = new Pose2d(V_NEAR_RIGHT_SPIKE.x, V_NEAR_RIGHT_SPIKE.y, V_NEAR_RIGHT_SPIKE.heading);
        FAR_LEFT_SPIKE = new Pose2d(V_FAR_LEFT_SPIKE.x, V_FAR_LEFT_SPIKE.y, V_FAR_LEFT_SPIKE.heading);
        FAR_RIGHT_SPIKE = new Pose2d(V_FAR_RIGHT_SPIKE.x, V_FAR_RIGHT_SPIKE.y, V_FAR_RIGHT_SPIKE.heading);
        LEFT_BACKDROP_PRE = new Pose2d(V_LEFT_BACKDROP_PRE.x, V_LEFT_BACKDROP_PRE.y, V_LEFT_BACKDROP_PRE.heading);
        CENTER_BACKDROP_PRE = new Pose2d(V_CENTER_BACKDROP_PRE.x, V_CENTER_BACKDROP_PRE.y, V_CENTER_BACKDROP_PRE.heading);
        RIGHT_BACKDROP_PRE = new Pose2d(V_RIGHT_BACKDROP_PRE.x, V_RIGHT_BACKDROP_PRE.y, V_RIGHT_BACKDROP_PRE.heading);
        LEFT_BACKDROP = new Pose2d(V_LEFT_BACKDROP.x, V_LEFT_BACKDROP.y, V_LEFT_BACKDROP.heading);
        CENTER_BACKDROP = new Pose2d(V_CENTER_BACKDROP.x, V_CENTER_BACKDROP.y, V_CENTER_BACKDROP.heading);
        RIGHT_BACKDROP = new Pose2d(V_RIGHT_BACKDROP.x, V_RIGHT_BACKDROP.y, V_RIGHT_BACKDROP.heading);

// MISC POSITIONS
        NEAR_INITIAL = new Pose2d(V_NEAR_INITIAL.x, V_NEAR_INITIAL.y, V_NEAR_INITIAL.heading);
        FAR_INITIAL = new Pose2d(V_FAR_INITIAL.x, V_FAR_INITIAL.y, V_FAR_INITIAL.heading);
        NEAR_MID = new Pose2d(V_NEAR_MID.x, V_NEAR_MID.y, V_NEAR_MID.heading);
    }

    // FOR RED AUTO
    public static Pose2d reflectY(Pose2d pose) {
        return new Pose2d(pose.getX(), -pose.getY(), Math.toRadians(360) - pose.getHeading());
    }

}