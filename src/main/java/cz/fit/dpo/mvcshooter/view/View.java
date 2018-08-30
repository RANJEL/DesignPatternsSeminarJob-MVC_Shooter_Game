package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.designPatterns.observerPattern.Observer;
import cz.fit.dpo.mvcshooter.model.Model;

/**
 * Interface prescribing View implementations behavior.
 */
public interface View extends Observer {
    void setMvcModel(Model mvcModel);

    void setMvcController(Controller mvcController);

    /***
     * Render gaming area corresponding current Model.
     */
    void render();
}
