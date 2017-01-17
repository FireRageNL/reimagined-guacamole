/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import reimaginedguacamole.game.IQuestion;
import reimaginedguacamole.profile.IGameServer;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author roy_v
 */
public interface IMasterServer extends Remote {

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
     * Return a certain amount of questions
     *
     * @param amount the amount of questions per category to return
     * @return the questions
     * @throws RemoteException
     */
    public List<IQuestion> getQuestions(int amount) throws RemoteException;

    /**
     * Update the users' statiscics
     *
     * @param prof the profile to update
     * @throws RemoteException
     */
    public void updateStats(IProfile prof) throws RemoteException;

    /**
     * Function that gets called at the end of the game to update the player
     * score
     *
     * @param userID The UserID to update the score of
     * @param score The score
     * @throws RemoteException
     */
    public void endGame(int userID, int score) throws RemoteException;

    /**
     * Register a new gameserver on the masterserver
     *
     * @param gs the gameserver to register
     * @throws RemoteException
     */
    public void regNewGame(IGameServer gs) throws RemoteException;

    /**
     * Delete a gameserver from the masterserver
     *
     * @param gs the gameserver to delete
     * @throws RemoteException
     */
    public void unregGameServer(IGameServer gs) throws RemoteException;

    /**
     * Return a list of gameservers currently available on the server
     *
     * @return the list of gameservers
     * @throws RemoteException
     */
    public List<IGameServer> sendGameRoomData() throws RemoteException;
    
}
