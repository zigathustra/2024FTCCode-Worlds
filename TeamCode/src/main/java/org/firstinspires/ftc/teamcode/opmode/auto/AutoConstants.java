package org.firstinspires.ftc.teamcode.opmode.auto;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;

// BLUE AUTO POSITIONS
@Config
public final class AutoConstants {
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
    public static double boardApproachOffset = 9.5;
    public static Pose2d blueCenterSpikePose = new Pose2d(tileSideLength + 3, maxY - tileSideLength * 1.5, Math.toRadians(223));
    public static Pose2d redCenterSpikePose = reflectY(blueCenterSpikePose);
    public static Pose2d blueRightSpikePose = new Pose2d(tileSideLength * 1.65, maxY - tileSideLength * 1.50, Math.toRadians(180));
    public static Pose2d redRightSpikePose = reflectY(blueRightSpikePose);
    public static Pose2d blueEscapePose = new Pose2d(tileSideLength + 6, maxY-botFrameWidth/2 - 4.5, Math.toRadians(180));
    public static Pose2d redEscapePose = reflectY(blueEscapePose);
    public static Pose2d blueNearStartPose = new Pose2d(tileSideLength / 2.0, maxY - botCenterOffsetFromRear, Math.toRadians(-90));
    public static Pose2d redNearStartPose = reflectY(blueNearStartPose);
    public static Pose2d blueCenterBackdrop = new Pose2d(maxX - boardXOffset - boardApproachOffset, maxY - boardYOffset - boardAprilTagSpacing, Math.toRadians(0));
    public static Pose2d redCenterBackdrop = reflectY(blueCenterBackdrop);
    public static Pose2d blueRightBackdrop = new Pose2d(maxX - boardXOffset - boardApproachOffset, maxY - boardYOffset + 1.5, Math.toRadians(0));
    public static Pose2d redRightBackdrop = reflectY(blueRightBackdrop);
    public static Pose2d blueCornerParkPose= new Pose2d(maxX - botFrameLength * 1.25, maxY-botFrameWidth/2 - 4.5, Math.toRadians(180));
    public static Pose2d redCornerParkPose = reflectY(blueCornerParkPose);


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
    public static Pose2d reflectY(Pose2d pose) {
        return new Pose2d(pose.getX(), -pose.getY(), Math.toRadians(360) - pose.getHeading());
    }

}