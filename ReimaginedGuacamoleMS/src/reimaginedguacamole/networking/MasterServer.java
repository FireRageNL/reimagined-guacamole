/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.networking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.game.IQuestion;
import reimaginedguacamole.profile.IGameServer;
import reimaginedguacamole.profile.IProfile;
import reimaginedguacamole.profile.Register;
import reimaginedguacamolems.database.ProfileDB;
import reimaginedguacamolems.database.QuestionDB;

/**
 *
 * @author roy_v
 */
public class MasterServer extends UnicastRemoteObject implements IMasterServer {

    private List<IGameServer> gameservers = new ArrayList<>();

    public MasterServer() throws RemoteException {
        //Empty constructor because of reasons
    }

    @Override
    public synchronized boolean tryLogin(String username, String password) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        boolean login = pdb.login(password, username);
        if (!login) {
            Logger.getLogger(MasterServer.class.getName()).log(Level.INFO, "Login try for user " + username + " failed");
        } else {
            Logger.getLogger(MasterServer.class.getName()).log(Level.INFO, "Login try for user " + username + " succeded");
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
    public List<IQuestion> getQuestions(int amount) throws RemoteException {
        QuestionDB qdb = new QuestionDB();
        return qdb.getQuestions(amount);
    }

    @Override
    public void updateStats(IProfile prof, Category cat, boolean right) throws RemoteException {
        ProfileDB pdb = new ProfileDB();

    }

    @Override
    public void endGame(int userID, int score) throws RemoteException {
        ProfileDB pdb = new ProfileDB();

    }

    @Override
    public void regNewGame(IGameServer gs) throws RemoteException {
        gameservers.add(gs);
    }

    @Override
    public void unregGameServer(IGameServer gs) throws RemoteException {
        gameservers.remove(gs);
    }

    @Override
    public List<IGameServer> sendGameRoomData() throws RemoteException {
        return gameservers;
    }

}
