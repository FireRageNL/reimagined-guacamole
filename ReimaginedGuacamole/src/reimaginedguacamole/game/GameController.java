/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author daan
 */
public class GameController extends Observable{
    
    private Game game;
    private List<Round> rounds;
    private int currentRoundIndex;
    private GameState gameState;
    private Round  currentRound;
    
    public GameController(int duration, int amountOfRounds){
        game = new Game(amountOfRounds, duration);
        rounds = new ArrayList<>();
        for(int i =0; i < amountOfRounds; i++){
            rounds.add(new Round());
        }
        currentRoundIndex = -1;
    }
    
    public void startNextRound(){
        currentRoundIndex++;
        currentRound = rounds.get(currentRoundIndex);
        
    }

    public Category chooseCategory(double wheel){
        double rotation = 360 - wheel;
        if(rotation >= 0 && rotation <= 51){return Category.Sport;}
        else if(rotation > 51 && rotation <= 103){return Category.Entertainment;}
        else if(rotation > 103 && rotation <= 155){return Category.Art;}
        else if(rotation > 155 && rotation <= 207){return Category.Science;}
        else if(rotation > 207 && rotation <= 259){return Category.Music;}
        else if(rotation > 259 && rotation <= 311){return Category.Games;}
        else{return Category.History;}        
    }
    
    
    public Round getCurrentRound() {
        return currentRound;
    }
    
    public void giveRoundQuestion(Category category){
        for(Question q : game.getQuestionsList()){
            if(q.getCategory() == category){
                currentRound.setQuestion(q);
                game.getQuestionsList().remove(q);
                break;
            }
        }
        
    }
    
    public Game getGame(){
        return game;
    }
    
    public GameState getGameState(){
        return gameState;
    }
    
    public void setGameState(GameState gameState){
        this.gameState = gameState;
        this.setChanged();
        this.notifyObservers(gameState);
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
