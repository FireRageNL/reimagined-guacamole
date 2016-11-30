/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.URL;
import java.rmi.NotBoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import reimaginedguacamole.game.GameController;
import reimaginedguacamole.game.GameState;
import static reimaginedguacamole.game.GameState.*;
import reimaginedguacamole.game.IRound;
import reimaginedguacamole.profile.*;
import reimaginedguacamole.timertasks.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.tooling.Hashing;

/**
 *
 * @author daan
 */
public class FXMLController implements Initializable, Observer {

    @FXML
    private Label errorlabel;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Pane loginPane;
    @FXML
    private Pane gamePane;

    //LOBBY OBJECTS
    @FXML
    private TextField txtLobbyChat;
    @FXML
    private ListView lvLobby;

    //PROFILE INFORMATION OBJECTS
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

    //Game Start Objects
    @FXML
    private Slider sliderAmountOfRounds;
    @FXML
    private Slider sliderTimePerRound;

    //GAME OBJECTS
    @FXML
    ProgressBar pbRoundTimer;
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
    private ListView lvChat;
    @FXML
    private TextField txtChat;
    @FXML
    private Label lblGameName;
    @FXML
    private Label lblScore;

    //RANKING PAGE OBEJCTS
    @FXML
    private TableView tableRank;
    @FXML
    private TableColumn colRank;
    @FXML
    private TableColumn colNick;
    @FXML
    private TableColumn colScore;

    //HISTORY PAGE OBJECTS
    @FXML
    private TableView tableHistory;
    @FXML
    private TableColumn colDate;
    @FXML
    private TableColumn colScores;

    //Global variables
    private GameController gameController;
    private IProfile user;
    private Random rng;
    private int wheelSpeed;
    private int roundDuration;
    private int amountOfRounds;
    private ObservableList<String> chatList;
    private ObservableList<String> lobbyChat;
    int wheelRotation = 0;
    double progress;
    private Client client;
    private static final String BUTTON_STYLE = "-fx-base: #ff3300;";
    private static final String BUTTON_STYLE_CORRECT = "-fx-base: #00cc00;";

    // TIMERS
    private Timer waitTimer;
    private AnimationTimer animationTimer;
    public static final int NANO_TICKS = 20000000;

