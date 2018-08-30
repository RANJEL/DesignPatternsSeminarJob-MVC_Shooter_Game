package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern.RenderVisitor;
import cz.fit.dpo.mvcshooter.model.gameobject.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel {
    private final ImagesCache imagesCache;
    private final RenderVisitor renderVisitor;
    private List<GameObject> gameObjects;

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
        this.imagesCache = new ImagesCache();
        this.renderVisitor = new RenderVisitor(imagesCache);
    }

    public void updateGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderVisitor.setGraphics(g);

        if (gameObjects != null) {
            for (GameObject gameObject :
                    gameObjects) {
                gameObject.acceptVisitor(renderVisitor);
            }
        }
    }
}
