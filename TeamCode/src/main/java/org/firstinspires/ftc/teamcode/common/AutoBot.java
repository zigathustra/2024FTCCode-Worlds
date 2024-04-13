package org.firstinspires.ftc.teamcode.common;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.AutoDrivetrain3Wheel;
import org.firstinspires.ftc.teamcode.drive.AutoDrivetrain2Wheel;

public class AutoBot extends Bot {
    private final AutoDrivetrain3Wheel drivetrain;
    private Pose2d startPose;
    public AutoBot(HardwareMap hardwareMap, Telemetry telemetry, boolean loggingOn)
    {
        super(hardwareMap, telemetry, loggingOn);
        drivetrain = new AutoDrivetrain3Wheel(hardwareMap,telemetry, loggingOn);
    }

    public void placePurplePixel()
    {
    }

    public AutoDrivetrain3Wheel drivetrain()
    {
        return(drivetrain);
    }
}