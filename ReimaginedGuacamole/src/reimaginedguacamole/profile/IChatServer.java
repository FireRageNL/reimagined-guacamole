/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author roy_v
 */
public interface IChatServer extends Remote{
    
    public List<String>listClients() throws RemoteException;
    public void broadcastMessage(String message) throws RemoteException;
    public void clientEnter(IClient client) throws RemoteException;
    public void clientExit(IClient client) throws RemoteException;
    
}
