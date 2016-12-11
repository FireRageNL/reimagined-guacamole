/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.timertasks;

import java.rmi.RemoteException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import reimaginedguacamole.gui.FXMLController;

/**
 * Timer to set a new gamestate after a set time.
 *
 * @author daan
 */
public class SpinTimerTask extends TimerTask {

    FXMLController game;

    /**
     * Constructor for a new gamestate waiter
     *
     * @param g the game where the state will be changed after the timer
     * finished
     */
    public SpinTimerTask(FXMLController g) {
        game = g;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            try {
                game.stopSpin();
            } catch (RemoteException ex) {
                Logger.getLogger(SpinTimerTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}