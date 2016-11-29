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
public interface IClient extends Remote{
    
    public void sendMessage(String message) throws RemoteException;
    public void addMessage(String message) throws RemoteException;
    public String getName() throws RemoteException;
    
}
