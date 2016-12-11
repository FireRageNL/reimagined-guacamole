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

    /**
     * Function that returns the game room string representation
     *
     * @return the gamerooms string representation
     * @throws RemoteException
     */
    public String getGameRoomListing() throws RemoteException;

    /**
     * Function to get the gamecontroller associated with the gameroom
     *
     * @return the gamecontroller
     * @throws RemoteException
     */
    public IGameController getGameController() throws RemoteException;

    /**
     * function to get all the players currently in the gameroom
     *
     * @return the players in the gameroom
     * @throws RemoteException
     */
    public List<IGameClient> getPlayers() throws RemoteException;

    /**
     * Function to get the amount of players finished with their current action
     * and awaiting the change to the next gamestate
     *
     * @return the amount of players finsihed
     * @throws RemoteException
     */
    public int getPlayersDone() throws RemoteException;

    /**
     * Function to set the players awaiting the change to the next gamestate to
     * 0
     *
     * @throws RemoteException
     */
    public void setPlayersDone() throws RemoteException;

    /**
     * Function that gets called when a player is finished with their action and
     * they're awaiting the change to the the next gamestate
     *
     * @throws RemoteException
     */
    public void addPlayerDone() throws RemoteException;

    /**
     * Function to get the amount of rounds in a game
     *
     * @return the amount of rounds as a string
     * @throws RemoteException
     */
    public String getNumberOfRounds() throws RemoteException;

}
