/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class GameControllerTest {
    
    public GameControllerTest() {
    }
    

    /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryHistory() {
        System.out.println("chooseCategory");
        double wheel = 10.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.History;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryGames() {
        System.out.println("chooseCategory");
        double wheel = 60.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.Games;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    
            /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryMusic() {
        System.out.println("chooseCategory");
        double wheel = 110.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.Music;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    
                /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryScience() {
        System.out.println("chooseCategory");
        double wheel = 170.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.Science;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryArt() {
        System.out.println("chooseCategory");
        double wheel = 220.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.Art;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    
         /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategorySport() {
        System.out.println("chooseCategory");
        double wheel = 320.0;
        GameController instance = new GameController(5,10);
        Category expResult = Category.Sport;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getCurrentRound method, of class GameController.
     */
    @Test
    public void testGetCurrentRound() {
        System.out.println("getCurrentRound");
        GameController instance = new GameController(5,10);
        Round expResult = null;
        Round result = instance.getCurrentRound();
        assertEquals(expResult, result);
    }

    /**
     * Test of giveRoundQuestion method, of class GameController.
     */
    @Test
    public void testGiveRoundQuestion() {
        System.out.println("giveRoundQuestion");
        Category category = Category.History;
        GameController instance = new GameController(5,10);
        instance.giveRoundQuestion(category);
    }

    /**
     * Test of getGame method, of class GameController.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        GameController instance = new GameController(5,10);
        int expResult = new Game(10,5).getAmountOfRounds();
        int result = instance.getGame().getAmountOfRounds();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameState method, of class GameController.
     */
    @Test
    public void testGetGameState() {
        System.out.println("getGameState");
        GameController instance = new GameController(5,10);
        instance.setGameState(GameState.GAMERUNNING);
        GameState expResult = GameState.GAMERUNNING;
        GameState result = instance.getGameState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGameState method, of class GameController.
     */
    @Test
    public void testSetGameState() {
        System.out.println("setGameState");
        GameState gameState = GameState.GAMERUNNING;
        GameController instance = new GameController(5,10);
        instance.setGameState(gameState);
    }

    /**
     * Test of getCurrentAnswer method, of class GameController.
     */
    @Test
    public void testGetCurrentAnswer() {
        System.out.println("getCurrentAnswer");
        GameController instance = new GameController(5,10);
        instance.setCurrentAnswer(1);
        int expResult = 1;
        int result = instance.getCurrentAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrentAnswer method, of class GameController.
     */
    @Test
    public void testSetCurrentAnswer() {
        System.out.println("setCurrentAnswer");
        int currentAnswer = 1;
        GameController instance = new GameController(5,10);
        instance.setCurrentAnswer(currentAnswer);
    }

    /**
     * Test of getCorrectAnswer method, of class GameController.
     */
    @Test
    public void testGetCorrectAnswer() {
        System.out.println("getCorrectAnswer");
        GameController instance = new GameController(5,10);
        instance.startNextRound();
        instance.giveRoundQuestion(Category.History);
        int expResult = instance.getCurrentRound().getQuestion().getCorrectAnswer();
        int result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentScore method, of class GameController.
     */
    @Test
    public void testGetCurrentScore() {
        System.out.println("getCurrentScore");
        GameController instance = new GameController(5,10);
        int expResult = 0;
        int result = instance.getCurrentScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentRoundIndex method, of class GameController.
     */
    @Test
    public void testGetCurrentRoundIndex() {
        System.out.println("getCurrentRoundIndex");
        GameController instance = new GameController(5,10);
        instance.startNextRound();
        int expResult = 0;
        int result = instance.getCurrentRoundIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAnswer method, of class GameController.
     */
    @Test
    public void testCheckAnswer() {
        System.out.println("checkAnswer");
        Profile profile = new Profile("IkHak@live.nl","Jorrit","HardcoreJorrit",46,0,0);     
        double timeTaken = 5.0;
        GameController instance = new GameController(5,10);
        boolean expResult = false;
        instance.startNextRound();
        instance.giveRoundQuestion(Category.History);
        instance.setCurrentAnswer(1);
        boolean result = instance.checkAnswer(profile, timeTaken);
        assertEquals(expResult, result);
    }
}
