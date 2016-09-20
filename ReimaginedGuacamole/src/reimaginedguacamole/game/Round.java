/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

/**
 *Class which contains the information about the current round
 * @author daan
 */
public class Round {
    private Question question;
    private int givenAnswer;
    
    public Round(Question question){
        this.question = question;
    }
    
    public void setGivenAnswer(int answer){
        this.givenAnswer = answer;
    }
    
    public int getGivenAnswer(){
        return givenAnswer;
    }
}
