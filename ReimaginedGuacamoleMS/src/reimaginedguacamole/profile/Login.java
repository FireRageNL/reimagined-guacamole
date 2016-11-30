/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;
import java.util.logging.Level;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class Login extends UnicastRemoteObject implements ILogin {

    public Login() throws RemoteException {
        //Empty constructor to overwrite the default constructor
    }

    @Override
    public boolean tryLogin(String username, String password) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        boolean login = pdb.login(password, username);
        if (!login) {
            Logger.getLogger(Login.class.getName()).log(Level.INFO, "Login try for user " + username + " failed");
        } else {
            Logger.getLogger(Login.class.getName()).log(Level.INFO, "Login try for user " + username + " succeded");
        }
        return login;
    }

    @Override
    public IProfile getCurrentProfile(String email) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        return pdb.getProfileData(email);
    }

}
