/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import reimaginedguacamole.profile.ChatServer;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author daan
 */
public class GameRoom extends UnicastRemoteObject implements IGameRoom{
    //private IGameController
    private String name;
    
    public GameRoom() throws RemoteException{
        
    }
    
    public GameRoom(int rounds, int duration) throws RemoteException, NotBoundException{
        this.GameController = new GameController(rounds,duration);
        this.players = new ArrayList<>();
        this.name = "TestGameRoom";
        
    }
    private List<IProfile> players;
    private ChatServer chatserver;
    private GameController GameController;

    
    @Override
    public int getNrOfPlayers() throws RemoteException {
        return players.size();
    }

    @Override
    public void joinRoom(IProfile profile) throws RemoteException {
        players.add(profile);
        GameController.AddPlayersCount();
        
    }

    @Override
    public void leaveRoom(IProfile profile) throws RemoteException {
        players.remove(profile);
    }
    public String getName(){
        return this.name;
    }

    public String getNumberOfRounds() throws RemoteException{
        return Integer.toString(this.GameController.getGame().getAmountOfRounds());
    }
    @Override
    public List<String> getNicknames() throws RemoteException {
        List<String> nicks = new ArrayList();
        for(IProfile p : players){
            nicks.add(p.getNickname());
        }
       return nicks;
    }

    @Override
    public IGameRoom createGameRoom(int duration, int rounds) throws RemoteException {
        //DoNothing
        return new GameRoom();
    }

    @Override
    public void announceRoom() throws RemoteException {
        
    }
    
    
}
