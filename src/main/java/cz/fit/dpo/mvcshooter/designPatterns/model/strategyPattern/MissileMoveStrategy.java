package cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern;

import cz.fit.dpo.mvcshooter.model.gameobject.Missile;

public interface MissileMoveStrategy {
    void move(Missile missile);
}
