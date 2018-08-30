package cz.fit.dpo.mvcshooter.designPatterns.view.visitorPattern;

import cz.fit.dpo.mvcshooter.model.gameobject.*;

public interface Visitor {
    void visit(Cannon cannon);

    void visit(Collision collision);

    void visit(Enemy enemy);

    void visit(Missile missile);

    void visit(InfoPanel missile);
}
