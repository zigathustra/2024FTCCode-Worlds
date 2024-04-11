package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.ParkPosition;

@Autonomous(name = "\uD83D\uDD25RedFarBoardCenter", group = "Auto")
public class RedFarBoardCenter extends FarBoard {
    public RedFarBoardCenter()
    {
        super(Alliance.RED,ParkPosition.CENTER);
    }
}