/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Marc
 */
public interface IPowerUp extends Remote {

    /**
     * Get the description of the powerup
     *
     * @return the description of the powerup
     * @throws RemoteException
     */
    public String getDescription() throws RemoteException;

    /**
     * Get the name of the powerup
     *
     * @return the name of the powerup
     * @throws RemoteException
     */
    public String getName() throws RemoteException;
}
