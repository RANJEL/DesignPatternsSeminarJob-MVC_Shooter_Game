package cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.AbstractCommand;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Caretaker;
import cz.fit.dpo.mvcshooter.designPatterns.model.mementoPattern.Memento;
import cz.fit.dpo.mvcshooter.model.Model;

import java.util.EmptyStackException;

public class MementoRollbackCommand extends AbstractCommand {
    public MementoRollbackCommand(Model itsReceiver) {
        super(itsReceiver);
    }

    @Override
    public void execute() {
        try {
            Caretaker.instance().popLastMemento(); // pop memento created by MementoRollbackCommand
            Memento memento = Caretaker.instance().popLastMemento();
            itsReceiver.setMemento(memento);
        } catch (EmptyStackException ex) {
            // do nothing
        }
    }
}
