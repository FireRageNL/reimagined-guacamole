/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author roy_v
 */
public interface IAchievement extends Remote {
    /**
     * Get the description of the achievement
     * @return the description of the achievement
     * @throws RemoteException
     */
    public String getDescription() throws RemoteException;
    
    /**
     * Get the name of the achievment
     * @return the name of the achievement
     * @throws RemoteException
     */
    public String getName() throws RemoteException;
}
