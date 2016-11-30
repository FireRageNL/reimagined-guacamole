/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

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
                List<String> toRet = new ArrayList<>();
                toRet.add(spr.getValueFactory().getValue().toString());
                toRet.add(spr2.getValueFactory().getValue().toString());
                return toRet;
            }
            return new ArrayList<>();
        });
        Optional<List> result = dialog.showAndWait();
        
        if(result.isPresent()){
            List<String> res = result.get();
            res.stream().forEach((s) -> {
                System.out.println(s);
            });
            
        }
    }

}
