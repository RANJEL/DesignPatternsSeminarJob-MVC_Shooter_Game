package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.view.Canvas;
import cz.fit.dpo.mvcshooter.view.ViewConfiguration;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jan Lejnar
 */
public class MainWindow extends JFrame {

    public MainWindow(Canvas view) {
        try {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle(ViewConfiguration.GAME_WINDOW_TITLE);
            this.setResizable(false);

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                    (int) (screen.getWidth() / 2 - ViewConfiguration.GAME_WINDOW_SIZE.getX() / 2),
                    (int) (screen.getHeight() / 2 - ViewConfiguration.GAME_WINDOW_SIZE.getY() / 2));

            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void showHelp() {
        JOptionPane.showMessageDialog(this,
                "Controls: \n"
                        + "here goes some description...");
    }
}
