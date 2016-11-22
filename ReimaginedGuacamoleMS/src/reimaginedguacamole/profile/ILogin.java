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
    
    public boolean tryLogin(String username,String password) throws RemoteException;
    
    public Profile getCurrentProfile(String email) throws RemoteException;
    
}
