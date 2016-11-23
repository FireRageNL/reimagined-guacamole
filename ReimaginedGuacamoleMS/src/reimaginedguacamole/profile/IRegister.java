/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;

/**
 *
 * @author roy_v
 */
public interface IRegister extends Remote {
    
    public void registerNewUser(LinkedHashMap profileData) throws RemoteException;
    
}
