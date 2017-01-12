/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.Score;
import reimaginedguacamole.gui.FXMLController;

/**
 *
 * @author roy_v
 */
public class GameClient extends UnicastRemoteObject implements IGameClient {

    private IProfile prof;
    private FXMLController application;
    private Client chatClient;

    /**
     * Default constructor for a game client
     *
     * @param app the fxmlcontroller class that initialized this client, and
     * where UI calls have to go to
     * @throws RemoteException
     */
    public GameClient(FXMLController app) throws RemoteException {
        application = app;
    }

    public IProfile getProf() {
        return prof;
    }

    public void setProf(IProfile prof) {
        this.prof = prof;
    }

    @Override
    public IProfile getProfile() throws RemoteException {
        return this.prof;
    }

    @Override
    public void joinGame() throws RemoteException {
            chatClient = new Client(prof,application.getChatList(),application);
        Platform.runLater(()
                -> application.setWindows(0)
        );
    }

    @Override
    public void disableStartButton(boolean state) throws RemoteException {
        Platform.runLater(()
                -> application.disableStartButton(state)
        );
    }

    @Override
    public void disableButtons(boolean state) throws RemoteException {
        Platform.runLater(()
                -> application.disableButtons(state)
        );
    }

    @Override
    public void disableSpinButton(boolean state) throws RemoteException {
        Platform.runLater(()
                -> application.disableButtons(state)
        );
    }

    @Override
    public void checkGameState(GameState gameState) throws RemoteException {
        Platform.runLater(() -> {
            try {
                application.checkGameState(gameState);
            } catch (RemoteException ex) {
                Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void setUserIndex(int i) throws RemoteException {
        application.setUserIndex(i);
    }

    @Override
    public void spinWheel(int wheelspeed, int time) throws RemoteException {
        application.spinWheel(wheelspeed);
    }

    @Override
    public void refreshUI(List<Score> scores) throws RemoteException {
        Platform.runLater(()
                -> application.refreshUI(scores)
        );
    }
    
    @Override
    public IClient getChatClient(){
        return chatClient;
        
    }
    
    
}
