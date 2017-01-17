/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gameserver;

import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.networking.IMasterServer;

/**
 *
 * @author roy_v
 */
public class ServerRunnable implements Runnable {

    private IMasterServer ms;
    private int duration;
    private int rounds;
    private String roomName;
    private String ip;

    /**
     * Constructor to override the default constructor
     * @throws RemoteException 
     */
    public ServerRunnable() throws RemoteException {
        //Such override
    }

    /**
     * Constructor to create a new gameServer thread
     * @param duration The amount of time that a player has to answer a question
     * @param rounds The amount of rounds a game has
     * @param roomname The name of the room
     * @param ip The IP of the server the room runs on
     * @param ms The masterserver
     * @throws RemoteException 
     */
    public ServerRunnable(int duration, int rounds, String roomname, String ip, IMasterServer ms) throws RemoteException {
        this.ms = ms;
        this.duration = duration;
        this.rounds = rounds;
        this.roomName = roomname;
        this.ip = ip;
    }

    @Override
    public void run() {
        try {
            GameServer gs = new GameServer();
            gs.createGameRoom(duration, rounds, roomName, ip, ms);
            ms.regNewGame(gs);
            while (!Thread.currentThread().isInterrupted()) {
                sleep(20);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRunnable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerRunnable.class.getName()).log(Level.INFO, null, "So I'm GlaD, I got burned...");
        }
    }

}
