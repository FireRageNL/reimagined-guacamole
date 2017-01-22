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
import reimaginedguacamole.networking.IMasterServer;
import reimaginedguacamole.profile.IProfile;

/**
 * Class that holds all important game information
 *
 * @author daan
 */
public class Game extends UnicastRemoteObject implements IGame {
    
    private int amountOfRounds;
    private int roundDuration;
    private IMasterServer ms;
    private List<IQuestion> questionsList;

    /**
     * Default public constructor to create a empty game
     * @throws RemoteException 
     */
    public Game() throws RemoteException {
        //Default constructor
    }
    
    /**
     * Constructor for a Game
     * @param ms the masterserver
     * @throws RemoteException 
     */
    public Game(IMasterServer ms) throws RemoteException{
        this.ms = ms;
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
        Logger.getLogger(Game.class.getName()).log(Level.INFO, "Round duration set as: {0}", roundDuration);
    }
    
    @Override
    public int getAmountOfRounds() {
        return amountOfRounds;
    }
    
    @Override
    public void setAmountOfRounds(int amount) throws RemoteException {
        this.amountOfRounds = amount;
        questionsList = ms.getQuestions(amount);
        Logger.getLogger(Game.class.getName()).log(Level.INFO, "Amount of rounds set as: {0}", amount);
    }
    
    @Override
    public void updateStats(IProfile prof) throws RemoteException {
        ms.updateStats(prof);
    }
    
    @Override
    public void endGame(int userID, int score) throws RemoteException {
        Logger.getLogger(Game.class.getCanonicalName()).log(Level.INFO, "Game for user {0} finished with a score of {1}", new Object[]{userID, score});
    }
    
}
