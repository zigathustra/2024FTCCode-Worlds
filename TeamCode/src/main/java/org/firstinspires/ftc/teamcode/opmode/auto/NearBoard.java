package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.reflectY;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;

public class NearBoard extends AutoMaster {

    protected NearBoard(Alliance alliance)
    {
        super(alliance, StartPosition.NEAR);
        if (alliance == alliance.RED)
        {
            startPose =  reflectY(autoConstants.CLOSE_START);
            leftSpikePose = reflectY(autoConstants.CLOSE_LEFT_SPIKE);
            rightSpikePose = reflectY(autoConstants.CLOSE_RIGHT_SPIKE);
            leftBoardPose = reflectY(autoConstants.LEFT_BACKDROP);
            rightBoardPose = reflectY(autoConstants.RIGHT_BACKDROP);
            centerBoardPose = reflectY(autoConstants.MIDDLE_BACKDROP);
            parkPose = reflectY(autoConstants.CLOSE_PARK);
        }
    }
}