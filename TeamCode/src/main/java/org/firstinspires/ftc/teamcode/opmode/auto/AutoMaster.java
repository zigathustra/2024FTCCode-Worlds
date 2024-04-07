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
    protected Alliance alliance;
    protected StartPosition startPosition;
    int riggingDirection;
    int boardDirection;

    public static boolean loggingOn = false;

    Action selectedTrajectory;
    int targetAprilTagNumber;
    PropPipeline propProcessor = null;
    AprilTagProcessor aprilTagProcessor;
    PropDirection propDirection = null;
    ElapsedTime timer = new ElapsedTime();
    FtcDashboard dashboard = FtcDashboard.getInstance();
    MultipleTelemetry tele = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

    protected AutoBot bot;
    protected VisionSensor visionSensor;
    protected TrajectorySequence leftTrajectorySequence;
    protected TrajectorySequence centerTrajectorySequence;
    protected TrajectorySequence rightTrajectorySequence;
    protected TrajectorySequence selectedTrajectorySequence;
    protected Pose2d startPose, leftSpikePose, rightSpikePose, leftBoardPose, rightBoardPose, centerBoardPose, parkPose;
    protected AutoConstants autoConstants = new AutoConstants();

    protected AutoMaster(Alliance alliance, StartPosition startPosition) {
        this.alliance = alliance;
        this.startPosition = startPosition;
    }

    @Override
    public void runOpMode() {
        bot = new AutoBot(hardwareMap, telemetry, startPose, loggingOn);

//        visionSensor = new VisionSensor(this, alliance);

//        riggingDirection = determineRiggingDirection();

//        boardDirection = determineBoardDirection(riggingDirection);

//        visionSensor.goToPropDetectionMode();

        bot.handlerRetract();
        bot.stopLoad();
        leftTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .forward(autoConstants.INITIAL_FORWARD_DIST)
                .splineToLinearHeading(leftSpikePose, leftSpikePose.getHeading())
                .splineToLinearHeading(leftBoardPose, leftBoardPose.getHeading())
                .lineToLinearHeading(parkPose)
                .build();

        rightTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .forward(autoConstants.INITIAL_FORWARD_DIST)
                .splineToLinearHeading(rightSpikePose, rightSpikePose.getHeading())
                .splineToLinearHeading(rightBoardPose, rightBoardPose.getHeading())
                .lineToLinearHeading(parkPose)
                .build();

        centerTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                .forward(autoConstants.MIDDLE_SPIKE_DISTANCE)
                .addTemporalMarker(() -> placePixelOnSpikeMark())
                .waitSeconds(3)
                .back(autoConstants.INITIAL_FORWARD_DIST)
                .splineToLinearHeading(centerBoardPose, centerBoardPose.getHeading())
                .addTemporalMarker(() -> placePixelOnBoard())
                .waitSeconds(3)
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
        if (!isStopRequested()) {
            //           visionSensor.goToNoSensingMode();
            selectedTrajectorySequence = selectTrajectorySequence();

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
        bot.dropPixel();
    }

    protected void placePixelOnBoard() {
        bot.dropPixel();
    }
}
