package cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern;

import cz.fit.dpo.mvcshooter.model.gameobject.*;
import cz.fit.dpo.mvcshooter.view.ImagesCache;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RenderVisitor implements Visitor {
    private final ImagesCache imagesCache;
    private Graphics graphics;
    private Map<Enemy, Integer> mapEnemy2Image;

    public RenderVisitor(ImagesCache imagesCache) {
        this.imagesCache = imagesCache;
        graphics = null;
        mapEnemy2Image = new HashMap<>();
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    private void renderGameObject(GameObject gameObject, BufferedImage gameObjectImage) {
        if (graphics == null) {
            return;
        }
        graphics.drawImage(gameObjectImage,
                gameObject.getCoordinateX() - gameObjectImage.getWidth() / 2,
                gameObject.getCoordinateY() - gameObjectImage.getHeight() / 2, null);
    }

    @Override
    public void visit(Cannon cannon) {
        renderGameObject(cannon, imagesCache.getCannonImage());
    }

    @Override
    public void visit(Collision collision) {
        renderGameObject(collision, imagesCache.getCollisionImage());
    }

    private void defineEnemyImage(Enemy enemy) {
        if (!mapEnemy2Image.containsKey(enemy)) {
            Random rand = new Random();
            int oneOrTwo = rand.nextInt(2) + 1; // rand.nextInt((max - min) + 1) + min;
            mapEnemy2Image.put(enemy, oneOrTwo);
        }
    }

    @Override
    public void visit(Enemy enemy) {
        defineEnemyImage(enemy);

        int enemyImageNumber = mapEnemy2Image.get(enemy);

        switch (enemyImageNumber) {
            case 1:
                renderGameObject(enemy, imagesCache.getEnemy1Image());
                break;
            case 2:
                renderGameObject(enemy, imagesCache.getEnemy2Image());
                break;
        }
    }

    @Override
    public void visit(Missile missile) {
        renderGameObject(missile, imagesCache.getMissileImage());
    }

    @Override
    public void visit(InfoPanel infoPanel) {
        graphics.drawString("Force: " + infoPanel.getForce() + ", Angle: " + infoPanel.getAngle() + ", Gravity: " + infoPanel.getGravity() + ", Score: " + infoPanel.getScore(),
                ViewConfiguration.INIT_INFO_PANEL_POSITION.getX(), ViewConfiguration.INIT_INFO_PANEL_POSITION.getY());
    }
}
