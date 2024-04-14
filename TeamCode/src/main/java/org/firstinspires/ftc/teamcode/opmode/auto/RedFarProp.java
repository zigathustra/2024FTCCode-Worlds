package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.common.enums.Alliance;

@Autonomous(name = "\uD83D\uDD25RedFarPropPark", group = "Auto")
public class RedFarProp extends FarNoBoard {
    public RedFarProp()
    {
        super(Alliance.RED);
    }
}