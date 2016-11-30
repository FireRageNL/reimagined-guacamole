/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.timertasks;

import java.util.TimerTask;
import javafx.application.Platform;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.GameState;

/**
 * Timer to set a new gamestate after a set time.
 *
 * @author daan
 */
public class WaitingForGameState extends TimerTask {

    GameController game;
    GameState gamestate;

    /**
     * Constructor for a new gamestate waiter
     *
     * @param g the game where the state will be changed after the timer
     * finished
     * @param gamestate the controller this timer has to be made for
     */
    public WaitingForGameState(GameController g, GameState gamestate) {
        game = g;
        this.gamestate = gamestate;
    }

    @Override
    public void run() {
        Platform.runLater(() -> {
            game.setGameState(gamestate);
        });
    }

}
