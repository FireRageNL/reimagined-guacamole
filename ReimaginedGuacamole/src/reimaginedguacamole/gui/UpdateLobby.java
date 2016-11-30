/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javafx.application.Platform;

/**
 *
 * @author roy_v
 */
public class UpdateLobby extends UnicastRemoteObject implements IUpdateLobby {

    private FXMLController app;

    public UpdateLobby(FXMLController application) throws RemoteException {
        this.app = application;
    }

    @Override
    public void updateGameRooms(List<String> gameRoomsData) throws RemoteException {
        Platform.runLater(() -> {
            app.updateRoomList(gameRoomsData);
        });

    }
}
