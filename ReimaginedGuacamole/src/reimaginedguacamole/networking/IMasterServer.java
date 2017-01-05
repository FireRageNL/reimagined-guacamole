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
import reimaginedguacamole.game.Category;
import reimaginedguacamole.game.IGameRoom;
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
    
    public List<IQuestion>getQuestions(int amount) throws RemoteException;

    public void updateStats(IProfile prof, Category cat, boolean right) throws RemoteException;

    public void endGame(int userID, int score) throws RemoteException;
    
    public void regNewGame(IGameServer gs) throws RemoteException;
    
    public void unregGameServer(IGameServer gs) throws RemoteException;
    
    public List<IGameServer> sendGameRoomData() throws RemoteException;
}
