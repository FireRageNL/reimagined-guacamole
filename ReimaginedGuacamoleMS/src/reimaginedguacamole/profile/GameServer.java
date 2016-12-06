/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.GameRoom;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.gui.IUpdateLobby;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class GameServer extends UnicastRemoteObject implements IGameServer {

    private ArrayList<GameRoom> gameRooms = new ArrayList<>();
    private ArrayList<IUpdateLobby> lobbyUpdater = new ArrayList<>();
    
    public GameServer() throws RemoteException{
        //Wooo new thingy :D
    }
    
    @Override
    public boolean tryLogin(String username, String password) throws RemoteException {
        ProfileDB pdb = new ProfileDB();
        boolean login = pdb.login(password, username);
        if (!login) {
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO, "Login try for user " + username + " failed");
        } else {
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO, "Login try for user " + username + " succeded");
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
    public IGameRoom createGameRoom(int duration, int rounds,String roomname, String ip) throws RemoteException {
        GameRoom gr;
        try {
            gr = new GameRoom(duration,rounds,roomname,ip);
            gameRooms.add(gr);
            sendGameRoomData();
            Logger.getLogger(GameServer.class.getName()).log(Level.INFO,"Added a new GameRoom: {0}",gr.getName());
            return gr;
        } catch (NotBoundException | UnknownHostException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void sendGameRoomData() throws RemoteException {
        ArrayList<String> roomData = new ArrayList<>();
        if(!gameRooms.isEmpty()){
            for(GameRoom r : gameRooms){
                String room ="Game room name: "+r.getName()+ " Players: " + r.getNrOfPlayers() + " /4   "+ " Amount of Rounds: " + r.getNumberOfRounds()+ " IP address of server: "+r.getIp();
                roomData.add(room);
            }
        }
        for(IUpdateLobby lb : lobbyUpdater){
            lb.updateGameRooms(roomData);
        }
    }

    @Override
    public void addLobbyUser(IUpdateLobby user) throws RemoteException {
        this.lobbyUpdater.add(user);
    }
    
}
