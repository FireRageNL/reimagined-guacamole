/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.Timer;

/**
 *Class that handles all game activity
 * @author daan
 */
public class Game {
    
    private int amountOfRounds;
    private int roundDuration;
    
    public Game(int rounds, int duration){
        this.amountOfRounds = rounds;
        this.roundDuration = duration;
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
    
    
    /**
     * starts the game
     */
    public void startGame(){

    }
    
    public void startRound(Round round){
        
    }
    /**
     * updates the player's score based on parameter score
     * @param score 
     */
    public void updateScore(int score){
        
    }
    
    /**
     * Applies a powerup to the game.
     * @param powerup 
     */
    public void applyPowerup(PowerUp powerup){
        
    }
}
