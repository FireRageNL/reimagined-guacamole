/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gui;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
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
import reimaginedguacamole.game.GameState;
import static reimaginedguacamole.game.GameState.*;
import reimaginedguacamole.profile.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListCell;
import javafx.util.Callback;
import reimaginedguacamole.game.IGameController;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.tooling.Hashing;

/**
 *
 * @author daan
 */
public class FXMLController implements Initializable {

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
    @FXML
    private ListView lvGameRooms;
    @FXML
    private ListView lvPlayers;

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
    private Button btnStartGame;
    @FXML
    private ListView lvChat;
    @FXML
    private TextField txtChat;
    @FXML
    private Label lblGameName;
    @FXML
    private Label lblScore;
    
    
    @FXML
    private Label lblPlayer1;
    @FXML
    private Label lblPlayer2;
    @FXML
    private Label lblPlayer3;
    @FXML
    private Label lblPlayer4;
    
    @FXML
    private Label lblScore1;
    @FXML
    private Label lblScore2;
    @FXML
    private Label lblScore3;
    @FXML
    private Label lblScore4;

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
    private IGameController gameController;
    private IProfile user;
    private GameClient gameClient;
    private Random rng;
    private int roundDuration;
    private ObservableList<String> chatList;
    private ObservableList<String> lobbyChat;
    private ObservableList<IGameRoom> lobbyRooms;
    private ObservableList<String> players;
    private IGameServer gs;
    private IGameRoom joinedRoom;
    int wheelRotation = 0;
    double progress;
    private Client chatClient;
    private static final String BUTTON_STYLE = "-fx-base: #ff3300;";
    private static final String BUTTON_STYLE_CORRECT = "-fx-base: #00cc00;";
    int countPlayers;
    private int userIndex;
    private int currentAnswer = 0;
    private int currentCorrectAnswer;

    // TIMERS
    private Timer waitTimer;
    private AnimationTimer animationTimer;
    public static final int NANO_TICKS = 20000000;
    private final String IP = "192.168.1.116";

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
                Registry reg = LocateRegistry.getRegistry(IP, 666);
                gs = (IGameServer) reg.lookup("GameServer");
                //Tries to log in
                String password = Hashing.hashPassword(pass);
                boolean loggedin = gs.tryLogin(username, password);

