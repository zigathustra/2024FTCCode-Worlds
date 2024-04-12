package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.AutoBot;
import org.firstinspires.ftc.teamcode.common.TeleopBot;
import org.firstinspires.ftc.teamcode.common.enums.PropDirection;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;
import org.firstinspires.ftc.teamcode.common.vision.PropPipeline;
import org.firstinspires.ftc.teamcode.common.vision.VisionSensor;
import org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

@Config
@TeleOp(name = "LiftTestAuto", group = "Linear OpMode")
public class LiftTestAuto extends LinearOpMode {

    public static boolean loggingOn = false;
    private ElapsedTime timer = new ElapsedTime();
    protected AutoBot bot;
    protected MultipleTelemetry multipleTelemetry;

    private double leftTrigger, rightTrigger;
    double liftPowerFactor = 0.5;

    @Override
    public void runOpMode() {
        multipleTelemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Initializing.");
        telemetry.update();

        bot = new AutoBot(hardwareMap, multipleTelemetry, true);
        bot.drivetrain().setPoseEstimate(new Pose2d(0, 0, 0));
        telemetry.addLine("Bot created.");
        telemetry.update();
        waitForStart();

        while (!isStopRequested() && opModeIsActive()) {

            leftTrigger = gamepad1.left_trigger;
            rightTrigger = gamepad1.right_trigger;
            if (leftTrigger > 0.3) {
                bot.liftManualDown(leftTrigger * liftPowerFactor);
            } else if (rightTrigger > 0.3) {
                bot.liftManualUp(rightTrigger * liftPowerFactor);
            } else {
                bot.liftStop();
            }

            if (gamepad1.triangle) {
                bot.handlerDeployLevel1();
            } else if (gamepad1.circle) {
                bot.handlerRetract();
            }
            bot.update();
        }
    }
}