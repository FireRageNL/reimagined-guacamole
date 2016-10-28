/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import reimaginedguacamole.database.GameDB;
import reimaginedguacamole.profile.Profile;

/**
 *This class handles all game mechanics
 * It is an observable class with the FXMLController as its observer.
 * @author daan
 */
public class GameController extends Observable{
    
    private Game game;
    private List<Round> rounds;
    private int currentRoundIndex;
    private GameState gameState;
    private Round  currentRound;
    private int currentAnswer;
    private int currentScore;
    
    public GameController(int duration, int amountOfRounds){
        game = new Game(amountOfRounds, duration);
        rounds = new ArrayList<>();
        for(int i =0; i < amountOfRounds; i++){
            rounds.add(new Round());
        }
        currentRoundIndex = -1;
        currentScore = 0;
    }
    
    /**
     * Starts the next round and sets currentRound to the new Round object
     */
    public void startNextRound(){
        currentRoundIndex++;
        currentRound = rounds.get(currentRoundIndex);
        
    }
    
    /**
     * Ends the game and uploads the game information to the database
     * @param user Logged in profile
     */
    public void endGame(Profile user){
        GameDB gdb = new GameDB();
        gdb.endGame(user.getPid(), currentScore);
    }

    
    /**
     * Chooses a category based on the rotation of the wheel.
     * categories are divided in 7 equal parts.
     * @param wheel rotation of the wheel at this time
     * @return Category enum type
     */
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
    
    /**
     * Inserts a question into the round object based on the chosen category 
     * then removes this question from the orgiinal list.
     * @param category 
     */
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
    
    /**
     * Sets the gamestate and notifies the Observer so the game can update.
     * @param gameState 
     */
    public void setGameState(GameState gameState){
        this.gameState = gameState;
        this.setChanged();
        this.notifyObservers(gameState);
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }
    
    public int getCorrectAnswer(){
        return currentRound.getQuestion().getCorrectAnswer();
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getCurrentRoundIndex() {
        return currentRoundIndex;
    }
    
    
    /**
     * Checks the answer given and adds the score based on time.
     * @param profile
     * @param timeLeft
     * @return 
     */
    public boolean checkAnswer(Profile profile, double timeLeft){
        GameDB gdb = new GameDB();
        //Score is based on time, min score = 150
        System.out.println("TIMELEFT:" + timeLeft);
        int score = 50 + (100 + (int)(timeLeft * 100));
        //Checks if the correct answer is the same as givenanswer
        if(currentRound.getQuestion().getCorrectAnswer() == this.currentAnswer){
            currentScore += score;
            //Update the stats for this category and user with a +1 to the correct field.
            gdb.updateStats(profile, currentRound.getQuestion().getCategory(), true);
            return true;
        }
        else{
            //Update the stats for this category and user with a +1 to the Wrong field.
            gdb.updateStats(profile, currentRound.getQuestion().getCategory(), false);
            return false;
        }
        
    }
    
    
   
}
