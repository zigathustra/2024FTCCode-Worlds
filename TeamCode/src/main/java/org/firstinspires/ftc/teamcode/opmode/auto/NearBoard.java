package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.blueCenterSpikePose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCenterBackdrop;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCenterSpikePose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCornerParkPose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.reflectY;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;

public class NearBoard extends AutoMaster {
    protected NearBoard(Alliance alliance, ParkPosition parkPosition) {
        if (alliance == alliance.RED) {
            startPose = AutoConstants.redNearStartPose;
            leftSpikePose = reflectY(AutoConstants.NEAR_LEFT_SPIKE);
            centerSpikePose = redCenterSpikePose;
            rightSpikePose = AutoConstants.redRightSpikePose;
            escapePose = AutoConstants.redEscapePose;
            leftBoardPose = reflectY(AutoConstants.LEFT_BACKDROP);
            rightBoardPose = AutoConstants.redRightBackdrop;
            centerBoardPose = AutoConstants.redCenterBackdrop;
            parkPose = AutoConstants.redCornerParkPose;

        } else {
            startPose = AutoConstants.blueNearStartPose;
            leftSpikePose = AutoConstants.NEAR_LEFT_SPIKE;
            centerSpikePose = blueCenterSpikePose;
            rightSpikePose = AutoConstants.blueRightSpikePose;
            escapePose = AutoConstants.blueEscapePose;
            leftBoardPose = AutoConstants.LEFT_BACKDROP;
            rightBoardPose = AutoConstants.blueRightBackdrop;
            centerBoardPose = AutoConstants.blueCenterBackdrop;
            parkPose = AutoConstants.blueCornerParkPose;
        }
    }
}