package cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern;

import cz.fit.dpo.mvcshooter.model.gameobject.*;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final InfoPanel infoPanel;
    private final Cannon cannon;
    private final List<Missile> missiles;
    private final List<Enemy> enemies;
    private final List<Collision> collisions;

    public Memento(InfoPanel infoPanel,
                   Cannon cannon,
                   List<Missile> missiles,
                   List<Enemy> enemies,
                   List<Collision> collisions) {
        this.infoPanel = infoPanel.deepCopy();
        this.cannon = cannon.deepCopy();

        List<Missile> missileList = new ArrayList<>();
        for (Missile missile :
                missiles) {
            missileList.add(missile.deepCopy());
        }
        this.missiles = missileList;

        List<Enemy> enemiesList = new ArrayList<>();
        for (Enemy enemy :
                enemies) {
            enemiesList.add(enemy.deepCopy());
        }
        this.enemies = enemiesList;

        List<Collision> collisionList = new ArrayList<>();
        for (Collision collision :
                collisions) {
            collisionList.add(collision.deepCopy());
        }
        this.collisions = collisionList;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Collision> getCollisions() {
        return collisions;
    }
}
