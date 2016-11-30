/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

/**
 *
 * @author roy_v
 */
public interface IGameServer extends Remote {
    
    public IGameController createController() throws RemoteException;
    
}
