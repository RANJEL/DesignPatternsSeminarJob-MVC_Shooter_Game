package cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern;

import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern.MissileMoveStrategy;
import cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern.MissileMoveStrategyObliqueLitter;
import cz.fit.dpo.mvcshooter.model.GameMode;
import cz.fit.dpo.mvcshooter.model.gameobject.*;
import cz.fit.dpo.mvcshooter.model.movement.MoveMissileDataContext;

public class GameObjectRealisticFactory implements GameObjectFactory {
    private static final GameMode GAME_MODE = GameMode.REALISTIC;
    //    private static final MissileMoveStrategy MISSILE_MOVE_STRATEGY = new MissileMoveStrategyBallisticCurve(); // TODO
    private static final MissileMoveStrategy MISSILE_MOVE_STRATEGY = new MissileMoveStrategyObliqueLitter();

    @Override
    public GameObject createCannon(int coordinateX, int coordinateY, CannonShootState cannonShootState) {
        return new Cannon(coordinateX, coordinateY, cannonShootState);
    }

    @Override
    public GameObject createMissile(MoveMissileDataContext dataContext) {
        return new Missile(MISSILE_MOVE_STRATEGY, dataContext);
    }

    @Override
    public GameObject createCollision(int coordinateX, int coordinateY) {
        return new Collision(coordinateX, coordinateY);
    }

    @Override
    public GameObject createEnemy(int coordinateX, int coordinateY) {
        return new Enemy(coordinateX, coordinateY, GAME_MODE);
    }

    @Override
    public GameObject createInfoPanel(int coordinateX, int coordinateY, int force, int angle, double gravity, int score) {
        return new InfoPanel(coordinateX, coordinateY, force, angle, gravity, score);
    }
}
