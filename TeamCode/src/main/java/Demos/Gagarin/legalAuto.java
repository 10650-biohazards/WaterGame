package Demos.Gagarin;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import Demos.Gagarin.dubinCurve.Node;
import Demos.Gagarin.dubinCurve.curveProcessor;
import FtcExplosivesPackage.ExplosiveAuto;

@Autonomous (name = "Big Boy")
public class legalAuto extends ExplosiveAuto {

    private GagarinRobot robot;
    private curveProcessor curve;

    private Node currentNode;

    private driveTracker track;

    @Override
    public void initHardware() {
        robot = new GagarinRobot(this);
        track = new driveTracker(robot.drive);
        robot.drive.setTracker(track);
        curve = new curveProcessor(robot.drive);
    }

    @Override
    public void initAction() {
        currentNode = new Node(0, 0,0);
    }

    @Override
    public void body() throws InterruptedException {
        curve.move(currentNode, new Node(2, 3, 0));
        currentNode = new Node(track.x, track.y, robot.gyro.getYaw());
        curve.move(currentNode, new Node(0, 0, 180));

    }

    @Override
    public void exit() throws InterruptedException {

    }
}
