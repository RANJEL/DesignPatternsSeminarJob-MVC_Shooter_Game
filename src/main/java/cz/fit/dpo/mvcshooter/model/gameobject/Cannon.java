package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonDoubleShootState;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonSingleShootState;
import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import cz.fit.dpo.mvcshooter.model.movement.MoveMissileDataContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jan Lejnar
 */
public class Cannon extends GameObject {
    private CannonShootState itsState;

    private int force;
    private int angle;
    private double gravity;
    private GameObjectFactory gameObjectFactory; // high cohesion between Model and Cannon, next time use Visitor design pattern

    private static final int MISSILE_SHIFT = 20;

    public Cannon(int coordinateX, int coordinateY, CannonShootState cannonShootState) {
        super(coordinateX, coordinateY);
        this.itsState = cannonShootState;

        this.force = ModelConfiguration.INIT_FORCE;
        this.angle = ModelConfiguration.INIT_ANGLE;
        this.gravity = ModelConfiguration.INIT_GRAVITY;
    }

    public Cannon deepCopy() {
        return new Cannon(coordinateX, coordinateY, itsState);
    }

    @Override
    public String toString() {
        return "Cannon{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    public void moveUp() {
        this.setCoordinateY(coordinateY - ModelConfiguration.CANNON_MOVE_STEP);
    }

    public void moveDown() {
        this.setCoordinateY(coordinateY + ModelConfiguration.CANNON_MOVE_STEP);
    }

    public List<Missile> fire(InfoPanel currentCannonSettings, GameObjectFactory gameObjectFactory) {
        this.force = currentCannonSettings.getForce();
        this.angle = currentCannonSettings.getAngle();
        this.gravity = currentCannonSettings.getGravity();
        this.gameObjectFactory = gameObjectFactory;

        return itsState.fire(this);
    }

    public List<Missile> singleShoot() {
        MoveMissileDataContext dataContext = new MoveMissileDataContext(coordinateX, coordinateY - MISSILE_SHIFT, force, angle, gravity, 0);
        Missile missile = (Missile) gameObjectFactory.createMissile(dataContext);
        return new ArrayList<>(Arrays.asList(missile));
    }

    public List<Missile> doubleShoot() {
        MoveMissileDataContext dataContext1 = new MoveMissileDataContext(coordinateX, coordinateY - MISSILE_SHIFT, force, angle - ModelConfiguration.CANNON_DOUBLE_SHOOT_ANGLE_DISPERSION, gravity, 0);
        MoveMissileDataContext dataContext2 = new MoveMissileDataContext(coordinateX, coordinateY - MISSILE_SHIFT, force, angle + ModelConfiguration.CANNON_DOUBLE_SHOOT_ANGLE_DISPERSION, gravity, 0);
        Missile missile1 = (Missile) gameObjectFactory.createMissile(dataContext1);
        Missile missile2 = (Missile) gameObjectFactory.createMissile(dataContext2);
        return new ArrayList<>(Arrays.asList(missile1, missile2));
    }

    public void changeShootState() {
        itsState.changeState(this);
    }

    public void setSingleShootState() {
        itsState = new CannonSingleShootState();
    }

    public void setDoubleShootState() {
        itsState = new CannonDoubleShootState();
    }
}
