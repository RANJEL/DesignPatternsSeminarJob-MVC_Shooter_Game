package cz.fit.dpo.mvcshooter.view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagesCache {
    private BufferedImage cannonImage;
    private BufferedImage enemy1Image;
    private BufferedImage enemy2Image;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;


    public ImagesCache() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemy1Image = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemy2Image = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public BufferedImage getCannonImage() {
        return cannonImage;
    }

    public BufferedImage getEnemy1Image() {
        return enemy1Image;
    }

    public BufferedImage getEnemy2Image() {
        return enemy2Image;
    }

    public BufferedImage getMissileImage() {
        return missileImage;
    }

    public BufferedImage getCollisionImage() {
        return collisionImage;
    }
}
