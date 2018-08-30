package cz.fit.dpo.mvcshooter.view;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.HashMap;

public final class ViewConfiguration {
    private ViewConfiguration() { // static class
    }

    /* Game */
    public static final String GAME_WINDOW_TITLE = "MVC ShooterMain";
    public static final Coordinates GAME_WINDOW_SIZE;

    static {
        GAME_WINDOW_SIZE = new Coordinates(1500, 1500);
    }

    private static final int INDENT = 30;
    public static final HashMap<String, Integer> GAME_AREA;

    static {
        GAME_AREA = new HashMap<>();
        try {
            GAME_AREA.put("topLeftX", INDENT + ImageIO.read(ViewConfiguration.class.getResourceAsStream("/images/cannon.png")).getWidth());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        GAME_AREA.put("topLeftY", 3 * INDENT);
        GAME_AREA.put("bottomRightX", GAME_WINDOW_SIZE.getX());
        GAME_AREA.put("bottomRightY", GAME_WINDOW_SIZE.getY());
    }

    /* Info panel */
    public static final Coordinates INIT_INFO_PANEL_POSITION;

    static {
        INIT_INFO_PANEL_POSITION = new Coordinates(INDENT, INDENT);
    }


    /* Cannon */
    public static final Coordinates INIT_CANNON_POSITION;

    static {
        INIT_CANNON_POSITION = new Coordinates(INDENT, GAME_WINDOW_SIZE.getY() / 2);
    }
}
