/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.game.GameState;

/**
 *
 * @author roy_v
 */
public interface IGameClient extends Remote {
   
        public IProfile getProfile() throws RemoteException;
    
    public void joinGame() throws RemoteException;

    public void disableStartButton(boolean state) throws RemoteException;
    
    public void disableButtons(boolean state) throws RemoteException;
    
    public void disableSpinButton(boolean state) throws RemoteException;

    public void checkGameState(GameState gameState) throws RemoteException;
    
    public void setUserIndex(int i) throws RemoteException;
    
    public void spinWheel(int wheelspeed, int time) throws RemoteException;
    
    public void refreshUI(int[] scores, List<String> names ) throws RemoteException;
}
