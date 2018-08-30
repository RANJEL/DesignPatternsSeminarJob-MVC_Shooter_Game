package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.model.strategyPattern.MissileMoveStrategy;
import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.movement.Movable;
import cz.fit.dpo.mvcshooter.model.movement.MoveMissileDataContext;
import cz.fit.dpo.mvcshooter.model.validation.Validable;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

public class Missile extends GameObject implements Movable, Validable {
    private MissileMoveStrategy itsStrategy;
    private MoveMissileDataContext moveMissileDataContext;
    private boolean isValid;

    public Missile(MissileMoveStrategy strategy, MoveMissileDataContext moveMissileDataContext) {
        super(moveMissileDataContext.getInitialCoordinateX(), moveMissileDataContext.getInitialCoordinateY());
        this.itsStrategy = strategy;
        this.moveMissileDataContext = moveMissileDataContext;
        this.isValid = true;
    }

    public Missile deepCopy() {
        return new Missile(itsStrategy, moveMissileDataContext);
    }

    @Override
    public String toString() {
        return "Missile{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void updatePosition() {
        this.itsStrategy.move(this);
    }

    public void updateCoordinates(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public MoveMissileDataContext getMoveMissileDataContext() {
        return moveMissileDataContext;
    }

    @Override
    public boolean isInvalid() {
        return !this.isValid
                || coordinateY > ViewConfiguration.GAME_AREA.get("bottomRightY")
                || coordinateX > ViewConfiguration.GAME_AREA.get("bottomRightX")
                || coordinateX < 0;
    }

    @Override
    public void invalidate() {
        this.isValid = false;
    }
}
