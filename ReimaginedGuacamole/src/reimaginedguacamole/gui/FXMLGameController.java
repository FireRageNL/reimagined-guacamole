/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import reimaginedguacamole.profile.Login;

/**
 *
 * @author daan
 */
public class FXMLGameController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField gebruikersnaam;

    @FXML
    private TextField wachtwoord;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = gebruikersnaam.getText();
        String password = wachtwoord.getText();
        if (!password.isEmpty() && !username.isEmpty()) {
            Login log = new Login();
            boolean loggedin = log.tryLogin(username,password);
            //label.setText(loggedin); //Debugging purposes so we can test if it works.
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void clickRegister(MouseEvent event){
        RegisterDialog regdialog = new RegisterDialog();
    }
}
