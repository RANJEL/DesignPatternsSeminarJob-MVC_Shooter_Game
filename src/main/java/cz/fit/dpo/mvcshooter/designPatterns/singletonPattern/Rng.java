package cz.fit.dpo.mvcshooter.designPatterns.singletonPattern;

import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

import java.util.Random;

public class Rng {
    private static volatile Rng itsInstance = null;
    private Random rd;

    private Rng() {
        rd = new Random();
    }

    public static Rng instance() {
        synchronized (Rng.class) {
            if (itsInstance == null) {
                itsInstance = new Rng();
            }
        }
        return itsInstance;
    }

    public int getRandomNumberInRange(int min, int max) {
        return rd.nextInt((max - min) + 1) + min;
    }

    public int getRandomXCoordinateFromGameArea() {
        return getRandomNumberInRange(ViewConfiguration.GAME_AREA.get("topLeftX"), ViewConfiguration.GAME_AREA.get("bottomRightX"));
    }

    public int getRandomYCoordinateFromGameArea() {
        return getRandomNumberInRange(ViewConfiguration.GAME_AREA.get("topLeftY"), ViewConfiguration.GAME_AREA.get("bottomRightY"));
    }
}
