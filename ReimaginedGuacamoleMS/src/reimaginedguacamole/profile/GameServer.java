/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.IGameController;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class GameServer extends UnicastRemoteObject implements IGameServer {

    public GameServer() throws RemoteException{
        //Wooo new thingy :D
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

    @Override
    public void registerNewUser(Map profileData) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        pdb.newUserRegistration(profileData);
        Logger.getLogger(Register.class.getName()).log(Level.INFO, "User registration!");
    }

    @Override
    public IGameController createController(int round, int duration) throws RemoteException {
        GameController gc;
        try {
            gc = new GameController(duration,round);
            return gc;
        } catch (NotBoundException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
