package cz.fit.dpo.mvcshooter.model.movement;

public class MoveMissileDataContext {
    /**
     * x0
     */
    private int initialCoordinateX;
    /**
     * y0
     */
    private int initialCoordinateY;

    /**
     * v0
     */
    private int firedSpeed;

    /**
     * alpha
     */
    private int firedAngle;

    /**
     * g
     */
    private double firedGravity;

    /**
     * t
     */
    private int timeOfMovement;

    public MoveMissileDataContext(int initialCoordinateX, int initialCoordinateY, int firedSpeed, int firedAngle, double firedGravity, int timeOfMovement) {
        this.initialCoordinateX = initialCoordinateX;
        this.initialCoordinateY = initialCoordinateY;
        this.firedSpeed = firedSpeed;
        this.firedAngle = firedAngle;
        this.firedGravity = firedGravity;
        this.timeOfMovement = timeOfMovement;
    }

    public int getInitialCoordinateX() {
        return initialCoordinateX;
    }

    public void setInitialCoordinateX(int initialCoordinateX) {
        this.initialCoordinateX = initialCoordinateX;
    }

    public int getInitialCoordinateY() {
        return initialCoordinateY;
    }

    public void setInitialCoordinateY(int initialCoordinateY) {
        this.initialCoordinateY = initialCoordinateY;
    }

    public int getFiredSpeed() {
        return firedSpeed;
    }

    public void setFiredSpeed(int firedSpeed) {
        this.firedSpeed = firedSpeed;
    }

    public int getFiredAngle() {
        return firedAngle;
    }

    public void setFiredAngle(int firedAngle) {
        this.firedAngle = firedAngle;
    }

    public double getFiredGravity() {
        return firedGravity;
    }

    public void setFiredGravity(double firedGravity) {
        this.firedGravity = firedGravity;
    }

    public int getTimeOfMovement() {
        return timeOfMovement;
    }

    public void setTimeOfMovement(int timeOfMovement) {
        this.timeOfMovement = timeOfMovement;
    }
}
