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
public interface IRanking extends Remote {

    /**
     * Function that returns the nickname of the user this ranking is about
     *
     * @return the nickname of the user the ranking is about
     * @throws RemoteException
     */
    public String getNickname() throws RemoteException;

    /**
     * Function to return the current rank of the user
     *
     * @return the current rank of the user
     * @throws RemoteException
     */
    public int getRank() throws RemoteException;

    /**
     * Function to get the current score of the user
     *
     * @return the current score of the user
     * @throws RemoteException
     */
    public int getScore() throws RemoteException;
}
