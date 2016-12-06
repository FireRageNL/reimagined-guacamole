/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import reimaginedguacamole.game.IGameRoom;

/**
 *
 * @author roy_v
 */
public interface IGameServer extends Remote {

    /**
     * Function to test username and password provided
     *
     * @param username is the username provided
     * @param password is the password provided
     * @return True or false if the user and password combination is correct
     * @throws RemoteException
     */
    public boolean tryLogin(String username, String password) throws RemoteException;

    /**
     * Function to get all the profile information of a user when they're logged
     * in
     *
     * @param email The email of user to get the profile information from
     * @return The profile of said user
     * @throws RemoteException
     */
    public IProfile getCurrentProfile(String email) throws RemoteException;

    /**
     * Function to register a new user
     *
     * @param profileData The data for the new user
     * @throws RemoteException
     */
    public void registerNewUser(Map profileData) throws RemoteException;

    /**
     * Function that creates a new gameRoom to be created and registered on the
     * gameserver
     *
     * @param duration the time each user has to anwser one question
     * @param rounds the amout of rounds in a game
     * @param roomname the name of the gameroom
     * @param ip the IP address the game runs on
     * @return the newly created gameroom object
     * @throws RemoteException
     */
    public IGameRoom createGameRoom(int duration, int rounds, String roomname, String ip) throws RemoteException;

    /**
     * Function to publish the roomdata into the lobby view
     *
     * @return 
     * @throws RemoteException
     */
    public List<IGameRoom> sendGameRoomData() throws RemoteException;

    /**
     * Function to add a user to the current list of users in the lobby, so that
     * data gets pushed to every user in the lobby
     *
     * @param user the user to add to the list of users
     * @throws RemoteException
     */

    public void joinRoom(IGameClient user, IGameRoom room) throws RemoteException;

    public void startGame(IGameRoom joinedRoom) throws RemoteException;
}
