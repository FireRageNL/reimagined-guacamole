/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.List;
///import reimaginedguacamole.database.QuestionDB;

/**
 *Class that holds all important game information
 * @author daan
 */
public class Game {
    
    private int amountOfRounds;
    private int roundDuration;
    ///private QuestionDB QDB = new QuestionDB();
    List<Question> questionsList;
    
    public Game(int rounds, int duration){
        this.amountOfRounds = rounds;
        this.roundDuration = duration;
        //questionsList = QDB.getQuestions(rounds);
        
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public int getRoundDuration() {
        return roundDuration;
    }

    public void setRoundDuration(int roundDuration) {
        this.roundDuration = roundDuration;
    }

    public int getAmountOfRounds() {
        return amountOfRounds;
    }

}
