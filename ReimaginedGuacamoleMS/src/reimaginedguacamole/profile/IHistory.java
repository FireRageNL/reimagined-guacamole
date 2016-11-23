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
public interface IHistory extends Remote {

    /**
     * Get the date of the gamehistory object
     * @return the date of the object
     * @throws RemoteException
     */
    public String getDate() throws RemoteException;
    /**
     * Get the score achieved by the player
     * @return the score of the player
     * @throws RemoteException
     */
    public int getScore() throws RemoteException;
}
