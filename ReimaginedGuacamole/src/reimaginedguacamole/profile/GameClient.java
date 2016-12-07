/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.gui.FXMLController;
import reimaginedguacamole.timertasks.spinTimerTask;

/**
 *
 * @author roy_v
 */
public class GameClient extends UnicastRemoteObject implements IGameClient {

    private IProfile prof;
    private FXMLController application;

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
        Platform.runLater(() -> {
            application.setWindows(0);
        });
    }

    @Override
    public void disableStartButton(boolean state) throws RemoteException {
        Platform.runLater(() -> {
            application.disableStartButton(state);
        });
    }

    @Override
    public void disableButtons(boolean state) throws RemoteException {
        Platform.runLater(() -> {
            application.disableButtons(state);
        });
    }

    @Override
    public void disableSpinButton(boolean state) throws RemoteException {
        Platform.runLater(() -> {
            application.disableButtons(state);
        });
    }

    @Override
    public void checkGameState(GameState gameState) throws RemoteException {
        Platform.runLater(() ->{
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
        System.out.println("Client spin");
        application.spinWheel(wheelspeed);
        //Timer t = new Timer(true);
        //t.schedule(new spinTimerTask(application), 7000);
    }

    @Override
    public void refreshUI(int[] scores, List<String> names) throws RemoteException {
        application.refreshUI(scores, names);
    }

}


