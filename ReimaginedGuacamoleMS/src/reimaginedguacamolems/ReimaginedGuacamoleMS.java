/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import reimaginedguacamole.game.Game;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.Round;
import reimaginedguacamole.profile.ChatServer;
import reimaginedguacamole.profile.GameServer;
import reimaginedguacamole.profile.Login;
import reimaginedguacamole.profile.Register;

/**
 *
 * @author roy_v
 */
public class ReimaginedGuacamoleMS {

    private ReimaginedGuacamoleMS() {
        throw new IllegalAccessError("Utility class");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger(ReimaginedGuacamoleMS.class.getCanonicalName()).log(Level.INFO, "Application starting up!");
        try {
            GameServer gs = new GameServer();
            //Game game = new Game();
            //Round round = new Round();
            ChatServer server = new ChatServer();
            //GameController gamecontroller = new GameController();
            Registry reg;
            reg = LocateRegistry.createRegistry(666);
            reg.rebind("GameServer", gs);
            //reg.rebind("Game",game);
            //reg.rebind("Round",round);
            reg.rebind("ChatServer",server);
            //reg.rebind("GameController", gamecontroller);
            Logger.getLogger(ReimaginedGuacamoleMS.class.getCanonicalName()).log(Level.INFO, "Application started!");

        } catch (RemoteException ex) {
            Logger.getLogger(ReimaginedGuacamoleMS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
