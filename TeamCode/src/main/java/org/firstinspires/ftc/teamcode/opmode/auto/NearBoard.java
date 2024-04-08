package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.reflectY;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;

public class NearBoard extends AutoMaster {
    protected NearBoard(Alliance alliance, ParkPosition parkPosition) {
        if (alliance == alliance.RED) {
            startPose = reflectY(AutoConstants.NEAR_START);
            leftSpikePose = reflectY(AutoConstants.NEAR_LEFT_SPIKE);
            rightSpikePose = reflectY(AutoConstants.NEAR_RIGHT_SPIKE);
            leftBoardPose = reflectY(AutoConstants.LEFT_BACKDROP);
            rightBoardPose = reflectY(AutoConstants.RIGHT_BACKDROP);
            centerBoardPose = reflectY(AutoConstants.CENTER_BACKDROP);
            if (parkPosition == ParkPosition.CORNER)
                parkPose = reflectY(AutoConstants.PARK_CORNER);
            else if (parkPosition == ParkPosition.CENTER) {
                parkPose = reflectY(AutoConstants.PARK_CENTER);
            } else {
                parkPose = reflectY(AutoConstants.PARK_BOARD);
            }
        } else
        {
            startPose = AutoConstants.NEAR_START;
            leftSpikePose = AutoConstants.NEAR_LEFT_SPIKE;
            rightSpikePose = AutoConstants.NEAR_RIGHT_SPIKE;
            leftBoardPose = AutoConstants.LEFT_BACKDROP;
            rightBoardPose = AutoConstants.RIGHT_BACKDROP;
            centerBoardPose = AutoConstants.CENTER_BACKDROP;
            if (parkPosition == ParkPosition.CORNER)
                parkPose = AutoConstants.PARK_CORNER;
            else if (parkPosition == ParkPosition.CENTER) {
                parkPose = AutoConstants.PARK_CENTER;
            } else {
                parkPose = AutoConstants.PARK_BOARD;
            }
        }
    }
}