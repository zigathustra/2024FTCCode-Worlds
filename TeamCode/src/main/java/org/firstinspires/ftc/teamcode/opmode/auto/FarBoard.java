package org.firstinspires.ftc.teamcode.opmode.auto;


import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;

public class FarBoard extends AutoMaster {
    protected FarBoard(Alliance alliance, ParkPosition parkPosition) {
        super(StartPosition.FAR);
        if (alliance == alliance.RED) {
            startPose = AutoConstants.redFarStartPose;
            leftSpikePose = AutoConstants.redFarLeftSpikePose;
            centerSpikePose = AutoConstants.redFarCenterSpikePose;
            rightSpikePose = AutoConstants.redFarRightSpikePose;
            leftBoardPose = AutoConstants.redLeftBackdrop;
            rightBoardPose = AutoConstants.redRightBackdrop;
            centerBoardPose = AutoConstants.redCenterBackdrop;
            farOutsideStartPose = AutoConstants.redFarOutsideStartPose;
            farMainstreetStartPose = AutoConstants.redFarMainstreetStartPose;
            farBoardHeadingCorrection = 2.55;
            farMainstreetEndPose = AutoConstants.redFarMainstreetEndPose;
            if (parkPosition == ParkPosition.CORNER) {
                escapePose = AutoConstants.redNearEscapeCornerPose;
                parkPose = AutoConstants.redCornerParkPose;
            }
            else
            {
                escapePose = AutoConstants.redNearEscapeCenterPose;
                parkPose = AutoConstants.redCenterParkPose;
            }
        } else {
            startPose = AutoConstants.blueFarStartPose;
            leftSpikePose = AutoConstants.blueFarLeftSpikePose;
            centerSpikePose = AutoConstants.blueFarCenterSpikePose;
            rightSpikePose = AutoConstants.blueFarRightSpikePose;
            leftBoardPose = AutoConstants.blueLeftBackdrop;
            rightBoardPose = AutoConstants.blueRightBackdrop;
            centerBoardPose = AutoConstants.blueCenterBackdrop;
            farOutsideStartPose = AutoConstants.blueFarOutsideStartPose;
            farMainstreetStartPose = AutoConstants.blueFarMainstreetStartPose;
            farBoardHeadingCorrection = -2.55;
            farMainstreetEndPose = AutoConstants.blueFarMainstreetEndPose;
            if (parkPosition == ParkPosition.CORNER) {
                escapePose = AutoConstants.blueNearEscapeCornerPose;
                parkPose = AutoConstants.blueCornerParkPose;
            }
            else
            {
                escapePose = AutoConstants.blueNearEscapeCenterPose;
                parkPose = AutoConstants.blueCenterParkPose;
            }
        }
    }
}