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
public interface IPlayer extends Remote {

    /**
     * Set the score of the player
     *
     * @param score the score to be set
     * @throws RemoteException
     */
    public void setScore(int score) throws RemoteException;

    /**
     * Get the score of a player
     *
     * @return the score of the player
     * @throws RemoteException
     */
    public int getScore() throws RemoteException;

}