    /**
     * checks usercredentials with database. Sends user to profile page when
     * succesull, else error message is displayed.
     */
    @FXML
    private void loginUser() {
        //Gets information from textfields
        String username = txtUsername.getText();
        String pass = txtPassword.getText();

        //Checks if textfields are not empty
        if (!pass.isEmpty() && !username.isEmpty()) {
            try {
                Registry reg = LocateRegistry.getRegistry("127.0.0.1", 666);
                ILogin log = (ILogin) reg.lookup("Login");
                //Tries to log in
                String password = Hashing.hashPassword(pass);
                boolean loggedin = log.tryLogin(username, password);

                if (loggedin) {
                    //gets user date from database and sets the window to the profile page.
                    user = log.getCurrentProfile(username);
                    client = new Client(user, lobbyChat);
                    fillProfileData();
                    setWindows(2);
                } else {
                    errorlabel.setText("Gebruikersnaam/Wachtwoord fout");
                }
            } catch (Exception ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Set window to loginpage
        setWindows(1);
        //initializes the chatlist for later usage and sets the style.
        chatList = FXCollections.observableArrayList();
        lvChat.setFixedCellSize(20);
        lvChat.setItems(chatList);
        lvChat.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                lvChat.scrollTo(chatList.size() - 1);

            }
        });
        lobbyChat = FXCollections.observableArrayList();
        lvLobby.setFixedCellSize(20);
        lvLobby.setItems(lobbyChat);
        lvLobby.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                lvLobby.scrollTo(lobbyChat.size() - 1);
            }
        });
        //creates the pseudorandom generation object
        rng = new Random();
    }

    /**
     * sets all windows to invisible and then sets the correct pane to visible.
     * 0 = gamepane 1 = loginpane 2 = profilepane
     *
     * @param index
     */
    public void setWindows(int index) {
        gamePane.setVisible(false);
        loginPane.setVisible(false);
        profilePane.setVisible(false);
        switch (index) {
            case 0:
                gamePane.setVisible(true);
                break;
            case 1:
                loginPane.setVisible(true);
                break;
            case 2:
                profilePane.setVisible(true);
                break;
            default:
                loginPane.setVisible(true);
                break;
        }
    }

    /**
     * Opens register dialog so user can register.
     *
     * @param event
     */
    @FXML
    private void clickRegister(MouseEvent event) throws RemoteException, NotBoundException {
        RegisterDialog regdialog = new RegisterDialog();
    }

    /**
     * sets the new nickname for the user and reloads the page so new
     * information is shown.
     *
     * @param event
     */
    @FXML
    private void changeNickName(ActionEvent event) throws RemoteException {
        user.setNickName(txtNickname.getText());
        fillProfileData();
    }

    /**
     * Refreshes all UI elements with the correct user information.
     */
    private void fillProfileData() throws RemoteException {
        // Sets all textboxes and labels.
        txtNickname.setText(user.getNickname());
        lblEmail.setText(user.getEmail());
        lblWins.setText(Integer.toString(user.getWins()));
        lblLoss.setText(Integer.toString(user.getLosses()));

        //Sets the labels with the amount of correct and wrong answers based on statistic
        for (IStatistic s : user.getStatistics()) {
            switch (s.getCategory()) {
                case HISTORY:
                    lblWinHis.setText(Integer.toString(s.getRight()));
                    lblLossHis.setText(Integer.toString(s.getWrong()));
                    break;
                case ART:
                    lblWinArt.setText(Integer.toString(s.getRight()));
                    lblLossArt.setText(Integer.toString(s.getWrong()));
                    break;
                case MUSIC:
                    lblWinMus.setText(Integer.toString(s.getRight()));
                    lblLossMus.setText(Integer.toString(s.getWrong()));
                    break;
                case ENTERTAINMENT:
                    lblWinEnt.setText(Integer.toString(s.getRight()));
                    lblLossEnt.setText(Integer.toString(s.getWrong()));
                    break;
                case GAMES:
                    lblWinGame.setText(Integer.toString(s.getRight()));
                    lblLossGame.setText(Integer.toString(s.getWrong()));
                    break;
                case SPORT:
                    lblWinSpr.setText(Integer.toString(s.getRight()));
                    lblLossSpr.setText(Integer.toString(s.getWrong()));
                    break;
                case SCIENCE:
                    lblWinSci.setText(Integer.toString(s.getRight()));
                    lblLossSci.setText(Integer.toString(s.getWrong()));
                    break;
                default:
                    //Do nothing
                    break;

            }
        }

        //Sets the rankings retrieved from the database
        ArrayList<IRanking> ranks = (ArrayList) user.getRankings();
        colRank.setCellValueFactory(
                new PropertyValueFactory<>("Rank"));
        colScore.setCellValueFactory(
                new PropertyValueFactory<>("Score"));
        colNick.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
        tableRank.setItems(FXCollections.observableArrayList(ranks));

        //Sets the listview for the history with the games user has played.
        ArrayList<IHistory> history = (ArrayList) user.getHistory();
        colDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colScores.setCellValueFactory(new PropertyValueFactory<>("Score"));
        tableHistory.setItems(FXCollections.observableArrayList(history));
    }

    /**
     * Starts a new game with the set parameters. duration being time per
     * question, and amount of rounds being the amount of questions being
     * played. it resets the game UI. and disables the buttons so user cant
     * answer an empty field. Also sets this controller as an observer for the
     * GameController Object.
     */
    @FXML
    private void startGame() throws RemoteException, NotBoundException {
        roundDuration = 10;
        amountOfRounds = 5;
        gameController = new GameController(roundDuration, amountOfRounds);
        resetQuestionUI();
        pbRoundTimer.setProgress(0);
        chatList.clear();
        disableButtons(true);
        gameController.addObserver(this);
        gameController.setGameState(GameState.WAITINGFORCATEGORY);
    }

    /**
     * Disables or enables the buttons based on given param
     *
     * @param state
     */
    private void disableButtons(boolean state) {
        btnAnswer1.setDisable(state);
        btnAnswer2.setDisable(state);
        btnAnswer3.setDisable(state);
        btnAnswer4.setDisable(state);
    }

    /**
     * Our main Game Controller. it fires everytime the gamestate in
     * gamecontroller is changed. It fires all necessary gamecontroller methods
     * and shows the correct information on the UI.
     */
    private void checkGameState() throws RemoteException {

        IRound round;

        switch (gameController.getGameState()) {
            //Waiting is not used in this version yet. future version will wait for other players
            case WAITING:
                break;
            case WAITINGFORCATEGORY:
                //Game is now waiting for user to start spinning the wheel. if not done after 15 seconds it will start automically.
                //Disables all necessary buttons and gives feedback to user.
                lblGameName.setText(user.getNickname());
                btnSpin.setDisable(false);
                waitTimer = new Timer(true);
                chatList.add("GAME: Ben je er Klaar voor? Spin het wiel!");
                waitTimer.schedule(new WaitingForGameState(gameController, GameState.SPINNING), 15000);
                setWindows(0);
                break;
            case SPINNING:
                //this state will start spinning the wheel. also it resets the ui to an empty gamescreen 
                waitTimer = null;
                resetQuestionUI();
                btnSpin.setDisable(true);
                chatList.add("GAME: Welke categorie zul je krijgen?");
                System.out.println("Start Spinning");
                spinWheel();
                waitTimer = new Timer(true);
                int time = 5000 + rng.nextInt(3000);
                System.out.println(time);
                waitTimer.schedule(new WaitingForGameState(gameController, GameState.SPINNINGFINISHED), time);
                break;
            case SPINNINGFINISHED:
                //Stops the spinning and starts the new round with a question from the chosen category
                animationTimer.stop();
                System.out.println("ANIMATION STOPPED!");
                gameController.startNextRound();
                gameController.giveRoundQuestion(gameController.chooseCategory(wheel.getRotate()));

                //Sets the appriopriate round and shows a loading bar.
                round = gameController.getCurrentRound();
                pbRoundTimer.setProgress(-1);
                lblQuestion.setText(round.getQuestion().getCategory().toString());
                chatList.add("GAME: De categorie is " + round.getQuestion().getCategory() + "\n");

                //Waits a few seconds before showing the question.
                waitTimer = new Timer(true);
                waitTimer.schedule(new WaitingForGameState(gameController, GameState.GAMERUNNING), 3500);
                break;
            case GAMERUNNING:
                //Gamestate where question can be answered. starts the gametimer which is set to a specific time.
                disableButtons(false);
                round = gameController.getCurrentRound();
                lblQuestion.setText(round.getQuestion().getQuestionContents());
                btnAnswer1.setText(round.getQuestion().getAnswer1());
                btnAnswer2.setText(round.getQuestion().getAnswer2());
                btnAnswer3.setText(round.getQuestion().getAnswer3());
                btnAnswer4.setText(round.getQuestion().getAnswer4());
                startGameTimer();
                break;

            case ANSWERED:
                //Gamestate where question has been answered or time has run out(answer will be 0).
                //checks what the user did and gives correct feedback to user.
                disableButtons(true);
                int score = gameController.getCurrentScore();
                if (gameController.checkAnswer(user, pbRoundTimer.getProgress())) {
                    score = gameController.getCurrentScore() - score;
                    chatList.add("GAME: Goed gedaan! je krijgt " + score + " punten!");
                } else {
                    chatList.add("GAME: Jammer!");
                }
                lblScore.setText(String.valueOf(gameController.getCurrentScore()));
                setButtonCorrect(gameController.getCorrectAnswer());
                waitTimer = new Timer(true);

                //Checks if game is over and continuesaccording to this check
                if (gameController.getCurrentRoundIndex() + 1 == gameController.getGame().getAmountOfRounds()) {
                    waitTimer.schedule(new WaitingForGameState(gameController, GameState.GAMEFINISHED), 2500);
                } else {
                    waitTimer.schedule(new WaitingForGameState(gameController, GameState.WAITINGFORCATEGORY), 2500);
                }
                break;

            case GAMEFINISHED:
                //Game has ended. upload all information and show user game has ended.
                gameController.endGame(user);
                chatList.add("GAME:  De Game is afgelopen! \n Je score is " + gameController.getCurrentScore() + "! Goed Bezig!");
                break;
            default:
                //do nothing
                break;
        }
    }

    /**
     * Resets the game UI to the standard empty playing field so next round can
     * start.
     */
    private void resetQuestionUI() {
        lblScore.setText(String.valueOf(gameController.getCurrentScore()));
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

    /**
     * Fires when the gamecontroller object uses method setGameState.
     *
     * @param o gameController
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        try {
            checkGameState();
        } catch (RemoteException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void btnlobbyChatClicker() {
        try {
            String msg = txtLobbyChat.getText();
            client.sendMessage(msg);
        } catch (RemoteException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Adds text user typed to the chatlistview
     */
    @FXML
    public void btnChatClicked() throws RemoteException {
        String chatLine = txtChat.getText();
        chatList.add(user.getNickname() + ": " + chatLine);
        txtChat.setText("");
    }

    /**
     * fires when the button Spin is clicked. cancels the wait timer and starts
     * the spinning gamestate.
     */
    @FXML
    public void btnSpinClicked() {
        waitTimer.cancel();
        gameController.setGameState(SPINNING);
    }

    /**
     * Starts an animation timer to spin the wheel.
     */
    public void spinWheel() {
        //wheelspeed is random between 13 and 19 pixels per tick.
        wheelSpeed = 13 + rng.nextInt(6);
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {

                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if (wheelRotation < 360) {
                        wheelRotation += wheelSpeed;
                    } else {
                        //makes for smooth rotation
                        wheelRotation += wheelSpeed;
                        wheelRotation = wheelRotation - 360;
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

    /**
     * Starts the game timer
     */
    public void startGameTimer() {
        progress = 1;
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if (progress > 0) {
                        progress -= 0.003 / (roundDuration / 10);
                    } else {
                        //Timer has ended. gameround ends and current answer has to be wrong.
                        progress = 0;
                        animationTimer.stop();
                        gameController.setCurrentAnswer(0);
                        gameController.setGameState(ANSWERED);
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

    /**
     * Sets the button which represents the correct answer to green. Rest is set
     * to red.
     *
     * @param buttonIndex index of button which corresponds with correct answer
     */
    private void setButtonCorrect(int buttonIndex) {
        btnAnswer1.setStyle(BUTTON_STYLE);
        btnAnswer2.setStyle(BUTTON_STYLE);
        btnAnswer3.setStyle(BUTTON_STYLE);
        btnAnswer4.setStyle(BUTTON_STYLE);
        switch (buttonIndex) {
            case 1:
                btnAnswer1.setStyle(BUTTON_STYLE_CORRECT);
                break;
            case 2:
                btnAnswer2.setStyle(BUTTON_STYLE_CORRECT);
                break;
            case 3:
                btnAnswer3.setStyle(BUTTON_STYLE_CORRECT);
                break;
            case 4:
                btnAnswer4.setStyle(BUTTON_STYLE_CORRECT);
                break;
            default:
                //do nothing
                break;

        }
    }

    /**
     * Sets the answer based on the button clicked.
     *
     * @param event
     */
    @FXML
    private void setAnswer(ActionEvent event) {
        animationTimer.stop();
        Button B = (Button) event.getSource();

        if (B.getId().contains("1")) {
            gameController.setCurrentAnswer(1);
        } else if (B.getId().contains("2")) {
            gameController.setCurrentAnswer(2);
        } else if (B.getId().contains("3")) {
            gameController.setCurrentAnswer(3);
        } else if (B.getId().contains("4")) {
            gameController.setCurrentAnswer(4);
        }
        Logger.getLogger(FXMLController.class.getCanonicalName()).log(Level.INFO, "{0}", gameController.getCurrentAnswer());
        gameController.setGameState(ANSWERED);
    }

    /**
     * Quit game. reset all timers and controllers to null. reset windows to
     * Profile page
     */
    @FXML
    public void quitGame() throws RemoteException {
        fillProfileData();
        if (animationTimer != null) {
            animationTimer.stop();
        }
        if (waitTimer != null) {
            waitTimer.cancel();
        }
        gameController = null;
        setWindows(2);
    }

    /**
     * logs user out and sets windows back to loginpage
     */
    @FXML
    public void logOut() {
        user = null;
        errorlabel.setText("");
        gameController = null;
        setWindows(1);
    }
}
