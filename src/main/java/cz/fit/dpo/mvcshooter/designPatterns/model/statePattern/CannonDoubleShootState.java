package cz.fit.dpo.mvcshooter.designPatterns.model.statePattern;

import cz.fit.dpo.mvcshooter.model.gameobject.Cannon;
import cz.fit.dpo.mvcshooter.model.gameobject.Missile;

import java.util.List;

public class CannonDoubleShootState implements CannonShootState {
    @Override
    public List<Missile> fire(Cannon fromCannon) {
        return fromCannon.doubleShoot();
    }

    @Override
    public void changeState(Cannon cannon) {
        cannon.setSingleShootState();
    }
}
