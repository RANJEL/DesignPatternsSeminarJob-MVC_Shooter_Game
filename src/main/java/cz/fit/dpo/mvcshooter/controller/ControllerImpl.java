package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.designPatterns.controller.commandPattern.concreteCommands.*;
import cz.fit.dpo.mvcshooter.view.Canvas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/***
 * Controller of my MVC architecture. Controller also init application and contains MainWindow.
 */
public class ControllerImpl extends AbstractController {
    private MainWindow mainWindow;

    public ControllerImpl(Canvas view) {
        if (view == null) {
            System.out.println("Playing without View!");
        } else {
            mainWindow = new MainWindow(view);
            addMainWindowListeners();
            mainWindow.setVisible(true);
        }
    }

    private void addMainWindowListeners() {

        mainWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        mvcModel.addCommand(new FireFromCannonCommand(mvcModel));
                        break;
                    case KeyEvent.VK_F:
                        mvcModel.addCommand(new MoveCannonUpCommand(mvcModel));
                        break;
                    case KeyEvent.VK_V:
                        mvcModel.addCommand(new MoveCannonDownCommand(mvcModel));
                        break;
                    case KeyEvent.VK_RIGHT:
                        mvcModel.addCommand(new IncreaseForceCommand(mvcModel));
                        break;
                    case KeyEvent.VK_LEFT:
                        mvcModel.addCommand(new DecreaseForceCommand(mvcModel));
                        break;
                    case KeyEvent.VK_UP:
                        mvcModel.addCommand(new IncreaseAngleCommand(mvcModel));
                        break;
                    case KeyEvent.VK_DOWN:
                        mvcModel.addCommand(new DecreaseAngleCommand(mvcModel));
                        break;
                    case KeyEvent.VK_ADD:
                        mvcModel.addCommand(new IncreaseGravityCommand(mvcModel));
                        break;
                    case KeyEvent.VK_SUBTRACT:
                        mvcModel.addCommand(new DecreaseGravityCommand(mvcModel));
                        break;
                    case KeyEvent.VK_SHIFT:
                        mvcModel.addCommand(new ChangeCannonShootStateCommand(mvcModel));
                        break;
                    case KeyEvent.VK_Z:
                        mvcModel.addCommand(new MementoRollbackCommand(mvcModel));
                        break;
                }
            }
        });
    }
}
