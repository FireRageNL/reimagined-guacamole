/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reimaginedguacamole.game.Game;
import reimaginedguacamole.profile.Login;
import reimaginedguacamole.profile.Profile;

/**
 *
 * @author daan
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    @FXML
    private Pane loginPane;

    @FXML
    private Pane gamePane;
    @FXML ProgressBar pbRoundTimer;
    double seconds;
    
    
    @FXML
    private Pane profilePane;
    @FXML
    private TextField txtNickname;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblWins;
    @FXML
    private Label lblLoss;
    @FXML
    private Label lblWinHis;
    @FXML
    private Label lblLossHis;
    @FXML
    private Label lblWinArt;
    @FXML
    private Label lblLossArt;
    @FXML
    private Label lblWinGame;
    @FXML
    private Label lblLossGame;
    @FXML
    private Label lblWinEnt;
    @FXML
    private Label lblLossEnt;
    @FXML
    private Label lblWinMus;
    @FXML
    private Label lblLossMus;
    @FXML
    private Label lblWinSpr;
    @FXML
    private Label lblLossSpr;
    @FXML
    private Label lblWinSci;
    @FXML
    private Label lblLossSci;

    
    Game _game;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (!password.isEmpty() && !username.isEmpty()) {
            Login log = new Login();
            boolean loggedin = log.tryLogin(username, password);
            if (loggedin) {
                Profile user = log.getCurrentProfile(username);
                fillProfileData(user);
                profilePane.setVisible(true);
                loginPane.setVisible(false);
            } else {
                label.setText("Gebruikersnaam/Wachtwoord fout");
            }
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gamePane.setVisible(false);
        loginPane.setVisible(true);
        profilePane.setVisible(false);
    }
    
    
    @FXML
    private void clickRegister(MouseEvent event) {
        RegisterDialog regdialog = new RegisterDialog();
    }

    private void fillProfileData(Profile user) {
        txtNickname.setText(user.getNickname());
        lblEmail.setText(user.getEmail());
        lblWins.setText(Integer.toString(user.getWins()));
        lblLoss.setText(Integer.toString(user.getLosses()));
    }
    
    private void startRound(){
        seconds = 1;
        AnimationTimer gameTimer = new AnimationTimer(){
            private long prevUpdate;

            @Override
            public void handle(long now){
                long lag = now - prevUpdate;
                if (lag >= 20000000) {
                    if(seconds > 0){
                    seconds-= 0.0033;
                    pbRoundTimer.setProgress(seconds);
                    System.out.println(seconds);
                    }
                else{
                        seconds = 1;
                    }
                    prevUpdate = now;
                }
            }
            @Override public void start(){
                prevUpdate = System.nanoTime();
                super.start();
            }
        };
        
        gameTimer.start();
    }
    
}
