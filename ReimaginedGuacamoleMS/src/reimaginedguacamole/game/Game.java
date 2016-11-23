/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
///import reimaginedguacamole.database.QuestionDB;

/**
 *Class that holds all important game information
 * @author daan
 */
public class Game extends UnicastRemoteObject implements IGame{
    
    private int amountOfRounds;
    private int roundDuration;
    ///private QuestionDB QDB = new QuestionDB();
    private List<Question> questionsList;
    
    public Game(int rounds, int duration)throws RemoteException {
        this.amountOfRounds = rounds;
        this.roundDuration = duration;
        //questionsList = QDB.getQuestions(rounds);
    }

    @Override
    public List<Question> getQuestionsList() {
        return questionsList;
    }

    @Override
    public int getRoundDuration() {
        return roundDuration;
    }

    @Override
    public void setRoundDuration(int roundDuration) {
        this.roundDuration = roundDuration;
    }

    @Override
    public int getAmountOfRounds() {
        return amountOfRounds;
    }

}
