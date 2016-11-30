/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 *
 * @author roy_v
 */
@FunctionalInterface
public interface IRegister extends Remote {
    /**
     * Function to register a new user
     * @param profileData The data for the new user
     * @throws RemoteException 
     */
    public void registerNewUser(Map profileData) throws RemoteException;
    
}
