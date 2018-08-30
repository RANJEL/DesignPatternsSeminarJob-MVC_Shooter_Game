package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.model.Model;

/***
 * Base class for all View implementations.
 */
public abstract class AbstractView implements View {
    protected Model mvcModel;
    protected Controller mvcController;

    @Override
    public void setMvcModel(Model mvcModel) {
        this.mvcModel = mvcModel;
    }

    @Override
    public void setMvcController(Controller mvcController) {
        this.mvcController = mvcController;
    }
}
