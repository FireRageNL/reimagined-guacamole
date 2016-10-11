/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import static java.lang.Math.round;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.profile.Login;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.profile.Statistic;
import reimaginedguacamole.timertasks.WaitingForCategoryTimerTask;

/**
 *
 * @author daan
 */
public class FXMLLoginController implements Initializable, Observer{

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

    //Global variables
    GameController gameController;
    Profile user;
    
    
    // TIMERS
    private Timer waitTimer;
    private AnimationTimer animationTimer;
    public static final int NANO_TICKS = 20000000;
    int x = 0;
    
    
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
                setWindows(2);
            } else {
                label.setText("Gebruikersnaam/Wachtwoord fout");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setWindows(1);
    }

    
    public void setWindows(int index){
        gamePane.setVisible(false);
        loginPane.setVisible(false);
        profilePane.setVisible(false);
        switch(index){
            case 0:
                gamePane.setVisible(true);
                break;
            case 1:
                loginPane.setVisible(true);
                break;
            case 2:
                profilePane.setVisible(true);
                break;
        }
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
    
    @FXML
    private void startGame(){
        gameController = new GameController(10,1);
        gameController.addObserver(this);
        gameController.startNextRound();
        gameController.setGameState(GameState.WaitingForCategory);
    }
    
    
    private void checkGameState(){
        switch(gameController.getGameState()){
            case Waiting:
                break;
            case WaitingForCategory:
                waitTimer = new Timer(true);
                waitTimer.schedule(new WaitingForCategoryTimerTask(gameController), 2000);
                setWindows(0);
                break;
            case Spinning:
                System.out.println("Start Spinning");
                spinWheel();
                break;
            case GameFinished:
                break;
            case GameRunning:
                break;   
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        checkGameState();
    }
    
    
    public void spinWheel(){
        
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {

                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                        x++;
                        System.out.println(x);
			prevUpdate = now;
                }

            }
            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                super.start();
            }
        };
        
        animationTimer.start();
    }


}
