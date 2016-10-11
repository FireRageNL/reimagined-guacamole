/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.List;

/**
 *
 * @author daan
 */
public class GameController {
    
    private Game game;
    private List<Round> rounds;
    private int currentRoundIndex;
    private GameState gameState;
    private Round  currentRound;
    
    public GameController(Game game){
        this.game = game;
        currentRoundIndex = 0;
    }
    
    public void startNextRound(){
        currentRoundIndex++;
        currentRound = rounds.get(currentRoundIndex);
    }
    
    public Question giveRoundQuestion(Category category, List<Question> questions){
        
    }
    
    public GameState getGameState(){
        return gameState;
    }
    
    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
    
    public int getCorrectAnswer(){
        return currentRound.getQuestion().getCorrectAnswer();
    }
    
    public boolean checkAnswer(int answer){
        if(currentRound.getQuestion().getCorrectAnswer() == answer){
            return true;
        }
        else{
            return false;
        }
    }
   
}
