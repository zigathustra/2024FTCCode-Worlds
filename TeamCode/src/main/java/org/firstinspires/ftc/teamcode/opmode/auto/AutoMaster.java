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

    private StartPosition startPosition;
    protected VisionSensor visionSensor;
    protected static TrajectorySequence leftTrajectorySequence, centerTrajectorySequence, rightTrajectorySequence, selectedTrajectorySequence;
    protected Pose2d startPose, leftSpikePose, centerSpikePose, rightSpikePose, escapePose, leftBoardPose, rightBoardPose, centerBoardPose, parkPose;

    protected Pose2d farOutsideStartPose, farMainstreetStartPose, farMainstreetEndPose;
    protected MultipleTelemetry multipleTelemetry;

    protected AutoMaster(StartPosition startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public void runOpMode() {

        multipleTelemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Initializing.");
        telemetry.update();

        bot = new AutoBot(hardwareMap, multipleTelemetry, loggingOn);
        bot.drivetrain().setPoseEstimate(startPose);
        telemetry.addLine("Bot created.");
        telemetry.update();

        visionSensor = new VisionSensor(this);

        visionSensor.goToPropDetectionMode();

        if (startPosition == StartPosition.NEAR) {
            telemetry.addLine("Building NEAR trajectories.");
            telemetry.update();
            leftTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                    .addTemporalMarker(() -> bot.handlerDeployLevel1())
                    .splineToLinearHeading(leftBoardPose, leftBoardPose.getHeading())
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.5)
                    .addTemporalMarker(() -> bot.liftToCruisePosition())
                    .waitSeconds(0.5)
                    .back(AutoConstants.boardApproachOffset)
                    .splineToLinearHeading(leftSpikePose, leftSpikePose.getHeading())
//                    .UNSTABLE_addDisplacementMarkerOffset(-6, () -> bot.goToGroundPlacementPosition())
                    .waitSeconds(0.25)
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.75)
                    .back(4)
                    .lineToLinearHeading(escapePose)
                    .lineToLinearHeading(parkPose)
                    .addDisplacementMarker(() -> bot.tuckDropper())
                    .waitSeconds(3)
                    .build();

            telemetry.addLine("Left near traj built.");
            telemetry.update();
            centerTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                    .addTemporalMarker(() -> bot.handlerDeployLevel1())
                    .splineToLinearHeading(centerBoardPose, centerBoardPose.getHeading())
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.5)
                    .addTemporalMarker(() -> bot.liftToCruisePosition())
                    .waitSeconds(0.5)
                    .back(AutoConstants.boardApproachOffset)
                    .splineToLinearHeading(centerSpikePose, centerSpikePose.getHeading())
//                    .UNSTABLE_addDisplacementMarkerOffset(-6, () -> bot.goToGroundPlacementPosition())
                    .waitSeconds(0.25)
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.75)
                    .back(4)
                    .lineToLinearHeading(escapePose)
                    .lineToLinearHeading(parkPose)
                    .addDisplacementMarker(() -> bot.tuckDropper())
                    .waitSeconds(3)
                    .build();

            telemetry.addLine("Center near traj built.");
            telemetry.update();
            rightTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                    .addTemporalMarker(() -> bot.handlerDeployLevel1())
                    .splineToLinearHeading(rightBoardPose, rightBoardPose.getHeading())
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.5)
                    .addTemporalMarker(() -> bot.liftToCruisePosition())
                    .waitSeconds(0.5)
                    .back(AutoConstants.boardApproachOffset)
                    .splineToLinearHeading(rightSpikePose, rightSpikePose.getHeading())
//                    .UNSTABLE_addDisplacementMarkerOffset(-6, () -> bot.goToGroundPlacementPosition())
                    .waitSeconds(0.25)
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.75)
                    .back(4)
                    .lineToLinearHeading(escapePose)
                    .lineToLinearHeading(parkPose)
//                    .splineToLinearHeading(parkPose, parkPose.getHeading())
                    .addDisplacementMarker(() -> bot.tuckDropper())
                    .waitSeconds(3)
                    .build();
            telemetry.addLine("Right near traj built.");
            telemetry.update();
        } else if (startPosition == StartPosition.FAR) {
            telemetry.addLine("Building FAR trajectories.");
            telemetry.update();

            centerTrajectorySequence = bot.drivetrain().trajectorySequenceBuilder(startPose)
                    .addTemporalMarker(() -> bot.handlerDeployLevel1())
                    .lineToLinearHeading(farOutsideStartPose)
                    .lineToLinearHeading(centerSpikePose)
                    .addTemporalMarker(() -> bot.dropperToGroundPlacementPosition())
                    .waitSeconds(0.50)
                    .addTemporalMarker(() -> bot.liftToGroundPlacementPosition())
                    .waitSeconds(0.50)
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.5)
                    .back(4)
                    .addDisplacementMarker(() -> bot.handlerRetract())
                    .waitSeconds(0.5)
                    .lineToLinearHeading(farMainstreetStartPose)
                    .turn(Math.toRadians(-1.61))
                    .addDisplacementMarker(() -> bot.drivetrain().setPoseEstimate(farMainstreetStartPose))
                    .splineToLinearHeading(farMainstreetEndPose, farMainstreetStartPose.getHeading())
                    .addDisplacementMarker(() -> bot.handlerDeployLevel1())
                    .splineToLinearHeading(centerBoardPose, centerBoardPose.getHeading())
                    .addTemporalMarker(() -> bot.dropPixel())
                    .waitSeconds(0.5)
                    .addTemporalMarker(() -> bot.liftToCruisePosition())
                    .waitSeconds(0.5)
                    .back(AutoConstants.boardApproachOffset)
                    .lineToLinearHeading(escapePose)
                    .lineToLinearHeading(parkPose)
                    .addDisplacementMarker(() -> bot.tuckDropper())
                    .waitSeconds(3)
                    .build();

            telemetry.addLine("Center traj built.");
            telemetry.update();

        }
        /*
        assert (leftTrajectorySequence != null);
        assert (centerTrajectorySequence != null);
        assert (rightTrajectorySequence != null);
         */
        sleep(500);
        telemetry.addLine("Entering prop detection loop.");
        telemetry.update();

        while (!isStarted() && !isStopRequested()) {

            propDirection = visionSensor.getPropDirection();
            telemetry.addData("Prop Position: ", propDirection);
            telemetry.update();

            sleep(50);
        }
        visionSensor.goToNoSensingMode();

        selectedTrajectorySequence = selectTrajectorySequence();

        bot.drivetrain().followTrajectorySequenceAsync(selectedTrajectorySequence);

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
