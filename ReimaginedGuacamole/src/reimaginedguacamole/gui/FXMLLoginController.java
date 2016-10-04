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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reimaginedguacamole.profile.Login;
import reimaginedguacamole.profile.Profile;

/**
 *
 * @author daan
 */
public class FXMLLoginController implements Initializable {

    @FXML private Label label;

    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    

    @FXML private Pane loginPane;
    @FXML private Pane gamePane;
    @FXML private Pane profilePane;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (!password.isEmpty() && !username.isEmpty()) {
            Login log = new Login();
            boolean loggedin = log.tryLogin(username,password);
            if(loggedin){
                Profile user = log.getCurrentProfile(username);
                label.setText("LOGGED IN JONG");
                gamePane.setVisible(true);
                loginPane.setVisible(false);
            }
            else{
                label.setText("FAILED KUT");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gamePane.setVisible(false);
        loginPane.setVisible(false);
        profilePane.setVisible(true);
        
    }
    @FXML
    private void clickRegister(MouseEvent event){
        RegisterDialog regdialog = new RegisterDialog();
    }
}
