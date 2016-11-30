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
public interface IChatServer extends Remote {

    /**
     * Function to provide the data for a current user list.
     *
     * @return A list of strings with each users's nickname currently connected.
     * @throws RemoteException
     */
    public List<String> listClients() throws RemoteException;

    /**
     * Function to broadcast a message to all chatclient users
     *
     * @param message the message to be broadcast.
     * @throws RemoteException
     */
    public void broadcastMessage(String message) throws RemoteException;

    /**
     * Function to add a client to the client list when they enter the chatroom
     *
     * @param client the client that enters the chatroom
     * @throws RemoteException
     */
    public void clientEnter(IClient client) throws RemoteException;

    /**
     * Function to remove a client from the client list when they leave the
     * chatroom
     *
     * @param client the client that leaves the chatroom
     * @throws RemoteException
     */
    public void clientExit(IClient client) throws RemoteException;

}
