package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.Command;
import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectRealisticFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.abstractFactoryPattern.GameObjectSimpleFactory;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Caretaker;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Memento;
import cz.fit.dpo.mvcshooter.designPatterns.model.statePattern.CannonShootState;
import cz.fit.dpo.mvcshooter.designPatterns.singletonPattern.Rng;
import cz.fit.dpo.mvcshooter.model.gameobject.*;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/***
 * Controller of my MVC architecture.
 */
public class ModelImpl extends AbstractModel {
    private GameMode gameMode;
    private GameObjectFactory gameObjectFactory;
    private Timer timer;

    private InfoPanel infoPanel;
    private Cannon cannon;
    private List<Missile> missiles = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Collision> collisions = new ArrayList<>();

    private List<Command> commands = new ArrayList<>();

    public ModelImpl(GameMode gameMode) {
        this.gameMode = gameMode;
        if (gameMode == GameMode.SIMPLE) {
            this.gameObjectFactory = new GameObjectSimpleFactory();
        } else if (gameMode == GameMode.REALISTIC) {
            this.gameObjectFactory = new GameObjectRealisticFactory();
        }

        initDefaultGameElements();
        initTimer();
    }

    private void initDefaultGameElements() {
        createInfoPanel(ViewConfiguration.INIT_INFO_PANEL_POSITION.getX(), ViewConfiguration.INIT_INFO_PANEL_POSITION.getY());
        createCannon(ViewConfiguration.INIT_CANNON_POSITION.getX(), ViewConfiguration.INIT_CANNON_POSITION.getY(), ModelConfiguration.INIT_CANNON_SHOOT_STATE);
        for (int i = 0; i < ModelConfiguration.INIT_ENEMIES_COUNT; i++) {
            createEnemy(Rng.instance().getRandomXCoordinateFromGameArea(), Rng.instance().getRandomYCoordinateFromGameArea());
        }
    }

    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                doTick();
            }
        }, 0, ModelConfiguration.TICK_TIME);
    }

    private void doTick() {
        executeCommands();
        increaseGameObjectsLiveTime();
        moveEnemies();
        moveMissiles();
        handleCollisions();
        deleteInvalidGameObjects();
        notifyObservers();
    }

    private void executeCommands() {
        List<Command> executableCommands = new ArrayList<>(this.commands);
        this.commands.clear();
        executableCommands.forEach(Command::execute);
    }

    private void increaseGameObjectsLiveTime() {
        getAllGameObjects().forEach(GameObject::increaseLiveTime);
    }

    private void moveEnemies() {
        this.enemies.forEach(Enemy::updatePosition);
    }

    private void moveMissiles() {
        this.missiles.forEach(Missile::updatePosition);
    }

    private void deleteInvalidGameObjects() {
        deleteInvalidMissiles();
        deleteInvalidEnemies();
        deleteInvalidCollisions();
    }

    private void deleteInvalidMissiles() {
        List<Missile> validMissiles = new ArrayList<>();

        for (Missile missile :
                this.missiles) {
            if (!missile.isInvalid()) {
                validMissiles.add(missile);
            }
        }

        this.missiles = validMissiles;
    }

    private void deleteInvalidCollisions() {
        List<Collision> validCollisions = new ArrayList<>();

        for (Collision collision :
                this.collisions) {
            if (!collision.isInvalid()) {
                validCollisions.add(collision);
            }
        }

        this.collisions = validCollisions;
    }

    private void deleteInvalidEnemies() {
        List<Enemy> validEnemies = new ArrayList<>();

        for (Enemy enemy :
                this.enemies) {
            if (!enemy.isInvalid()) {
                validEnemies.add(enemy);
            }
        }

        this.enemies = validEnemies;
    }

    private void handleCollisions() {
        int collisionsCount = 0;

        for (Missile missile : missiles) {
            for (Enemy enemy : enemies) {
                if (enemy.collidesWith(missile)) {
                    missile.invalidate();
                    enemy.invalidate();
                    collisionsCount++;
                    this.collisions.add(createCollision(enemy.getCoordinateX(), enemy.getCoordinateY()));
                    this.increaseScore();
                }
            }
        }

        for (int i = 0; i < collisionsCount; i++) {
            createEnemy(Rng.instance().getRandomXCoordinateFromGameArea(), Rng.instance().getRandomYCoordinateFromGameArea());
        }
    }

    private InfoPanel createInfoPanel(int coordinateX, int coordinateY) {
        InfoPanel infoPanel = (InfoPanel) this.gameObjectFactory.createInfoPanel(coordinateX, coordinateY, ModelConfiguration.INIT_FORCE, ModelConfiguration.INIT_ANGLE, ModelConfiguration.INIT_GRAVITY, ModelConfiguration.INIT_SCORE);
        this.infoPanel = infoPanel;
        return infoPanel;
    }

    private Cannon createCannon(int coordinateX, int coordinateY, CannonShootState cannonShootState) {
        Cannon cannon = (Cannon) this.gameObjectFactory.createCannon(coordinateX, coordinateY, cannonShootState);
        this.cannon = cannon;
        return cannon;
    }

    private Enemy createEnemy(int coordinateX, int coordinateY) {
        Enemy enemy = (Enemy) this.gameObjectFactory.createEnemy(coordinateX, coordinateY);
        this.enemies.add(enemy);
        return enemy;
    }

    private Collision createCollision(int coordinateX, int coordinateY) {
        Collision collision = (Collision) this.gameObjectFactory.createCollision(coordinateX, coordinateY);
        this.collisions.add(collision);
        return collision;
    }

    @Override
    public List<GameObject> getAllGameObjects() {
        return new ArrayList<GameObject>() {
            {
                add(infoPanel);
                add(cannon);
                addAll(missiles);
                addAll(enemies);
                addAll(collisions);
            }
        };
    }

    @Override
    public void increaseForce() {
        this.infoPanel.increaseForce();
    }

    @Override
    public void decreaseForce() {
        this.infoPanel.decreaseForce();
    }

    @Override
    public void increaseAngle() {
        this.infoPanel.increaseAngle();
    }

    @Override
    public void decreaseAngle() {
        this.infoPanel.decreaseAngle();
    }

    @Override
    public void increaseGravity() {
        this.infoPanel.increaseGravity();
    }

    @Override
    public void decreaseGravity() {
        this.infoPanel.decreaseGravity();
    }

    @Override
    public void increaseScore() {
        this.infoPanel.increaseScore();
    }

    @Override
    public void moveCannonUp() {
        this.cannon.moveUp();
    }

    @Override
    public void moveCannonDown() {
        this.cannon.moveDown();
    }

    @Override
    public void fireFromCannon() {
        this.missiles.addAll(this.cannon.fire(this.infoPanel, this.gameObjectFactory));
    }

    @Override
    public void changeCannonShootState() {
        this.cannon.changeShootState();
    }

    @Override
    public Memento createMemento() {
        Memento currentMemento = new Memento(infoPanel, cannon, missiles, enemies, collisions);
        Caretaker.instance().addMemento(currentMemento);
        return currentMemento;
    }

    @Override
    public void setMemento(Memento memento) {
        this.infoPanel = memento.getInfoPanel();
        this.cannon = memento.getCannon();
        this.missiles = memento.getMissiles();
        this.enemies = memento.getEnemies();
        this.collisions = memento.getCollisions();
    }

    @Override
    public void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "ModelImpl{" +
                "gameObjects=" + getAllGameObjects() +
                '}';
    }
}
