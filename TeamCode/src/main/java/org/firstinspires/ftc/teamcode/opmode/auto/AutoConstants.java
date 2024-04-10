package org.firstinspires.ftc.teamcode.opmode.auto;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;

// BLUE AUTO POSITIONS
@Config
public final class AutoConstants {
    // Field, features, and bot dimensions
    public static double fieldX = 144;
    public static double fieldY = 144;
    public static double maxX = fieldX / 2.0;
    public static double maxY = fieldY / 2.0;
    public static double botFrameWidth = 14.125;
    public static double botFrameLength = 17;
    public static double botCenterOffsetFromFront = 7.95 + .75;
    public static double botCenterOffsetFromRear = botFrameLength - botCenterOffsetFromFront;
    public static double botCenterOffsetFromLeft = botFrameWidth / 2.0;
    public static double tileSideLength = 24;
    public static double boardXOffset = 10.75;
    public static double boardYOffset = 25.5 + 5.25;
    public static double boardAprilTagSpacing = 6;

    // Maneuver constants
    public static double boardApproachOffset = 9.25;

    // Near start poses
    public static Pose2d blueNearStartPose = new Pose2d(tileSideLength / 2.0, maxY - botCenterOffsetFromRear, Math.toRadians(-90));
    public static Pose2d redNearStartPose = reflectY(blueNearStartPose);

    // Near spike mark poses
    public static Pose2d blueNearCenterSpikePose = new Pose2d(tileSideLength + 0.75, maxY - 36, Math.toRadians(223));
    public static Pose2d redNearCenterSpikePose = reflectY(blueNearCenterSpikePose);
    public static Pose2d blueNearLeftSpikePose = new Pose2d(37, maxY - 36, Math.toRadians(180));
    public static Pose2d redNearRightSpikePose = reflectY(blueNearLeftSpikePose);
    public static Pose2d blueNearRightSpikePose = new Pose2d(15.25, maxY - tileSideLength * 1.50, Math.toRadians(180));
    public static Pose2d redNearLeftSpikePose = reflectY(blueNearRightSpikePose);

    // Near navigation poses
    public static Pose2d blueNearEscapeCornerPose = new Pose2d(tileSideLength + 10, maxY-botFrameWidth/2 - 4.5, Math.toRadians(180));
    public static Pose2d redNearEscapeCornerPose = reflectY(blueNearEscapeCornerPose);
    public static Pose2d blueNearEscapeCenterPose = new Pose2d(tileSideLength + 10, maxY-botFrameWidth/2 - 4.5 - 45, Math.toRadians(180));
    public static Pose2d redNearEscapeCenterPose = reflectY(blueNearEscapeCenterPose);

    // Far start poses
    public static Pose2d blueFarStartPose =reflectX(blueNearStartPose);
    public static Pose2d redFarStartPose = reflectY(blueFarStartPose);

    // Far spike mark poses
    public static Pose2d blueFarLeftSpikePose = reflectX(blueNearLeftSpikePose);
    public static Pose2d redFarLeftSpikePose = reflectY(blueFarLeftSpikePose);
    public static Pose2d blueFarCenterSpikePose = reflectX(blueNearCenterSpikePose);
    public static Pose2d redFarCenterSpikePose = reflectY(blueFarCenterSpikePose);
    public static Pose2d blueFarRightSpikePose = reflectX(blueNearRightSpikePose);
    public static Pose2d redFarRightSpikePose = reflectY(blueFarRightSpikePose);


    // Far navigation poses
    public static Pose2d blueFarOutsideStartPose = new Pose2d(-maxX + 16, maxY - 24, Math.toRadians(0));
    public static Pose2d redFarOutsideStartPose = reflectY(blueFarOutsideStartPose);
    public static Pose2d blueFarMainstreetStartPose = new Pose2d(-maxX + 16, maxY - 60, Math.toRadians(0));
    public static Pose2d redFarMainstreetStartPose = reflectY(blueFarMainstreetStartPose);
    public static Pose2d blueFarMainstreetEndPose = new Pose2d(maxX - 36, maxY - 60, Math.toRadians(0));
    public static Pose2d redFarMainstreetEndPose = reflectY(blueFarMainstreetStartPose);

