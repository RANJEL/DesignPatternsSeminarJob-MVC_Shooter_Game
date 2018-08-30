package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;

public class InfoPanel extends GameObject {
    private int force;
    private int angle;
    private double gravity;
    private int score;

    public InfoPanel(int coordinateX, int coordinateY, int force, int angle, double gravity, int score) {
        super(coordinateX, coordinateY);
        this.force = force;
        this.angle = angle;
        this.gravity = gravity;
        this.score = score;
    }

    public InfoPanel deepCopy() {
        return new InfoPanel(coordinateX, coordinateY, force, angle, gravity, score);
    }

    @Override
    public String toString() {
        return "InfoPanel{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    public int getForce() {
        return force;
    }

    public int getAngle() {
        return angle;
    }

    public double getGravity() {
        return gravity;
    }

    public int getScore() {
        return score;
    }

    private void setForce(int force) {
        if (force < ModelConfiguration.MIN_FORCE) {
            this.force = ModelConfiguration.MIN_FORCE;
        } else if (force > ModelConfiguration.MAX_FORCE) {
            this.force = ModelConfiguration.MAX_FORCE;
        } else {
            this.force = force;
        }
    }

    private void setAngle(int angle) {
        if (angle < ModelConfiguration.MIN_ANGLE) {
            this.angle = ModelConfiguration.MIN_ANGLE;
        } else if (angle > ModelConfiguration.MAX_ANGLE) {
            this.angle = ModelConfiguration.MAX_ANGLE;
        } else {
            this.angle = angle;
        }
    }

    private void setGravity(double gravity) {
        if (gravity < ModelConfiguration.MIN_GRAVITY) {
            this.gravity = ModelConfiguration.MIN_GRAVITY;
        } else if (gravity > ModelConfiguration.MAX_GRAVITY) {
            this.gravity = ModelConfiguration.MAX_GRAVITY;
        } else {
            this.gravity = gravity;
        }
    }

    private void setScore(int score) {
        if (score < 0) {
            this.score = 0;
        } else {
            this.score = score;
        }
    }

    public void increaseForce() {
        setForce(this.force + ModelConfiguration.FORCE_STEP);
    }

    public void decreaseForce() {
        setForce(this.force - ModelConfiguration.FORCE_STEP);
    }

    public void increaseAngle() {
        setAngle(this.angle + ModelConfiguration.ANGLE_STEP);
    }

    public void decreaseAngle() {
        setAngle(this.angle - ModelConfiguration.ANGLE_STEP);
    }

    public void increaseGravity() {
        setGravity(this.gravity + ModelConfiguration.GRAVITY_STEP);
    }

    public void decreaseGravity() {
        setGravity(this.gravity - ModelConfiguration.GRAVITY_STEP);
    }

    public void increaseScore() {
        setScore(this.score + ModelConfiguration.SCORE_STEP);
    }
}
