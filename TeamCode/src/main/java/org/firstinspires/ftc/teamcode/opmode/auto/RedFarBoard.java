package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;

@Autonomous(name = "\uD83D\uDD25RedFarBoard", group = "Auto")
public class RedFarBoard extends FarBoard {
    public RedFarBoard() {
        super(Alliance.RED);
    }
}