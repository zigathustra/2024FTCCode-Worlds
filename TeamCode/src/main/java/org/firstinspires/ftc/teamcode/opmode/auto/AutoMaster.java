package org.firstinspires.ftc.teamcode.opmode.auto;

import static org.firstinspires.ftc.teamcode.opmode.auto.AutoConstants.reflectY;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.apache.commons.math3.ode.events.Action;
import org.firstinspires.ftc.teamcode.common.AutoBot;
import org.firstinspires.ftc.teamcode.common.enums.Alliance;
import org.firstinspires.ftc.teamcode.common.enums.PropDirection;
import org.firstinspires.ftc.teamcode.common.enums.StartPosition;
import org.firstinspires.ftc.teamcode.common.vision.PropPipeline;
import org.firstinspires.ftc.teamcode.common.vision.VisionSensor;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public abstract class AutoMaster extends LinearOpMode {

    public static boolean loggingOn = false;
    private AprilTagProcessor aprilTagProcessor;
    private PropDirection propDirection;
    private ElapsedTime timer = new ElapsedTime();

    protected AutoBot bot;
    private PropPipeline propProcessor;

    protected VisionSensor visionSensor;
    protected static TrajectorySequence leftTrajectorySequence, centerTrajectorySequence, rightTrajectorySequence;
    protected Pose2d startPose, leftSpikePose, centerSpikePose, rightSpikePose, escapePose, leftBoardPose, rightBoardPose, centerBoardPose, parkPose;
    protected MultipleTelemetry multipleTelemetry;

    protected AutoMaster()
    {
    }

    @Override
    public void runOpMode() {

        multipleTelemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        bot = new AutoBot(hardwareMap, multipleTelemetry, loggingOn);
        bot.drivetrain().setPoseEstimate(startPose);

//        visionSensor = new VisionSensor(this, alliance);

//        visionSensor.goToPropDetectionMode();

//        bot.handlerRetract();
///        bot.stopLoad();

        leftTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
//                .forward(AutoConstants.initialForwardDistance)
//                .splineToLinearHeading(leftSpikePose, leftSpikePose.getHeading())
                .lineToLinearHeading(parkPose)
                .build();

        centerTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .addTemporalMarker(() -> bot.handlerDeployLevel1())
                .splineToLinearHeading(centerBoardPose, centerBoardPose.getHeading())
                .addTemporalMarker(() -> bot.dropPixel())
                .waitSeconds(0.5)
                .addTemporalMarker(() -> bot.liftToCruisePosition())
                .waitSeconds(0.5)
                .back(AutoConstants.boardApproachOffset)
                .splineToLinearHeading(centerSpikePose, centerSpikePose.getHeading())
                .addTemporalMarker(() -> bot.goToGroundPlacementPosition())
                .waitSeconds(0.75)
                .addTemporalMarker(() -> bot.dropPixel())
                .waitSeconds(0.75)
                .back(4)
                .splineToLinearHeading(escapePose, escapePose.getHeading())
                .splineToLinearHeading(parkPose, parkPose.getHeading())
                .addTemporalMarker(() -> bot.tuckDropper())
                .waitSeconds(3)
                .build();

        rightTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .addTemporalMarker(() -> bot.handlerDeployLevel1())
                .splineToLinearHeading(rightBoardPose, rightBoardPose.getHeading())
                .addTemporalMarker(() -> bot.dropPixel())
                .waitSeconds(0.5)
                .back(4)
                .addTemporalMarker(() -> bot.liftToCruisePosition())
                .waitSeconds(0.5)
                .back(AutoConstants.boardApproachOffset)
                .splineToLinearHeading(rightSpikePose, rightSpikePose.getHeading())
                .addTemporalMarker(() -> bot.goToGroundPlacementPosition())
                .waitSeconds(0.75)
                .addTemporalMarker(() -> bot.dropPixel())
                .waitSeconds(0.75)
                .splineToLinearHeading(parkPose, parkPose.getHeading())
                .UNSTABLE_addTemporalMarkerOffset(-2.5, () -> bot.tuckDropper())
                .waitSeconds(3)
                .build();


        sleep(500);
        while (!isStarted() && !isStopRequested()) {

            //           propDirection = visionSensor.getPropDirection();
            propDirection = PropDirection.CENTER;
            telemetry.addData("Prop Position: ", propDirection);
            telemetry.update();

            sleep(50);
        }
        //           visionSensor.goToNoSensingMode();

        bot.drivetrain().followTrajectorySequenceAsync(centerTrajectorySequence);

        while (!isStopRequested() && opModeIsActive()) {
            bot.update();
            bot.drivetrain().update();
        }
    }

    protected TrajectorySequence selectTrajectorySequence() {
        if (propDirection == PropDirection.LEFT) {
            return leftTrajectorySequence;
        } else if (propDirection == PropDirection.RIGHT) {
            return rightTrajectorySequence;
        } else {
            return centerTrajectorySequence;
        }

    }

    protected void placePixelOnBoard() {
        bot.dropPixel();
    }
}
