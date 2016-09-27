/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import reimaginedguacamole.database.ProfileDB;
import reimaginedguacamole.profile.Login;

/**
 *
 * @author roy_v
 */
public class RegisterDialog {

    private MessageDigest md;

    public RegisterDialog() {
        Dialog<LinkedHashMap> dialog = new Dialog<>();
        dialog.setTitle("Registreren");
        dialog.setHeaderText("Plx register nau");
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
        grid.add(new Label("Email:"), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Wachtwoord:"), 0, 1);
        grid.add(password, 1, 1);
        grid.add(new Label("Gebruikersnaam:"), 0, 2);
        grid.add(username, 1, 2);
        grid.add(new Label("Voornaam:"), 0, 3);
        grid.add(name, 1, 3);
        Node registerButton = dialog.getDialogPane().lookupButton(registerButtonType);
        registerButton.setDisable(true);
        email.textProperty().addListener((observable, oldValue, newValue) -> {
            registerButton.setDisable(newValue.trim().isEmpty());
        });
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> email.requestFocus());
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == registerButtonType) {
                StringBuilder sb = new StringBuilder();
                try {
                    this.md = MessageDigest.getInstance("SHA-256");
                    byte[] result = md.digest(password.getText().getBytes());

                    for (int i = 0; i < result.length; i++) {
                        sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                LinkedHashMap hm = new LinkedHashMap();
                hm.put("Email", email.getText());
                hm.put("Password", sb.toString());
                hm.put("Nickname", username.getText());
                hm.put("Name", name.getText());
                return hm;
            }
            return null;
        });
        Optional<LinkedHashMap> result = dialog.showAndWait();
        if (result.isPresent()) {
            ProfileDB pdb = new ProfileDB();
            pdb.Insert("Profile", result.get());
        }

    }
}
