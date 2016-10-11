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
import reimaginedguacamole.profile.Statistic;

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
    @FXML
    ProgressBar pbRoundTimer;
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
    Profile user;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (!password.isEmpty() && !username.isEmpty()) {
            Login log = new Login();
            boolean loggedin = log.tryLogin(username, password);
            if (loggedin) {
                user = log.getCurrentProfile(username);
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
    @FXML
    private void changeNickName(ActionEvent event){
        user.setNickName(txtNickname.getText());
    }

    private void fillProfileData(Profile user) {
        txtNickname.setText(user.getNickname());
        lblEmail.setText(user.getEmail());
        lblWins.setText(Integer.toString(user.getWins()));
        lblLoss.setText(Integer.toString(user.getLosses()));
        for (Statistic s : user.getStatistics()) {
            switch (s.getCategory()) {
                case History:
                    lblWinHis.setText(Integer.toString(s.getRight()));
                    lblLossHis.setText(Integer.toString(s.getWrong()));
                    break;
                case Art:
                    lblWinArt.setText(Integer.toString(s.getRight()));
                    lblLossArt.setText(Integer.toString(s.getWrong()));
                    break;
                case Music:
                    lblWinMus.setText(Integer.toString(s.getRight()));
                    lblLossMus.setText(Integer.toString(s.getWrong()));
                    break;
                case Entertainment:
                    lblWinEnt.setText(Integer.toString(s.getRight()));
                    lblLossEnt.setText(Integer.toString(s.getWrong()));
                    break;
                case Games:
                    lblWinGame.setText(Integer.toString(s.getRight()));
                    lblLossGame.setText(Integer.toString(s.getWrong()));
                    break;
                case Sport:
                    lblWinSpr.setText(Integer.toString(s.getRight()));
                    lblLossSpr.setText(Integer.toString(s.getWrong()));
                    break;
                case Science:
                    lblWinSci.setText(Integer.toString(s.getRight()));
                    lblLossSci.setText(Integer.toString(s.getWrong()));
                    break;
            }
        }

    }


}
