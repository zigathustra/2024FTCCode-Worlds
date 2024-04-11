package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;

@Autonomous(name = "\uD83D\uDD35BlueFarBoardCenter", group = "Auto")
public class BlueFarBoardCenter extends FarBoard {
    public BlueFarBoardCenter()
    {
        super(Alliance.BLUE,ParkPosition.CENTER);
    }
}