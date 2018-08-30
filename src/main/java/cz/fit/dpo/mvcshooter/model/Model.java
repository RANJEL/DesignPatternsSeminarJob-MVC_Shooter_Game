package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.CommandInvoker;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Originator;
import cz.fit.dpo.mvcshooter.designPatterns.observerPattern.Observable;
import cz.fit.dpo.mvcshooter.model.gameobject.GameObject;
import cz.fit.dpo.mvcshooter.view.View;

import java.util.List;

/**
 * Interface prescribing Model implementations behavior.
 */
public interface Model extends Observable, Originator, CommandInvoker {
    void setMvcView(View mvcView);

    void increaseForce();

    void decreaseForce();

    void increaseAngle();

    void decreaseAngle();

    void increaseGravity();

    void decreaseGravity();

    void increaseScore();

    void moveCannonUp();

    void moveCannonDown();

    void fireFromCannon();

    void changeCannonShootState();

    List<GameObject> getAllGameObjects();
}
