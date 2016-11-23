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
public interface ILogin extends Remote{
    
    /**
     * Function to test username and password provided
     * @param username is the username provided
     * @param password is the password provided
     * @return True or false if the user and password combination is correct
     * @throws RemoteException 
     */
    public boolean tryLogin(String username,String password) throws RemoteException;
    
    /**
     * Function to get all the profile information of a user when they're logged in
     * @param email The email of user to get the profile information from
     * @return The profile of said user
     * @throws RemoteException 
     */
    public Profile getCurrentProfile(String email) throws RemoteException;
    
}
