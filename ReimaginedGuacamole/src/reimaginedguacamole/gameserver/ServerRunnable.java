/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gameserver;

import java.rmi.RemoteException;
import reimaginedguacamole.networking.IMasterServer;

/**
 *
 * @author roy_v
 */
public class ServerRunnable implements Runnable {

    private GameServer gs;
    private IMasterServer ms;
    
    public ServerRunnable() throws RemoteException{
    }
    
    public ServerRunnable(IMasterServer ms) throws RemoteException{
        this.ms = ms;
        gs = new GameServer(ms);
    }
    @Override
    public void run() {
        while(true){
            System.out.println("I am running");
        }
    }
    
}
