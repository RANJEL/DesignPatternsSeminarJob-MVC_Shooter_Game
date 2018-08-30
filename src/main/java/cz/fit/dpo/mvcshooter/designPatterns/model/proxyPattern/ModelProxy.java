package cz.fit.dpo.mvcshooter.designPatterns.model.proxyPattern;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.Command;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Memento;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.gameobject.GameObject;
import cz.fit.dpo.mvcshooter.view.View;

import java.util.List;
import java.util.logging.Logger;

/***
 * Proxy that can legitimate access to Model.
 * If some method should behave in different way when called for first time for example, proxy will deal with it, this logic should not be in Model.
 * ModelProxy will mostly log access to Model in my case.
 */
public class ModelProxy implements Model {
    private final Model itsRealSubject;

    private int createCannonCalls;
    private int createInfoPanelCalls;

    private static final Logger LOGGER = Logger.getLogger(ModelProxy.class.getName());

    public ModelProxy(Model itsRealSubject) {
        this.itsRealSubject = itsRealSubject;
        this.createCannonCalls = 1;
        this.createInfoPanelCalls = 1;
    }

    private void logSubjectAccess() {
        String previousMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();

        if (!previousMethodName.equals("getAllGameObjects")) {
            System.out.println("ModelProxy: Model -> " + previousMethodName + "()");
        }
    }

    private <T> T denyAccess() {
        // throw
        return null;
    }

    @Override
    public void setMvcView(View mvcView) {
        itsRealSubject.setMvcView(mvcView);
    }

    @Override
    public List<GameObject> getAllGameObjects() {
        logSubjectAccess();
        return itsRealSubject.getAllGameObjects();
    }

    @Override
    public void increaseForce() {
        logSubjectAccess();
        itsRealSubject.increaseForce();
    }

    @Override
    public void decreaseForce() {
        logSubjectAccess();
        itsRealSubject.decreaseForce();
    }

    @Override
    public void increaseAngle() {
        logSubjectAccess();
        itsRealSubject.increaseAngle();
    }

    @Override
    public void decreaseAngle() {
        logSubjectAccess();
        itsRealSubject.decreaseAngle();
    }

    @Override
    public void increaseGravity() {
        logSubjectAccess();
        itsRealSubject.increaseGravity();
    }

    @Override
    public void decreaseGravity() {
        logSubjectAccess();
        itsRealSubject.decreaseGravity();
    }

    @Override
    public void increaseScore() {
        logSubjectAccess();
        itsRealSubject.increaseScore();
    }

    @Override
    public void moveCannonUp() {
        logSubjectAccess();
        itsRealSubject.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        logSubjectAccess();
        itsRealSubject.moveCannonDown();
    }

    @Override
    public void fireFromCannon() {
        logSubjectAccess();
        itsRealSubject.fireFromCannon();
    }

    @Override
    public void changeCannonShootState() {
        logSubjectAccess();
        itsRealSubject.changeCannonShootState();
    }

    @Override
    public Memento createMemento() {
//        logSubjectAccess();
        return itsRealSubject.createMemento();
    }

    @Override
    public void setMemento(Memento memento) {
        logSubjectAccess();
        itsRealSubject.setMemento(memento);
    }

    @Override
    public void addCommand(Command command) {
//        logSubjectAccess();
        itsRealSubject.addCommand(command);
    }
}
