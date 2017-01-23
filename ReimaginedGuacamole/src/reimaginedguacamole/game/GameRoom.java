/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import reimaginedguacamole.gameserver.GameServer;
import reimaginedguacamole.networking.IMasterServer;
import reimaginedguacamole.profile.IGameClient;
import reimaginedguacamole.profile.IGameServer;

/**
 *
 * @author daan
 */
public class GameRoom extends UnicastRemoteObject implements IGameRoom {

    //private IGameController
    private String name;
    private static List<IGameClient> players;
    private IGameController gameController;
    private String ip;
    private int playersDone;
    private static IMasterServer ms;
    private static GameServer gs;

    public GameRoom() throws RemoteException {
        //Overwrite for default constructor
    }

    /**
     * Constructor to build a new game room
     *
     * @param rounds the amount of rounds the game in the game room will have
     * @param duration the time period a person has for anwsering a question in
     * this game
     * @param roomname the name of the room
     * @param ip the IP the game room runs on
     * @param gs the gameserver that initialized this gameroom
     * @param ms the masterserver
     * @throws RemoteException
     * @throws NotBoundException
     * @throws UnknownHostException
     */
    public GameRoom(int rounds, int duration, String roomname, String ip, GameServer gs, IMasterServer ms) throws RemoteException, NotBoundException, UnknownHostException {
        this.gameController = new GameController(rounds, duration, gs, this, ms);
        GameRoom.players = new ArrayList<>();
        this.name = roomname;
        playersDone = 0;
        //this.ip = ip; //This has to be overwritten to localhost later on but for testing purposes its set to the client IP that later will have the game server!!
        this.ip = InetAddress.getLocalHost().getHostAddress();
        GameRoom.gs = gs;
        GameRoom.ms = ms;
    }

    @Override
    public int getNrOfPlayers() throws RemoteException {
        return gameController.checkPlayers();
    }

    @Override
    public void joinRoom(IGameClient profile) throws RemoteException {
        players.add(profile);
        gameController.addPlayersCount();
        Logger.getLogger(GameRoom.class.getCanonicalName()).log(Level.INFO, "{0} Has joined the room", profile.getProfile().getNickname());
    }

    @Override
    public void leaveRoom(IGameClient profile) throws RemoteException {
        players.remove(profile);
        boolean isGameNotRunning = false;
        for (IGameServer sv : ms.sendGameRoomData()) {
            if (sv.getIp() == null ? gs.getIp() == null : sv.getIp().equals(gs.getIp())) {
                isGameNotRunning = true;
            }
        }
        if (!isGameNotRunning) {
            players.forEach((IGameClient cl) -> 
                Platform.runLater(() -> {
                    try {
                        cl.playerLeftIngame();
                    } catch (RemoteException ex) {
                        Logger.getLogger(GameRoom.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }));
        }
        gameController.removePlayersCount();
    }

    public String getName() {
        return this.name;
    }

    public String getIp() {
        return this.ip;
    }

    @Override
    public String getNumberOfRounds() throws RemoteException {
        return Integer.toString(this.gameController.getGame().getAmountOfRounds());
    }

    @Override
    public List<String> getNicknames() throws RemoteException {
        List<String> nicks = new ArrayList();
        for (IGameClient c : players) {
            nicks.add(c.getProfile().getNickname());
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

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public IGameController getGameController() throws RemoteException {
        return this.gameController;
    }

    @Override
    public List<IGameClient> getPlayers() throws RemoteException {
        return players;
    }

    @Override
    public String getGameRoomListing() throws RemoteException {
        return this.name + "    Players: " + this.getNrOfPlayers() + "    Rondes: " + this.getNumberOfRounds();
    }

    @Override
    public int getPlayersDone() throws RemoteException {
        return playersDone;
    }

    @Override
    public void addPlayerDone() throws RemoteException {
        playersDone++;
    }

    @Override
    public void setPlayersDone() throws RemoteException {
        playersDone = 0;
    }

}
