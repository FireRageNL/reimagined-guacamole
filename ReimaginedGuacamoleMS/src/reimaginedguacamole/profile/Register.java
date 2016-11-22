/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class Register extends UnicastRemoteObject implements IRegister {

    public Register() throws RemoteException {
    }

    @Override
    public void registerNewUser(LinkedHashMap profileData) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        pdb.newUserRegistration(profileData);
        Logger.getLogger(Register.class.getName()).log(Level.INFO, "User regsitration!");
    }

}
