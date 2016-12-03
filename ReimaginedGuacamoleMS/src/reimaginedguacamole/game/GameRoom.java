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
public class GameRoom extends UnicastRemoteObject implements IGameRoom {

    //private IGameController
    private String name;
    private List<IProfile> players;
    private ChatServer chatServer;
    private GameController gameController;
    private String ip;

    public GameRoom() throws RemoteException {
        //Overwrite for default constructor
    }

    /**
     * Constructor to build a new game room
     *
     * @param rounds the amount of rouds the game in the game room will have
     * @param duration the time period a person has for anwsering a question in
     * this game
     * @param roomname the name of the room
     * @param ip the IP the game room runs on
     * @throws RemoteException
     * @throws NotBoundException
     */
    public GameRoom(int rounds, int duration,String roomname,String ip) throws RemoteException, NotBoundException {
        this.gameController = new GameController(rounds, duration);
        this.players = new ArrayList<>();
        this.name = roomname;
        this.ip = ip;//This has to be overwritten to localhost later on but for testing purposes its set to the client IP that later will have the game server!!

    }

    @Override
    public int getNrOfPlayers() throws RemoteException {
        return players.size();
    }

    @Override
    public void joinRoom(IProfile profile) throws RemoteException {
        players.add(profile);
        gameController.AddPlayersCount();

    }

    @Override
    public void leaveRoom(IProfile profile) throws RemoteException {
        players.remove(profile);
    }

    public String getName() {
        return this.name;
    }

    public String getIp(){
        return this.ip;
    }
    public String getNumberOfRounds() throws RemoteException {
        return Integer.toString(this.gameController.getGame().getAmountOfRounds());
    }

    @Override
    public List<String> getNicknames() throws RemoteException {
        List<String> nicks = new ArrayList();
        for (IProfile p : players) {
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
        //ToImplement on room change, either player joining or game starting
    }

}
