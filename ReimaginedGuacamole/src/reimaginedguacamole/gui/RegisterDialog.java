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
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import reimaginedguacamole.profile.IGameServer;
import reimaginedguacamole.profile.IRegister;
import reimaginedguacamole.tooling.Hashing;

/**
 * Class that creates a dialog for registering a user.
 *
 * @author roy_v
 */
public class RegisterDialog {

    /**
     * Constructor that creates a register dialog and that handles the complete
     * registration process
     */
    public RegisterDialog() {
        //Set all UI elements
        Dialog<LinkedHashMap> dialog = new Dialog<>();
        dialog.setTitle("Registreren");
        dialog.setHeaderText("Maak een nieuwe account aan");
        ButtonType registerButtonType = new ButtonType("Register", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(registerButtonType, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        TextField email = new TextField();
        email.setPromptText("Email");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        TextField username = new TextField();
        username.setPromptText("Gebruikersnaam");
        TextField name = new TextField();
        name.setPromptText("Voornaam");
        Text error = new Text();
        error.setFill(Color.RED);
        grid.add(new Label("Email:"), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Wachtwoord:"), 0, 1);
        grid.add(password, 1, 1);
        grid.add(new Label("Gebruikersnaam:"), 0, 2);
        grid.add(username, 1, 2);
        grid.add(new Label("Voornaam:"), 0, 3);
        grid.add(name, 1, 3);
        grid.add(error, 1, 4);
        Node registerButton = dialog.getDialogPane().lookupButton(registerButtonType);
        registerButton.setDisable(true);

        email.textProperty().addListener((observable, oldValue, newValue) -> 
            registerButton.setDisable(newValue.trim().isEmpty()));
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> email.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            LinkedHashMap hm = new LinkedHashMap();
            if (dialogButton == registerButtonType) {
                if (email.getText().isEmpty() || password.getText().isEmpty() || username.getText().isEmpty() || name.getText().isEmpty()) {
                    error.setText("Niet alle velden zijn ingevuld");
                    hm.put("Error", "1");
                    return hm;
                }
                if (!verifyEmail(email.getText())) {
                    error.setText("E-mail adres is niet juist ingevuld");
                    hm.put("Error", "1");
                    return hm;
                }
                hm.put("Email", email.getText());
                hm.put("Password", Hashing.hashPassword(password.getText()));
                hm.put("Nickname", username.getText());
                hm.put("Name", name.getText());
                return hm;
            }
            return null;
        });
        //Open the dialog and wait for result
        Optional<LinkedHashMap> result = dialog.showAndWait();
        while (result.isPresent()) {
            if (result.get().size() == 4) {
                break;
            }
            while (result.get().size() < 3) {
                if (result.get().containsKey("Close")) {
                    dialog.hide();
                } else {
                    result = dialog.showAndWait();
                }
            }
        }
        if (result.isPresent() && result.get().size() == 4) {
            try {
                //If result is ok, insert into database.
                Registry reg = LocateRegistry.getRegistry("127.0.0.1", 666);
                IGameServer gs = (IGameServer) reg.lookup("GameServer");
                gs.registerNewUser(result.get());
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(RegisterDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Method that verifies if a given address is indeed an email
     *
     * @param email the value to be verified
     * @return true or false if the verification succeeded
     */
    public boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
