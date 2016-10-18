/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.GameState;
import static reimaginedguacamole.game.GameState.*;
import reimaginedguacamole.game.Round;
import reimaginedguacamole.profile.*;
import reimaginedguacamole.timertasks.*;

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

    
    //GAME OBJECTS
    @FXML
    private ImageView wheel;
    @FXML
    private Button btnAnswer1;
    @FXML
    private Button btnAnswer2;
    @FXML
    private Button btnAnswer3;
    @FXML
    private Button btnAnswer4;
    @FXML
    private Label lblQuestion;
    @FXML
    private Button btnSpin;
    @FXML
    private Label lblAnnouncement;
    @FXML
    private Label lblGameName;
    @FXML
    private Label lblScore;
    
    //Global variables
    private GameController gameController;
    private Profile user;
    private Random rng;
    private int wheelSpeed;
    private int roundDuration,amountOfRounds;
    // TIMERS
    private Timer waitTimer;
    private AnimationTimer animationTimer;
    public static final int NANO_TICKS = 20000000;
    int wheelRotation = 0;
    double progress;
    
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
        rng = new Random();
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
        gameController = new GameController(roundDuration,amountOfRounds);
        gameController.addObserver(this);
        gameController.setGameState(GameState.WaitingForCategory);
    }
    
    
    private void EnableButtons(){
        btnAnswer1.setDisable(!btnAnswer1.isDisabled());
        btnAnswer2.setDisable(!btnAnswer2.isDisabled());
        btnAnswer3.setDisable(!btnAnswer3.isDisabled());
        btnAnswer4.setDisable(!btnAnswer4.isDisabled());
    }
    
    private void checkGameState(){
        
        Round round;
        
        
        switch(gameController.getGameState()){
            case Waiting:
                break;
            case WaitingForCategory:
                EnableButtons();
                lblGameName.setText(user.getNickname());
                btnSpin.setDisable(false);
                waitTimer = new Timer(true);
                lblAnnouncement.setText("Ben je er Klaar voor? Spin het wiel!");
                waitTimer.schedule(new WaitingForCategoryTimerTask(gameController), 20000);
                setWindows(0);
                break;
            case Spinning:
                resetQuestionUI();
                btnSpin.setDisable(true);
                lblAnnouncement.setText("Welke categorie zul je krijgen?");
                System.out.println("Start Spinning");
                spinWheel();
                waitTimer = new Timer(true);
                int time =  5000 + rng.nextInt(3000);
                System.out.println(time);
                
                waitTimer.schedule(new SpinTimerTask(gameController), time);
                break;
            case SpinningFinished:
                animationTimer.stop();
                System.out.println("ANIMATION STOPPED!");
                gameController.startNextRound();
                gameController.giveRoundQuestion(gameController.chooseCategory(wheel.getRotate()));
                
                round = gameController.getCurrentRound();
                pbRoundTimer.setProgress(-1);
                lblAnnouncement.setText("De categorie is "+round.getQuestion().getCategory() + "\n");
                waitTimer = new Timer(true);
                waitTimer.schedule(new WaitForQuestionTimerTask(gameController), 5000);
                break;
            case GameRunning:
                EnableButtons();
                round = gameController.getCurrentRound();
                lblQuestion.setText(round.getQuestion().getQuestionContents());
                btnAnswer1.setText(round.getQuestion().getAnswer1());
                btnAnswer2.setText(round.getQuestion().getAnswer2());
                btnAnswer3.setText(round.getQuestion().getAnswer3());
                btnAnswer4.setText(round.getQuestion().getAnswer4());
                startGameTimer();
                break; 
                
            case Answered:
                EnableButtons();
                if(gameController.checkAnswer(user, pbRoundTimer.getProgress())){
                    lblAnnouncement.setText("Goed gedaan!");
                }
                else{
                    lblAnnouncement.setText("Jammer!");
                }
                lblScore.setText(String.valueOf(gameController.getCurrentScore()));
                setButtonCorrect(gameController.getCurrentRound().getQuestion().getCorrectAnswer());
                btnSpin.setDisable(false);
                break;
              
            case GameFinished:
                break;
        }
    }

    private void resetQuestionUI(){
                lblQuestion.setText("Hier komt straks de vraag");
                btnAnswer1.setText("");
                btnAnswer2.setText("");
                btnAnswer3.setText("");
                btnAnswer4.setText("");
                btnAnswer1.setStyle("");
                btnAnswer2.setStyle("");
                btnAnswer3.setStyle("");
                btnAnswer4.setStyle("");
    }
    

    
    @Override
    public void update(Observable o, Object arg) {
        checkGameState();
    }
    
    @FXML
    public void btnSpinClicked(){
        waitTimer.cancel();
        gameController.setGameState(Spinning);
    }
    
    public void spinWheel(){
        wheelSpeed = 13 + rng.nextInt(6);
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {

                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if(wheelRotation < 360){
                        wheelRotation+= wheelSpeed;
                    }
                    else{
                        wheelRotation+= wheelSpeed;
                        wheelRotation= wheelRotation -360;
                    }
                        wheel.setRotate(wheelRotation);
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
    
    public void startGameTimer(){
        progress = 1;
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {

                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    System.out.println(progress);
                    if(progress > 0){
                        progress-=0.003;
                    }
                    else{
                        progress = 0;
                    }
                    pbRoundTimer.setProgress(progress);
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

    private void setButtonCorrect(int i){
        btnAnswer1.setStyle("-fx-base: #ff3300;");
        btnAnswer2.setStyle("-fx-base: #ff3300;");
        btnAnswer3.setStyle("-fx-base: #ff3300;");
        btnAnswer4.setStyle("-fx-base: #ff3300;");
        switch(i){
            case 1:
                btnAnswer1.setStyle("-fx-base: #00cc00;");
                System.out.println("1 GROEN");
                break;
            case 2:
                btnAnswer2.setStyle("-fx-base: #00cc00;");
                System.out.println("2 GROEN");
                break;
            case 3:
                btnAnswer3.setStyle("-fx-base: #00cc00;");
                System.out.println("3 GROEN");
                break;
            case 4:
                btnAnswer4.setStyle("-fx-base: #00cc00;");
                System.out.println("4 GROEN");
                break;
            
        }
    }
    
    @FXML
    private void setAnswer(ActionEvent event){
        animationTimer.stop();
        Button B = (Button)event.getSource();
        
        if(B.getId().contains("1")){
            gameController.setCurrentAnswer(1);
        }
        else if(B.getId().contains("2")){
             gameController.setCurrentAnswer(2);
        }
        else if(B.getId().contains("3")){
            gameController.setCurrentAnswer(3);
        }
        else if(B.getId().contains("4")){
            gameController.setCurrentAnswer(4);
        }
        System.out.println(gameController.getCurrentAnswer());
        gameController.setGameState(Answered);
    }

}
