package cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern;

import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.model.gameobject.GameObject;
import cz.fit.dpo.mvcshooter.model.movement.MoveMissileDataContext;

public interface GameObjectFactory {
    GameObject createCannon(int coordinateX, int coordinateY, CannonShootState cannonShootState);

    GameObject createMissile(MoveMissileDataContext dataContext);

    GameObject createCollision(int coordinateX, int coordinateY);

    GameObject createEnemy(int coordinateX, int coordinateY);

    GameObject createInfoPanel(int coordinateX, int coordinateY, int force, int angle, double gravity, int score);
}
