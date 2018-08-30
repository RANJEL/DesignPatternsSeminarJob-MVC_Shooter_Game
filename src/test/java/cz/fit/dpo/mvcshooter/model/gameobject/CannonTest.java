package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectSimpleFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonSingleShootState;
import cz.fit.dpo.mvcshooter.designPatterns.singletonPattern.Rng;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for class {@link Cannon}
 */
public class CannonTest {
    private static final int X = 1000;
    private static final int Y = 1000;
    private static final CannonShootState CANNON_SHOOT_STATE = new CannonSingleShootState();

    private Cannon cannon;

    @Before
    public void setUp() {
        cannon = new Cannon(X, Y, CANNON_SHOOT_STATE);
    }

    @Test
    public void moveUp() {
        cannon.moveUp();
        assertEquals(X, cannon.getCoordinateX());
        assertEquals(Y - ModelConfiguration.CANNON_MOVE_STEP, cannon.getCoordinateY());
    }

    @Test
    public void moveUp5x() {
        final int times = 5;
        for (int i = 0; i < times; i++) {
            cannon.moveUp();
        }
        assertEquals(X, cannon.getCoordinateX());
        assertEquals(Y - times * ModelConfiguration.CANNON_MOVE_STEP, cannon.getCoordinateY());
    }

    @Test
    public void moveDown() {
        cannon.moveDown();
        assertEquals(X, cannon.getCoordinateX());
        assertEquals(Y + ModelConfiguration.CANNON_MOVE_STEP, cannon.getCoordinateY());
    }

    @Test
    public void moveDown5x() {
        final int times = 5;
        for (int i = 0; i < times; i++) {
            cannon.moveDown();
        }
        assertEquals(X, cannon.getCoordinateX());
        assertEquals(Y + times * ModelConfiguration.CANNON_MOVE_STEP, cannon.getCoordinateY());
    }

    @Test
    public void moveUpAndDown() {
        final int times = Rng.instance().getRandomNumberInRange(1, 100);
        for (int i = 0; i < times; i++) {
            cannon.moveUp();
        }

        for (int i = 0; i < times; i++) {
            cannon.moveDown();
        }

        assertEquals(X, cannon.getCoordinateX());
        assertEquals(Y, cannon.getCoordinateY());
    }

    @Test
    public void fire() {
        InfoPanel infoPanel = new InfoPanel(900, 900, 65, 20, 10.0, 0);
        GameObjectFactory gameObjectFactory = new GameObjectSimpleFactory();

        List<Missile> missileList = cannon.fire(infoPanel, gameObjectFactory);
        assertEquals(1, missileList.size());
        assertEquals(X, missileList.get(0).getCoordinateX());
    }
}
