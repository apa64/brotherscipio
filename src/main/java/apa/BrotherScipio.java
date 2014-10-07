package apa;

import robocode.*;

public class BrotherScipio extends Robot {
    private static final double RANGE_POINT_BLANK = 300;

    public static void main(String[] args) {
        System.out.println("+++ Brother Scipio requires Robocode +++");
    }

    @Override
    public void run() {
        // init bot
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);
        out.println("+++ Brother Scipio engaging +++");
        while (true) {
            turnRadarRight(360);
            ahead(100);
            turnRight(45);
        }
    }

    /** Scanner found a robot. */
    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
//        out.println("onScannedRobot(), enemy=" + e.getName() + ", bearing=" + e.getBearing() + ", heading=" + getHeading() + ", gun=" + getGunHeading());
        double enemyAngle = getHeading() + e.getBearing();
        turnGunLeft(getGunHeading() - enemyAngle);
        fire(6);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        super.onHitWall(event);
        // todo move away
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        super.onHitByBullet(event);
        // todo evasive action
    }

    /** Robot dies. */
    @Override
    public void onDeath(DeathEvent event) {
        out.println("+++ " + Quotes.getFailureQuote() + " +++");
    }

    /** Robot kills. */
    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        out.println("+++ " + Quotes.getSuccessQuote() + " +++");
    }
}
