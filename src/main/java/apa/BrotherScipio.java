package apa;

import robocode.*;

public class BrotherScipio extends Robot {
    private static final double RANGE_FAR = 400;
    private static final double BEARING_PREDICT = 5;

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
        double gunAdjust = getHeading() - getGunHeading() + e.getBearing();
        gunAdjust = normalizeBearing(gunAdjust);
        if (e.getVelocity() > 2) {
            gunAdjust = gunAdjust > 0 ? gunAdjust + BEARING_PREDICT : gunAdjust - BEARING_PREDICT;
        }
        turnGunRight(gunAdjust);
        fire(Math.min(RANGE_FAR / e.getDistance(), 3));
    }

    /** normalizes a bearing to between +180 and -180 */
    double normalizeBearing(double angle) {
        while (angle >  180) angle -= 360;
        while (angle < -180) angle += 360;
        return angle;
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
