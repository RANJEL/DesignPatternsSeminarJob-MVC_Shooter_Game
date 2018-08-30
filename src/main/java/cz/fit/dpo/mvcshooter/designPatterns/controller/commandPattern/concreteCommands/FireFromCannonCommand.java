package cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.AbstractCommand;
import cz.fit.dpo.mvcshooter.model.Model;

public class FireFromCannonCommand extends AbstractCommand {
    /***
     *
     * @param itsReceiver Model is in this case receiver and invoker at the same time
     */
    public FireFromCannonCommand(Model itsReceiver) {
        super(itsReceiver);
    }

    @Override
    public void execute() {
        itsReceiver.fireFromCannon();
    }
}