                if (loggedin) {
                    //gets user date from database and sets the window to the profile page.
                    user = gs.getCurrentProfile(username);
                    gameClient.setProf(user);
                    chatClient = new Client(user, lobbyChat, this);
                    updateRoomList(gs.sendGameRoomData());
                    fillProfileData();
                    setWindows(2);
                } else {
                    errorlabel.setText("Gebruikersnaam/Wachtwoord fout");
                }
            } catch (RemoteException | NotBoundException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSpin.setDisable(true);
        btnStartGame.setDisable(true);
        try {
            gameClient = new GameClient(this);
        } catch (RemoteException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Set window to loginpage
        setWindows(1);
        //initializes the chatlist for later usage and sets the style.
        chatList = FXCollections.observableArrayList();
        lvChat.setFixedCellSize(20);
        lvChat.setItems(chatList);
        lvChat.getItems().addListener((ListChangeListener.Change c)
                -> lvChat.scrollTo(chatList.size() - 1));
        lobbyChat = FXCollections.observableArrayList();
        lvLobby.setFixedCellSize(20);
        lvLobby.setItems(lobbyChat);
        lvLobby.getItems().addListener((ListChangeListener.Change c)
                -> lvLobby.scrollTo(lobbyChat.size() - 1));
        lobbyRooms = FXCollections.observableArrayList();
        lvGameRooms.setFixedCellSize(50);
        lvGameRooms.setItems(lobbyRooms);
        lvGameRooms.setCellFactory(new Callback<ListView<IGameRoom>, ListCell<IGameRoom>>() {
            @Override
            public ListCell<IGameRoom> call(ListView<IGameRoom> param) {
                ListCell<IGameRoom> cell = new ListCell<IGameRoom>() {

                    @Override
                    protected void updateItem(IGameRoom gameRoom, boolean bln) {
                        super.updateItem(gameRoom, bln);
                        if (gameRoom != null) {
                            try {
                                setText(gameRoom.getGameRoomListing());
                            } catch (RemoteException ex) {
                                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                };
                return cell;
            }
        });
        lvGameRooms.getItems().addListener((ListChangeListener.Change c)
                -> lvGameRooms.scrollTo(0)
        );
        players = FXCollections.observableArrayList();
        lvPlayers.setFixedCellSize(20);
        lvPlayers.setItems(players);
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
                //DoNothing
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

    @FXML
    private void clickCreateGame(ActionEvent event) throws UnknownHostException, NotBoundException {
        GameRoomDialog gamedialog = new GameRoomDialog();
        Optional<List> result = gamedialog.getDialog().showAndWait();

        if (result.isPresent()) {
            List<String> res = result.get();
            try {
                String ip = InetAddress.getLocalHost().getHostAddress();
                joinGame(gs.createGameRoom(Integer.parseInt(res.get(0)), Integer.parseInt(res.get(1)), res.get(2), ip));
            } catch (RemoteException ex) {
                Logger.getLogger(GameRoomDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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
        
        pbRoundTimer.setProgress(0);
        
        btnStartGame.setDisable(true);
        gs.startGame(joinedRoom);
    }

    @FXML
    private void btnJoinGameClicked(ActionEvent event) {
        try {
            joinGame((IGameRoom) lvGameRooms.getSelectionModel().getSelectedItem());
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void joinGame(IGameRoom room) throws RemoteException, NotBoundException {
        gs.joinRoom(gameClient, room);
        chatClient.leaveChatroom();
        joinedRoom = room;
    }

    /**
     * Disables or enables the buttons based on given param
     *
     * @param state
     */
    public void disableButtons(boolean state) {
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
    public void checkGameState(GameState state) throws RemoteException {
        switch (state) {
            case WAITINGFORCATEGORY:
                gs.refreshUI(joinedRoom);
                resetQuestionUI();
                currentAnswer = 0;
                disableButtons(true);
                System.out.println("Het spel is aan het rennen yaaay");
                if(gs.getCurrentUser(joinedRoom) == userIndex){
                    btnSpin.setDisable(false);
                    System.out.println("ik mag draaien!");
                }
                
                break;
            case SPINNINGFINISHED:
                System.out.println("SPinning finished on client");
                pbRoundTimer.setProgress(-1);
                lblQuestion.setText("De Categorie is: " +gs.getCategory(joinedRoom));
                waitTimer = new Timer(true);
                waitTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                try {
                    gs.startRound(joinedRoom);
                } catch (RemoteException ex) {
                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    
                }, 3000);
                break;
                
            case GAMERUNNING:
                disableButtons(false);
                List<String> question = gs.getQuestion(joinedRoom);
                lblQuestion.setText(question.get(0));
                btnAnswer1.setText(question.get(1));
               btnAnswer2.setText(question.get(2));
                btnAnswer3.setText(question.get(3));
              btnAnswer4.setText(question.get(4));
              currentCorrectAnswer = Integer.parseInt(question.get(5));
              
              startGameTimer();
                break;
                
            case ANSWERED:
                System.out.println("All players answered so lets gooo");
                gs.checkAnswers(joinedRoom, userIndex, currentAnswer, pbRoundTimer.getProgress());
                break;
                
            case WAITINGFORPLAYERS:
                setButtonCorrect(currentCorrectAnswer);
                gs.refreshUI(joinedRoom);
                
        }
        
        
    }
//private void checkGameState() throws RemoteException {
//
//        IRound round;
//
//        switch (gameController.getGameState()) {
//            //Waiting is not used in this version yet. future version will wait for other players
//            case WAITING:
//                break;
//            case WAITINGFORCATEGORY:
//                //Game is now waiting for user to start spinning the wheel. if not done after 15 seconds it will start automically.
//                //Disables all necessary buttons and gives feedback to user.
//                lblGameName.setText(user.getNickname());
//                btnSpin.setDisable(false);
//                waitTimer = new Timer(true);
//                chatList.add("GAME: Ben je er Klaar voor? Spin het wiel!");
//                waitTimer.schedule(new WaitingForGameState(gameController, GameState.SPINNING), 15000);
//                setWindows(0);
//                break;
//            case SPINNING:
//                //this state will start spinning the wheel. also it resets the ui to an empty gamescreen 
//                waitTimer = null;
//                resetQuestionUI();
//                btnSpin.setDisable(true);
//                chatList.add("GAME: Welke categorie zul je krijgen?");
//                System.out.println("Start Spinning");
//                spinWheel();
//                waitTimer = new Timer(true);
//                int time = 5000 + rng.nextInt(3000);
//                System.out.println(time);
//                waitTimer.schedule(new WaitingForGameState(gameController, GameState.SPINNINGFINISHED), time);
//                break;
//            case SPINNINGFINISHED:
//                //Stops the spinning and starts the new round with a question from the chosen category
//                animationTimer.stop();
//                System.out.println("ANIMATION STOPPED!");
//                gameController.startNextRound();
//                gameController.giveRoundQuestion(gameController.chooseCategory(wheel.getRotate()));
//
//                //Sets the appriopriate round and shows a loading bar.
//                round = gameController.getCurrentRound();
//                pbRoundTimer.setProgress(-1);
//                lblQuestion.setText(round.getQuestion().getCategory().toString());
//                chatList.add("GAME: De categorie is " + round.getQuestion().getCategory() + "\n");
//
//                //Waits a few seconds before showing the question.
//                waitTimer = new Timer(true);
//                waitTimer.schedule(new WaitingForGameState(gameController, GameState.GAMERUNNING), 3500);
//                break;
//            case GAMERUNNING:
//                //Gamestate where question can be answered. starts the gametimer which is set to a specific time.
//                disableButtons(false);
//                round = gameController.getCurrentRound();
//                lblQuestion.setText(round.getQuestion().getQuestionContents());
//                btnAnswer1.setText(round.getQuestion().getAnswer1());
//                btnAnswer2.setText(round.getQuestion().getAnswer2());
//                btnAnswer3.setText(round.getQuestion().getAnswer3());
//                btnAnswer4.setText(round.getQuestion().getAnswer4());
//                startGameTimer();
//                break;
//
//            case ANSWERED:
//                //Gamestate where question has been answered or time has run out(answer will be 0).
//                //checks what the user did and gives correct feedback to user.
//                disableButtons(true);
//                int score = gameController.getCurrentScore();
//                if (gameController.checkAnswer(user, pbRoundTimer.getProgress())) {
//                    score = gameController.getCurrentScore() - score;
//                    chatList.add("GAME: Goed gedaan! je krijgt " + score + " punten!");
//                } else {
//                    chatList.add("GAME: Jammer!");
//                }
//                lblScore.setText(String.valueOf(gameController.getCurrentScore()));
//                setButtonCorrect(gameController.getCorrectAnswer());
//                waitTimer = new Timer(true);
//
//                //Checks if game is over and continuesaccording to this check
//                if (gameController.getCurrentRoundIndex() + 1 == gameController.getGame().getAmountOfRounds()) {
//                    waitTimer.schedule(new WaitingForGameState(gameController, GameState.GAMEFINISHED), 2500);
//                } else {
//                    waitTimer.schedule(new WaitingForGameState(gameController, GameState.WAITINGFORCATEGORY), 2500);
//                }
//                break;
//
//            case GAMEFINISHED:
//                //Game has ended. upload all information and show user game has ended.
//                gameController.endGame(user);
//                chatList.add("GAME:  De Game is afgelopen! \n Je score is " + gameController.getCurrentScore() + "! Goed Bezig!");
//                break;
//
//            case WAITINGFORPLAYERS:
//                chatList.add("GAME: Wachten op spelers");
//                btnStartGame.setDisable(false);
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            while (gameController.checkPlayers() != 4) {
//                                //Wait
//                            }
//                            gameController.setGameState(WAITINGFORCATEGORY);
//                            countPlayers = 0;
//                        } catch (RemoteException ex) {
//                            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//
//                }.run();
//
//                break;
//
//            default:
//                //do nothing
//                break;
//        }
//    }

    /**
     * Resets the game UI to the standard empty playing field so next round can
     * start.
     */
    private void resetQuestionUI() throws RemoteException {
        //lblScore.setText("aaaa");
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

    
    
    public void refreshUI(int[] scores, List<String> names){
        lblPlayer1.setText(names.get(0));
        lblScore1.setText(String.valueOf(scores[0]));
        lblPlayer2.setText(names.get(1));
        lblScore2.setText(String.valueOf(scores[1]));
        lblPlayer3.setText(names.get(2));
        lblScore3.setText(String.valueOf(scores[2]));
        lblPlayer4.setText(names.get(3));
        lblScore4.setText(String.valueOf(scores[3]));
        
        
    }
    
    
    /**
     * Sends a chat message
     */
    @FXML
    public void btnlobbyChatClicker() {
        try {
            if (!txtLobbyChat.getText().isEmpty()) {
                String msg = txtLobbyChat.getText();
                chatClient.sendMessage(msg);
                txtLobbyChat.clear();
            }
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
    public void btnSpinClicked() throws RemoteException {
            gs.spinWheel(joinedRoom);
    }

    /**
     * Starts an animation timer to spin the wheel.
     * @param wheelspeed
     */
    public void spinWheel(int rotation) {

        System.out.println("SPIN THE WHEEL ON JAT");
        //wheelspeed is random between 13 and 19 pixels per tick.
        //wheelSpeed = 13 + rng.nextInt(6);
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            int x = 0;
            
            @Override
            public void handle(long now) {

                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if (wheelRotation < 360) {
                        wheelRotation += 15;
                    } else {
                        //makes for smooth rotation
                        wheelRotation += 15;
                        wheelRotation = wheelRotation - 360;
                    }
                    wheel.setRotate(wheelRotation);
                    prevUpdate = now;
                    x++;
                    if(x == rotation){
                        try {
                            gs.stopSpin(joinedRoom, progress);
                        } catch (RemoteException ex) {
                            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.stop();
                    }
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
     *
     * @throws java.rmi.RemoteException
     */
    public void startGameTimer() throws RemoteException {
        progress = 1;
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    if (progress > 0) {
                        progress -= 0.003;
                    } else {
                        try {
                            //Timer has ended. gameround ends and current answer has to be wrong.
                            progress = 0;
                            animationTimer.stop();
                            currentAnswer = 0;
                            gs.playerAnswered(joinedRoom);
                            disableButtons(true);
                        } catch (RemoteException ex) {
                            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
    private void setAnswer(ActionEvent event) throws RemoteException {
        disableButtons(true);
        animationTimer.stop();
        Button b = (Button) event.getSource();

        if (b.getId().contains("1")) {
            currentAnswer = 1;
        } else if (b.getId().contains("2")) {
            currentAnswer = 2;
        } else if (b.getId().contains("3")) {
            currentAnswer = 3;
        } else if (b.getId().contains("4")) {
            currentAnswer = 4;
        }
        Logger.getLogger(FXMLController.class.getCanonicalName()).log(Level.INFO, "{0}", "asdf");
        gs.playerAnswered(joinedRoom);
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
    public void logOut() throws RemoteException {
        user = null;
        errorlabel.setText("");
        gameController = null;
        chatClient.leaveChatroom();
        setWindows(1);
    }

    public void updateRoomList(List<IGameRoom> gameRoomsData) {
        lobbyRooms.clear();
        lobbyRooms.addAll(gameRoomsData);
    }

    public void updatePlayerList(List<String> playerData) {
        players.clear();
        players.addAll(playerData);
    }

    public void disableStartButton(boolean state) {
        btnStartGame.setDisable(state);
    }

    public void disableSpinButton(boolean state) {
        btnSpin.setDisable(state);
    }
    
    public void setUserIndex(int i){
        userIndex = i;
        System.out.println("Ik ben player " + userIndex);
    }
    
    public void stopSpin() throws RemoteException{
        animationTimer.stop();
        gs.stopSpin(joinedRoom,wheel.getRotate());
    }
}
