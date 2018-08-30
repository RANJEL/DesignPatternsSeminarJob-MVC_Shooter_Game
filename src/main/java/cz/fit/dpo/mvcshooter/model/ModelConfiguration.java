package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonSingleShootState;

public class ModelConfiguration {
    private ModelConfiguration() {
    }

    /* Game */
    public static final int TICK_TIME = 20; // 20 => 50 fps
    public static final int INIT_FORCE = 65;
    public static final int INIT_ANGLE = 20;
    public static final double INIT_GRAVITY = 10.0;
    public static final int INIT_SCORE = 0;
    public static final int MIN_FORCE = 0;
    public static final int MAX_FORCE = 100;
    public static final int MIN_ANGLE = -90;
    public static final int MAX_ANGLE = 90;
    public static final int MIN_GRAVITY = 0;
    public static final int MAX_GRAVITY = 100;

    public static final int FORCE_STEP = 1;
    public static final int ANGLE_STEP = 5;
    public static final double GRAVITY_STEP = 1;
    public static final int SCORE_STEP = 1;

    public static final int SPEED_COEFFICIENT = 20;
    public static final int GRAVITY_COEFFICIENT = 5 * SPEED_COEFFICIENT;

    /* Info panel */
    public static final int MAX_INFO_PANEL_COUNT = 1;


    /* Cannon */
    public static final int MAX_CANNON_COUNT = 1;
    public static final int CANNON_MOVE_STEP = 10;
    public static final CannonShootState INIT_CANNON_SHOOT_STATE = new CannonSingleShootState();
    public static final int CANNON_DOUBLE_SHOOT_ANGLE_DISPERSION = 3;

    /* Enemy */
    public static final int INIT_ENEMIES_COUNT = 5;
    public static final int ENEMY_MOVE_SPEED = 5;

    /* Collision */
    public static final long COLLISION_MAX_LIFETIME_MILISECOND = 1500;
    public static final int DISTANCE_TO_COLLISION = 42; // 2 * srqt(15^2 + 15^2)

}
