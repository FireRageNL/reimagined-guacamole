/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author daan
 */
public interface IGameRoom extends Remote {
    
    public int getNrOfPlayers() throws RemoteException;
    
    public void joinRoom(IProfile profile) throws RemoteException;
    
    public void leaveRoom(IProfile profile) throws RemoteException;
    
    public List<String> getNicknames() throws RemoteException;
    
    public IGameRoom createGameRoom(int duration, int rounds) throws RemoteException;
    
}
