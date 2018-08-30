package cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.AbstractCommand;
import cz.fit.dpo.mvcshooter.model.Model;

public class IncreaseAngleCommand extends AbstractCommand {
    public IncreaseAngleCommand(Model itsReceiver) {
        super(itsReceiver);
    }

    @Override
    public void execute() {
        itsReceiver.increaseAngle();
    }
}
