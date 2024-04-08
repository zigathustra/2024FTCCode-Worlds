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
    protected static TrajectorySequence leftTrajectorySequence, centerTrajectorySequence, rightTrajectorySequence, selectedTrajectorySequence;
    protected Pose2d startPose, leftSpikePose, rightSpikePose, leftBoardPose, rightBoardPose, centerBoardPose, parkPose;
    protected MultipleTelemetry multipleTelemetry;

    protected AutoMaster() {

    }

    @Override
    public void runOpMode() {

        multipleTelemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        bot = new AutoBot(hardwareMap, multipleTelemetry, startPose, loggingOn);

//        visionSensor = new VisionSensor(this, alliance);

//        visionSensor.goToPropDetectionMode();

//        bot.handlerRetract();
///        bot.stopLoad();

        leftTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .forward(AutoConstants.INITIAL_FORWARD_DISTANCE)
                .splineToLinearHeading(leftSpikePose, leftSpikePose.getHeading())
                .splineToLinearHeading(leftBoardPose, leftBoardPose.getHeading())
                .lineToLinearHeading(parkPose)
                .build();

        rightTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .forward(AutoConstants.INITIAL_FORWARD_DISTANCE)
                .splineToLinearHeading(rightSpikePose, rightSpikePose.getHeading())
                .splineToLinearHeading(rightBoardPose, rightBoardPose.getHeading())
                .lineToLinearHeading(parkPose)
                .build();

        centerTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
//                .addTemporalMarker(()->bot.handlerDeploy())
                .forward(AutoConstants.CENTER_SPIKE_DISTANCE)
//                .addTemporalMarker(() -> placePixelOnSpikeMark())
                .waitSeconds(1)
                .back(AutoConstants.INITIAL_FORWARD_DISTANCE)
                .splineToLinearHeading(centerBoardPose, centerBoardPose.getHeading())
//                .addTemporalMarker(() -> placePixelOnBoard())
                .waitSeconds(1)
                .splineToLinearHeading(parkPose, parkPose.getHeading())
                .build();

        sleep(500);
        while (!isStarted() && !isStopRequested()) {

            //           propDirection = visionSensor.getPropDirection();
            propDirection = PropDirection.CENTER;
            telemetry.addData("Prop Position: ", propDirection);
            telemetry.update();

            sleep(50);
        }
        if (!isStopRequested() && isStarted()) {
            //           visionSensor.goToNoSensingMode();
              bot.drivetrain().followTrajectorySequenceAsync(selectedTrajectorySequence);
//            bot.drivetrain().followTrajectorySequence(selectTrajectorySequence());
//            bot.handlerDeploy();
        }
        while (!isStopRequested() && opModeIsActive())
        {
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
    protected void placePixelOnSpikeMark() {
        bot.handlerDeploy();
        bot.dropPixel();
    }

    protected void placePixelOnBoard() {
        bot.dropPixel();
    }
}
