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
public class SpinTimerTask extends TimerTask
{
    GameController _game;

    public SpinTimerTask(GameController g){
        _game = g;
    }
    @Override
    public void run() {
        System.out.println("spinTimer finished");
        _game.setGameState(GameState.SpinningFinished);
        
    }
    
}