    // Board poses (same for near and far)
    public static Pose2d blueCenterBackdrop = new Pose2d(maxX - boardXOffset - boardApproachOffset, maxY - boardYOffset - boardAprilTagSpacing + 0.5, Math.toRadians(0));
    public static Pose2d redCenterBackdrop = reflectY(blueCenterBackdrop);
    public static Pose2d blueLeftBackdrop = new Pose2d(maxX - boardXOffset - boardApproachOffset, maxY - boardYOffset + 1.5, Math.toRadians(0));
    public static Pose2d redRightBackdrop = reflectY(blueLeftBackdrop);
    public static Pose2d blueRightBackdrop = new Pose2d(maxX - boardXOffset - boardApproachOffset, maxY - boardYOffset - boardAprilTagSpacing*2 + 3, Math.toRadians(0));
    public static Pose2d redLeftBackdrop = reflectY(blueRightBackdrop);

    public static Pose2d blueCornerParkPose= new Pose2d(maxX - botFrameLength * 1.25, maxY-botFrameWidth/2 - 4.5, Math.toRadians(180));
    public static Pose2d redCornerParkPose = reflectY(blueCornerParkPose);
    public static Pose2d blueCenterParkPose= new Pose2d(maxX - botFrameLength * 1.25, maxY-botFrameWidth/2 - 4.5 - 45, Math.toRadians(180));
    public static Pose2d redCenterParkPose = reflectY(blueCenterParkPose);


    // SPIKE & BACKDROP POSITIONS
    public static PoseValues V_NEAR_LEFT_SPIKE = new PoseValues(15.5, 37, 320);
    public static PoseValues V_FAR_LEFT_SPIKE = new PoseValues(-32, 37, 320);
    public static PoseValues V_LEFT_BACKDROP_PRE = new PoseValues(37.5, 42 - 2, 0);
    public static PoseValues V_LEFT_BACKDROP = new PoseValues(42, 42 - 2, 0);

    // MISC POSITIONS
    public static PoseValues V_NEAR_INITIAL = new PoseValues(11.75, 44, 270);
    public static PoseValues V_FAR_INITIAL = new PoseValues(-35.25, 44, 270);
    public static PoseValues V_NEAR_MID = new PoseValues(27.5, 11, 0);


    // SPIKE & BACKDROP POSITIONS
    public static Pose2d NEAR_LEFT_SPIKE = new Pose2d(V_NEAR_LEFT_SPIKE.x, V_NEAR_LEFT_SPIKE.y, V_NEAR_LEFT_SPIKE.heading);

    public static Pose2d FAR_LEFT_SPIKE = new Pose2d(V_FAR_LEFT_SPIKE.x, V_FAR_LEFT_SPIKE.y, V_FAR_LEFT_SPIKE.heading);

    public static Pose2d LEFT_BACKDROP_PRE = new Pose2d(V_LEFT_BACKDROP_PRE.x, V_LEFT_BACKDROP_PRE.y, V_LEFT_BACKDROP_PRE.heading);


    public static Pose2d LEFT_BACKDROP = new Pose2d(V_LEFT_BACKDROP.x, V_LEFT_BACKDROP.y, V_LEFT_BACKDROP.heading);


    // MISC POSITIONS
    public static Pose2d NEAR_INITIAL = new Pose2d(V_NEAR_INITIAL.x, V_NEAR_INITIAL.y, V_NEAR_INITIAL.heading);

    public static Pose2d FAR_INITIAL = new Pose2d(V_FAR_INITIAL.x, V_FAR_INITIAL.y, V_FAR_INITIAL.heading);

    public static Pose2d NEAR_MID = new Pose2d(V_NEAR_MID.x, V_NEAR_MID.y, V_NEAR_MID.heading);


    // FOR RED AUTO
    public static Pose2d reflectX(Pose2d pose) {
        return new Pose2d(-pose.getX(), pose.getY(), pose.getHeading());
    }
    public static Pose2d reflectY(Pose2d pose) {
        return new Pose2d(pose.getX(), -pose.getY(), Math.toRadians(360) - pose.getHeading());
    }

}