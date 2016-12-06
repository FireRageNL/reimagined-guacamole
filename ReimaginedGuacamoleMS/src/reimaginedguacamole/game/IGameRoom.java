/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.profile.IGameClient;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author daan
 */
public interface IGameRoom extends Remote {

    /**
     * Get the number of players currently in the gameroom
     *
     * @return the number of players in the gameroom
     * @throws RemoteException
     */
    public int getNrOfPlayers() throws RemoteException;

    /**
     * Add a player to the gameroom, making them join the current game
     *
     * @param client the profile that joins the game
     * @throws RemoteException
     */
    public void joinRoom(IGameClient client) throws RemoteException;

    /**
     * Remove a player from the gameroom, making them leave the current game
     *
     * @param client
     * @throws RemoteException
     */
    public void leaveRoom(IGameClient client) throws RemoteException;

    /**
     * Get all the nicknames of the players currently connected to the room
     *
     * @return a list with a string representation of all the players' nickname
     * @throws RemoteException
     */
    public List<String> getNicknames() throws RemoteException;

    /**
     * A special constructor to create a new gameroom object
     *
     * @param duration time that a player has to anwser a question in seconds
     * @param rounds amount of rounds a game contains
     * @return the newly created gameroom object
     * @throws RemoteException
     */
    public IGameRoom createGameRoom(int duration, int rounds) throws RemoteException;

    /**
     * A function to be called each time something changes in the gameroom, so
     * that the room can be properly described in the gamelobby
     *
     * @throws RemoteException
     */
    public void announceRoom() throws RemoteException;
    

}
