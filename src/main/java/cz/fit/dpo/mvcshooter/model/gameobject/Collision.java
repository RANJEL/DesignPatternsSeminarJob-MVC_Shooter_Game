package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import cz.fit.dpo.mvcshooter.model.validation.Validable;

public class Collision extends GameObject implements Validable {
    private boolean isValid;

    public Collision(int coordinateX, int coordinateY) {
        super(coordinateX, coordinateY);
        this.isValid = true;
    }

    public Collision deepCopy() {
        return new Collision(coordinateX, coordinateY);
    }

    @Override
    public String toString() {
        return "Collision{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isInvalid() {
        return !this.isValid || this.liveTime > ModelConfiguration.COLLISION_MAX_LIFETIME_MILISECOND;
    }

    @Override
    public void invalidate() {
        this.isValid = false;
    }
}
