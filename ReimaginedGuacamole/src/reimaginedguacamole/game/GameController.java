/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.gameserver.GameServer;
import reimaginedguacamole.networking.IMasterServer;
import reimaginedguacamole.profile.IProfile;

/**
 * This class handles all game mechanics It is an observable class with the
 * FXMLController as its observer.
 *
 * @author daan
 */
public class GameController extends UnicastRemoteObject implements IGameController {

    private IGame game;
    private List<IRound> rounds;
    private int currentRoundIndex;
    private GameState gameState;
    private IRound currentRound;
    private int currentAnswer;
    private int currentScore;
    private int countPlayers;
    private GameServer gs;
    private GameRoom gr;
    private int currentUser;


    /**
     * Constructor that gets called when a new game gets created
     * @param duration The amount of seconds a person has to anwser a question
     * @param amountOfRounds the amount of rounds in the game
     * @param gs the gameserver that initialized this gamecontroller
     * @param gr the gameroom this gamecontroller is part of
     * @param ms the masterserver
     * @throws RemoteException
     * @throws NotBoundException 
     */
    public GameController(int amountOfRounds, int duration, GameServer gs, GameRoom gr,IMasterServer ms) throws RemoteException, NotBoundException {
        game = new Game(ms);
        game.setAmountOfRounds(amountOfRounds);
        game.setRoundDuration(duration);
        rounds = new ArrayList<>();
        IRound temp = new Round();
        for (int i = 0; i < amountOfRounds; i++) {
            rounds.add(temp.createRound());
        }
        currentRoundIndex = -1;
        currentUser = -1;
        currentScore = 0;
        this.gameState = GameState.WAITINGFORPLAYERS;
        this.gs = gs;
        this.gr = gr;
    }
    
    public GameController() throws RemoteException {
        //Empty constcurtor to overwrihte default constructor
    }


    @Override
    public void startNextRound() {
        currentRoundIndex++;
        currentUser++;
        if(currentUser == 4){
            currentUser=0;
        }
        currentRound = rounds.get(currentRoundIndex);

    }


    @Override
    public void endGame(IProfile user) throws RemoteException {

        game.endGame(user.getPid(), currentScore);
    }

    @Override
    public int getCurrentUser() throws RemoteException{
        return currentUser;
    }
    

    @Override
    public Category chooseCategory(double wheel) {
        double rotation = 360 - wheel;
        if (rotation >= 0 && rotation <= 51) {
            return Category.SPORT;
        } else if (rotation > 51 && rotation <= 103) {
            return Category.ENTERTAINMENT;
        } else if (rotation > 103 && rotation <= 155) {
            return Category.ART;
        } else if (rotation > 155 && rotation <= 207) {
            return Category.SCIENCE;
        } else if (rotation > 207 && rotation <= 259) {
            return Category.MUSIC;
        } else if (rotation > 259 && rotation <= 311) {
            return Category.GAMES;
        } else {
            return Category.HISTORY;
        }
    }

    @Override
    public IRound getCurrentRound() {
        return currentRound;
    }


    @Override
    public void giveRoundQuestion(Category category) throws RemoteException {
        for (IQuestion q : game.getQuestionsList()) {
            if (q.getCategory() == category) {
                currentRound.setQuestion(q);
                game.getQuestionsList().remove(q);
                break;
            }
        }
    }


    @Override
    public IGame getGame() {
        return game;
    }


    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void setGameState(GameState gameState) throws RemoteException {
        this.gameState = gameState;
        gs.broadcastGameState(gameState, gr);
    }

    @Override
    public int getCurrentAnswer() {
        return currentAnswer;
    }

    @Override
    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    @Override
    public int getCorrectAnswer() throws RemoteException {
        return currentRound.getQuestion().getCorrectAnswer();
    }

    @Override
    public int getCurrentScore() {
        return currentScore;
    }

    @Override
    public int getCurrentRoundIndex() {
        return currentRoundIndex;
    }
    
    @Override
    public int checkPlayers(){
    return countPlayers;
    }
    
  
    @Override
    public void addPlayersCount() throws RemoteException{
        countPlayers++;
    }


    @Override
    public boolean checkAnswer(IProfile profile, double timeLeft) throws RemoteException {
        //Score is based on time, min score = 150
        Logger.getLogger(GameController.class.getCanonicalName()).log(Level.INFO, "TIMELEFT:{0}", timeLeft);
        int score = 50 + (100 + (int) (timeLeft * 100));
        //Checks if the correct answer is the same as givenanswer
        if (currentRound.getQuestion().getCorrectAnswer() == this.currentAnswer) {
            currentScore += score;
            //Update the stats for this category and user with a +1 to the correct field.
            //game.updateStats(profile, currentRound.getQuestion().getCategory(), true);
            return true;
        } else {
            //Update the stats for this category and user with a +1 to the Wrong field.
            //game.updateStats(profile, currentRound.getQuestion().getCategory(), false);
            return false;
        }

    }

    @Override
    public void removePlayersCount() throws RemoteException {
        countPlayers--;
    }

}
