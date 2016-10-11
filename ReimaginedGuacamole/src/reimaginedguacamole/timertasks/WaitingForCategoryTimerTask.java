/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.timertasks;

import java.util.TimerTask;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.GameState;

/**
 *
 * @author daan
 */
public class WaitingForCategoryTimerTask extends TimerTask{
    
    GameController _game;
    
    public WaitingForCategoryTimerTask(GameController g){
        _game = g;
    }
    @Override
    public void run() {
        System.out.println("Timer 1 finished");
        _game.setGameState(GameState.Spinning);
        
    }
    
}
