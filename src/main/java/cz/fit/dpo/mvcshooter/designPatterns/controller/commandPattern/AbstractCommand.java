package cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern;

import cz.fit.dpo.mvcshooter.model.Model;

public abstract class AbstractCommand implements Command {
    protected final Model itsReceiver;

    public AbstractCommand(Model itsReceiver) {
        this.itsReceiver = itsReceiver;
        createMemento();
    }

    private void createMemento() {
        itsReceiver.createMemento();
    }
}