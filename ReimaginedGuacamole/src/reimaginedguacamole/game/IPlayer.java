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

    public void setScore(int score)throws RemoteException;

    public int getScore()throws RemoteException;

}
