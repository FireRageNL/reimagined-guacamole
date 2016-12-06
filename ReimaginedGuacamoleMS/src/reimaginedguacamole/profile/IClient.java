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
public interface IClient extends Remote {

    /**
     * Function that creates the message to be sent to a chatroom
     *
     * @param message the body of the message to be sent
     * @throws RemoteException
     */
    public void sendMessage(String message) throws RemoteException;

    /**
     * Function for recieving messages
     *
     * @param message the message that is recieved
     * @throws RemoteException
     */
    public void addMessage(String message) throws RemoteException;

    /**
     * Function to get the current username of the client
     *
     * @return the current username as a string
     * @throws RemoteException
     */
    public String getName() throws RemoteException;

    /**
     * Function to remove the client from the chatroom
     *
     * @throws RemoteException
     */
    public void leaveChatroom() throws RemoteException;

    public void enterChatroom() throws RemoteException;

    /**
     * Function to update the list of players currently in the lobby
     *
     * @param playerData the list of players in the lobby
     * @throws RemoteException
     */
    public void updatePlayerList(List<String> playerData) throws RemoteException;

}
