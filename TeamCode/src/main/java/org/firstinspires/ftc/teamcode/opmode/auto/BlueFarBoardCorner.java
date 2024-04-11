package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;

@Autonomous(name = "\uD83D\uDD35BlueFarBoardCorner", group = "Auto")
public class BlueFarBoardCorner extends FarBoard {
    public BlueFarBoardCorner()
    {
        super(Alliance.BLUE,ParkPosition.CORNER);
    }
}