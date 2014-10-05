package apa;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class BrotherScipio extends Robot {
    private static final double BEARING_LIMIT = 4;

    @Override
    public void run() {
        while (true) {
            ahead(100);
            turnRight(90);
            /*
            turnGunRight(360);
            back(100);
            turnGunRight(360);
             */
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double bearing = e.getBearing();
        if (bearing > -BEARING_LIMIT && bearing < BEARING_LIMIT) {
            // close enough
            fire(5);
        }
        else if (bearing <= -BEARING_LIMIT) {
            turnGunRight(bearing);
            fire(1);
        }
        else {
            turnGunLeft(bearing);
            fire(1);
        }
    }
}
