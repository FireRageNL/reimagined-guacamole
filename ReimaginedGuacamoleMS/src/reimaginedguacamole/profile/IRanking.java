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

    public String getNickname() throws RemoteException;

    public int getRank() throws RemoteException;

    public int getScore() throws RemoteException;
}
