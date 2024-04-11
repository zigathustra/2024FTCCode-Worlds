package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;

@Autonomous(name = "\uD83D\uDD25RedFarBoardCorner", group = "Auto")
public class RedFarBoardCorner extends FarBoard {
    public RedFarBoardCorner()
    {
        super(Alliance.RED,ParkPosition.CORNER);
    }
}