/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

/**
 *
 * @author roy_v
 */
public class GameRoomDialog {

    Dialog<List> dialog;
    /**
     * Constructor for a dialog that lets the user select the amount of rounds
     * and the duration of each round for a game, the constructor builds itself
     * and then launches itself
     * @throws java.net.UnknownHostException
     */
    public GameRoomDialog() throws UnknownHostException {
        dialog = new Dialog<>();
        dialog.setTitle("Game instellingen");
        dialog.setHeaderText("Geef hier de instellingen op voor de game die je aan wilt maken");
        SpinnerValueFactory svfr = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 10, 1);
        SpinnerValueFactory svfd = new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 30, 15, 1);
        Label labelName = new Label("Spelnaam: ");
        Label labelRounds = new Label("Rondes: ");
        Label labelDuration = new Label("Antwoordtijd: ");
        TextField name = new TextField();
        name.textProperty().set("Nieuwe gameroom");
        Spinner spr = new Spinner();
        spr.setValueFactory(svfr);
        spr.setEditable(true);
        spr.setPrefWidth(80);
        Spinner spr2 = new Spinner();
        spr2.setValueFactory(svfd);
        spr2.setEditable(true);
        spr2.setPrefWidth(80);
        GridPane grid = new GridPane();
        grid.add(labelName,1,1);
        grid.add(name,2,1);
        grid.add(labelRounds, 1, 3);
        grid.add(spr, 2, 3);
        grid.add(labelDuration, 1, 4);
        grid.add(spr2, 2, 4);
        dialog.getDialogPane().setContent(grid);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.setResultConverter((ButtonType param) -> {
            if (param == buttonTypeOk) {
                List<String> toRet;
                toRet = new ArrayList<>();
                toRet.add(spr.getValueFactory().getValue().toString());
                toRet.add(spr2.getValueFactory().getValue().toString());
                toRet.add(name.textProperty().getValue());
                return toRet;
            }
            return new ArrayList<>();
        });
    }

    public Dialog<List> getDialog() {
        return dialog;
    }
}
