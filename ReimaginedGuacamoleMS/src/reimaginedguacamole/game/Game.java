/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.profile.IProfile;
import reimaginedguacamolems.database.GameDB;
import reimaginedguacamolems.database.QuestionDB;

/**
 * Class that holds all important game information
 *
 * @author daan
 */
public class Game extends UnicastRemoteObject implements IGame {
    
    private int amountOfRounds;
    private int roundDuration;
    private QuestionDB QDB = new QuestionDB();
    private GameDB GDB = new GameDB();
    private List<IQuestion> questionsList;
    
    public Game(int rounds, int duration) throws RemoteException {
        this.amountOfRounds = rounds;
        this.roundDuration = duration;
        questionsList = QDB.getQuestions(rounds);
    }
    
    public Game() throws RemoteException {
    }
    
    @Override
    public List<IQuestion> getQuestionsList() {
        return questionsList;
    }
    
    @Override
    public int getRoundDuration() {
        return roundDuration;
    }
    
    @Override
    public void setRoundDuration(int roundDuration) {
        this.roundDuration = roundDuration;
        Logger.getLogger(Game.class.getName()).log(Level.INFO, "Round duration set as: " + roundDuration);
    }
    
    @Override
    public int getAmountOfRounds() {
        return amountOfRounds;
    }
    
    @Override
    public void setAmountOfRounds(int amount) throws RemoteException {
        this.amountOfRounds = amount;
        questionsList = QDB.getQuestions(amount);
        Logger.getLogger(Game.class.getName()).log(Level.INFO, "Amount of rounds set as: " + amount);
    }
    
    @Override
    public void updateStats(IProfile prof, Category cat, boolean right) throws RemoteException {
        GDB.updateStats(prof, cat, right);
    }
    
    @Override
    public void endGame(int userID, int score) throws RemoteException {
        GDB.endGame(userID, score);
        Logger.getLogger(Game.class.getCanonicalName()).log(Level.INFO,"Game for user "+ userID+" finished with a score of "+ score);
    }
    
}
