package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.View;

/***
 * Base class for all Model implementations.
 */
public abstract class AbstractController implements Controller {
    protected Model mvcModel;
    protected View mvcView;

    @Override
    public void setMvcModel(Model mvcModel) {
        this.mvcModel = mvcModel;
    }

    @Override
    public void setMvcView(View mvcView) {
        this.mvcView = mvcView;
    }
}
