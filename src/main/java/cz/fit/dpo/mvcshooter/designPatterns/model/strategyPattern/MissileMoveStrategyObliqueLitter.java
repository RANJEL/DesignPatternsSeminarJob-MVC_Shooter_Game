package cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern;

import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import cz.fit.dpo.mvcshooter.model.gameobject.Missile;
import cz.fit.dpo.mvcshooter.model.movement.MoveMissileDataContext;

public class MissileMoveStrategyObliqueLitter implements MissileMoveStrategy {
    @Override
    public void move(Missile missile) {
        MoveMissileDataContext dataContext = missile.getMoveMissileDataContext();
        int x0 = dataContext.getInitialCoordinateX();
        int y0 = dataContext.getInitialCoordinateY();
        int v0 = dataContext.getFiredSpeed() * ModelConfiguration.SPEED_COEFFICIENT;
        int alpha = dataContext.getFiredAngle();
        double g = dataContext.getFiredGravity() * ModelConfiguration.GRAVITY_COEFFICIENT;
        double t = convertToSeconds(dataContext.getTimeOfMovement() + ModelConfiguration.TICK_TIME);

        int x = (int) Math.round(x0 + v0 * t * Math.cos(Math.toRadians(alpha)));
        int y = (int) Math.round(y0 - v0 * t * Math.sin(Math.toRadians(alpha)) + g * Math.pow(t, 2) / 2); // inverted for PC coordinates system

        dataContext.setTimeOfMovement(dataContext.getTimeOfMovement() + ModelConfiguration.TICK_TIME);
        missile.updateCoordinates(x, y);
    }

    private double convertToSeconds(double miliseconds) {
        return miliseconds / 1000;
    }

}
