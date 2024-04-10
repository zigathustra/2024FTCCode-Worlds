package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.blueCenterSpikePose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCenterBackdrop;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCenterSpikePose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redCornerParkPose;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.redLeftBackdrop;
import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.reflectY;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;

public class NearBoard extends AutoMaster {
    protected NearBoard(Alliance alliance, ParkPosition parkPosition) {
        super(StartPosition.NEAR);
        if (alliance == alliance.RED) {
            startPose = AutoConstants.redNearStartPose;
            leftSpikePose = AutoConstants.redLeftSpikePose;
            centerSpikePose = AutoConstants.redCenterSpikePose;
            rightSpikePose = AutoConstants.redRightSpikePose;

            leftBoardPose = AutoConstants.redLeftBackdrop;
            rightBoardPose = AutoConstants.redRightBackdrop;
            centerBoardPose = AutoConstants.redCenterBackdrop;
            if (parkPosition == ParkPosition.CORNER) {
                escapePose = AutoConstants.redEscapeCornerPose;
                parkPose = AutoConstants.redCornerParkPose;
            } else
            {
                escapePose = AutoConstants.redEscapeCenterPose;
                parkPose = AutoConstants.redCenterParkPose;
            }
        } else {
            startPose = AutoConstants.blueNearStartPose;
            leftSpikePose = AutoConstants.blueLeftSpikePose;
            centerSpikePose = AutoConstants.blueCenterSpikePose;
            rightSpikePose = AutoConstants.blueRightSpikePose;
            leftBoardPose = AutoConstants.blueLeftBackdrop;
            rightBoardPose = AutoConstants.blueRightBackdrop;
            centerBoardPose = AutoConstants.blueCenterBackdrop;
            parkPose = AutoConstants.blueCornerParkPose;
            if (parkPosition == ParkPosition.CORNER) {
                escapePose = AutoConstants.blueEscapeCornerPose;
                parkPose = AutoConstants.blueCornerParkPose;
            }
            else
            {
                escapePose = AutoConstants.blueEscapeCenterPose;
                parkPose = AutoConstants.blueCenterParkPose;
            }
        }
    }
}