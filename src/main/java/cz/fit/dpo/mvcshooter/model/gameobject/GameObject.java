package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitable;
import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

import java.awt.*;

public abstract class GameObject implements Visitable {
    protected int coordinateX;
    protected int coordinateY;
    protected long liveTime;

    public GameObject(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.liveTime = 0;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        if (isValidCoordinateX(coordinateX)) {
            this.coordinateX = coordinateX;
        }
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        if (isValidCoordinateY(coordinateY)) {
            this.coordinateY = coordinateY;
        }
    }

    private boolean isValidCoordinateX(int coordinateX) {
        if (coordinateX < ViewConfiguration.GAME_AREA.get("topLeftX") || coordinateX > ViewConfiguration.GAME_AREA.get("bottomRightX")) {
            return false;
        }

        return true;
    }

    private boolean isValidCoordinateY(int coordinateY) {
        if (coordinateY < ViewConfiguration.GAME_AREA.get("topLeftY") || coordinateY > ViewConfiguration.GAME_AREA.get("bottomRightY")) {
            return false;
        }

        return true;
    }

    public void increaseLiveTime() {
        liveTime += ModelConfiguration.TICK_TIME;
    }

    @Override
    /**
     * Visitor pattern, GO is element
     * Could not be implemented there, because Java does not perform dynamic method dispatch for params
     * Visit(GameObject) would be called even if the real parameter was the Cannon.
     *
     * @param visitor
     */
    public abstract void acceptVisitor(Visitor visitor);

    public boolean collidesWith(GameObject anotherGameObject) {
        return new Point(coordinateX, coordinateY).distance(new Point(anotherGameObject.coordinateX, anotherGameObject.coordinateY)) <= ModelConfiguration.DISTANCE_TO_COLLISION;
    }
}
