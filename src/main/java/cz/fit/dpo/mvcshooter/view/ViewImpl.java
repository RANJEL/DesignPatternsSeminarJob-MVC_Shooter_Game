package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.designPatterns.observerPattern.Observable;
import cz.fit.dpo.mvcshooter.model.AbstractModel;

import java.util.logging.Logger;

/***
 * View of my MVC architecture.
 */
public class ViewImpl extends AbstractView {
    private final Canvas canvas;
    private static final Logger LOGGER = Logger.getLogger(ViewImpl.class.getName());

    public ViewImpl() {
        canvas = new Canvas(0, 0, ViewConfiguration.GAME_WINDOW_SIZE.getX(), ViewConfiguration.GAME_WINDOW_SIZE.getY());
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void render() {
        canvas.updateGameObjects(mvcModel.getAllGameObjects());
        canvas.repaint();
    }

    /**
     * observerPattern
     *
     * @param subject in case view observes more subjects
     */
    @Override
    public void update(Observable subject) {
        if (subject instanceof AbstractModel) {
            render();
        }
    }
}
