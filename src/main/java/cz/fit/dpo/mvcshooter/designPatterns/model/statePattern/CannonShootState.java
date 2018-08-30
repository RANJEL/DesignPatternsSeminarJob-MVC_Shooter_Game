package cz.fit.dpo.mvcshooter.designPatterns.model.statePattern;

import cz.fit.dpo.mvcshooter.model.gameobject.Cannon;
import cz.fit.dpo.mvcshooter.model.gameobject.Missile;

import java.util.List;

public interface CannonShootState {
    /**
     * State action
     */
    List<Missile> fire(Cannon fromCannon);

    /**
     * State transition
     */
    void changeState(Cannon cannon);
}
