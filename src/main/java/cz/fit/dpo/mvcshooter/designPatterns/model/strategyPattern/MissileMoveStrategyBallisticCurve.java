package cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern;

import cz.fit.dpo.mvcshooter.model.gameobject.Missile;

public class MissileMoveStrategyBallisticCurve implements MissileMoveStrategy {
    @Override
    public void move(Missile missile) {
        // TODO
    }

    private double convertToSeconds(double miliseconds) {
        return miliseconds / 1000;
    }
}
