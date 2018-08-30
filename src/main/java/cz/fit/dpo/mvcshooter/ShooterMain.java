package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.Controller;
import cz.fit.dpo.mvcshooter.controller.ControllerImpl;
import cz.fit.dpo.mvcshooter.designPatterns.model.proxyPattern.ModelProxy;
import cz.fit.dpo.mvcshooter.model.GameMode;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ModelImpl;
import cz.fit.dpo.mvcshooter.view.View;
import cz.fit.dpo.mvcshooter.view.ViewImpl;

import javax.swing.*;

/**
 * @author Jan Lejnar
 */
public class ShooterMain {
    private static void bindMVCComponents(Model model, View view, Controller controller) {
        controller.setMvcModel(model);
        controller.setMvcView(view);
        view.setMvcModel(model);
        view.setMvcController(controller);
        model.setMvcView(view);
    }

    private static void printUsage() {
        System.err.println("Usage: java -jar mvc_shooter.jar <GAME_MODE>");
        System.err.println("where GAME_MODE = simple / realistic");
        System.exit(-1);
    }

    public static void main(String[] args) {
        GameMode gameMode;

        if (args.length != 1) {
            printUsage();
            gameMode = GameMode.REALISTIC;
        } else {

            if (args[0].equalsIgnoreCase("simple")) {
                gameMode = GameMode.SIMPLE;
            } else if (args[0].equalsIgnoreCase("realistic")) {
                gameMode = GameMode.REALISTIC;
            } else { // default
                gameMode = GameMode.SIMPLE;
            }

        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Model model = new ModelImpl(gameMode);
                View view = new ViewImpl();
                Controller controller = new ControllerImpl(((ViewImpl) view).getCanvas());

                /* Proxy pattern */
                ModelProxy modelProxy = new ModelProxy(model);
                /**/

                /* MVC */
                bindMVCComponents(modelProxy, view, controller);
                /* */

                /* Observer pattern */
                modelProxy.registerObserver(view);
                /**/
            }
        });
    }
}
