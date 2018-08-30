package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.view.View;

/***
 * Base class for all Model implementations.
 */
public abstract class AbstractModel implements Model {
    protected View mvcView; // I don't want to have public modifier, that's the only reason I have abstract class AbstractModel and not just interface Model

    @Override
    public void setMvcView(View mvcView) {
        this.mvcView = mvcView;
    }
}
