package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.View;

/**
 * Interface prescribing Controller implementations behavior.
 */
public interface Controller {
    void setMvcModel(Model mvcModel);

    void setMvcView(View mvcView);
}
