/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.profile.IGameServer;

/**
 *
 * @author roy_v
 */
public class GameRoomDialog {

    public GameRoomDialog() {
        Dialog<List> dialog = new Dialog<>();
        dialog.setTitle("Game instellingen");
        dialog.setHeaderText("Geef hier de instellingen op voor de game die je aan wilt maken");
        SpinnerValueFactory svfr = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 10, 1);
        SpinnerValueFactory svfd = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 30, 15, 1);
        Label label1 = new Label("Rondes: ");
        Label label2 = new Label("Antwoordtijd: ");
        Spinner spr = new Spinner();
        spr.setValueFactory(svfr);
        spr.setEditable(true);
        spr.setPrefWidth(80);
        Spinner spr2 = new Spinner();
        spr2.setValueFactory(svfd);
        spr2.setEditable(true);
        spr2.setPrefWidth(80);
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(spr, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(spr2, 2, 2);
        dialog.getDialogPane().setContent(grid);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.setResultConverter((ButtonType param) -> {
            if (param == buttonTypeOk) {
                List<Integer> toRet;
                toRet = new ArrayList<>();
                toRet.add(Integer.parseInt(spr.getValueFactory().getValue().toString()));
                toRet.add(Integer.parseInt(spr2.getValueFactory().getValue().toString()));
                return toRet;
            }
            return new ArrayList<>();
        });
        Optional<List> result = dialog.showAndWait();

        if (result.isPresent()) {
            List<Integer> res = result.get();
            try{
            Registry reg2 = LocateRegistry.getRegistry("127.0.0.1", 666);
            IGameServer gs = (IGameServer) reg2.lookup("GameServer");
            gs.createGameRoom(res.get(0), res.get(1));
            }
            catch(RemoteException | NotBoundException ex){
                Logger.getLogger(GameRoomDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
