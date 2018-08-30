package cz.fit.dpo.mvcshooter.model.gameobject;

import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.Visitor;
import cz.fit.dpo.mvcshooter.model.GameMode;
import cz.fit.dpo.mvcshooter.model.ModelConfiguration;
import cz.fit.dpo.mvcshooter.model.movement.Movable;
import cz.fit.dpo.mvcshooter.model.validation.Validable;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

public class Enemy extends GameObject implements Movable, Validable {
    GameMode enemysGameMode;
    boolean movingDown;
    boolean isValid;

    public Enemy(int coordinateX, int coordinateY, GameMode gameMode) {
        super(coordinateX, coordinateY);
        this.enemysGameMode = gameMode;
        if (gameMode == GameMode.REALISTIC) {
            this.movingDown = true;
        }
        this.isValid = true;
    }

    public Enemy deepCopy() {
        return new Enemy(coordinateX, coordinateY, enemysGameMode);
    }

    @Override
    public String toString() {
        return "Enemy{" +
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
        if (enemysGameMode == GameMode.REALISTIC) {
            if (this.coordinateY <= ViewConfiguration.GAME_AREA.get("topLeftY")) {
                this.movingDown = true;
            } else if (this.coordinateY >= ViewConfiguration.GAME_AREA.get("bottomRightY")) {
                this.movingDown = false;
            }

            if (this.movingDown) {
                this.coordinateY += ModelConfiguration.ENEMY_MOVE_SPEED;
            } else {
                this.coordinateY -= ModelConfiguration.ENEMY_MOVE_SPEED;
            }

        }
    }

    public void invalidate() {
        isValid = false;
    }

    @Override
    public boolean isInvalid() {
        return !isValid;
    }
}
