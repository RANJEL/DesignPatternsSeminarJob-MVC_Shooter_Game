package cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.AbstractCommand;
import cz.fit.dpo.mvcshooter.model.Model;

public class DecreaseForceCommand extends AbstractCommand {
    public DecreaseForceCommand(Model itsReceiver) {
        super(itsReceiver);
    }

    @Override
    public void execute() {
        itsReceiver.decreaseForce();
    }
}
