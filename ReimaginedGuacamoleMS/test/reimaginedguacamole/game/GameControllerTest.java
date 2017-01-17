/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.gameserver.GameServer;


/**
 *
 * @author Jorrit
 */
public class GameControllerTest {
    
    GameServer gs;
    GameRoom gm;
    
    public GameControllerTest() {
    }
    
    @Before
    public void setUp() throws RemoteException, NotBoundException, UnknownHostException {
        gs = new GameServer();
        gm = new GameRoom(5,10,"room","127.0.0.1",gs);
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of startNextRound method, of class GameController.
     * @throws java.rmi.RemoteException
     * @throws java.net.UnknownHostException
     * @throws java.rmi.NotBoundException
     */
    @Test
    public void testStartNextRound() throws RemoteException, NotBoundException {
        System.out.println("startNextRound");
        GameController instance = new GameController(5,10,gs,gm);
        instance.startNextRound();
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
        /**
     * Test of endGame method, of class GameController.
     */
    @Test
    public void testEndGame() throws RemoteException, NotBoundException {
        System.out.println("endGame");
        Profile user = new Profile("test@email.com","test","Testie",2,10,20);
        GameController instance = new GameController(5,10,gs,gm);
        instance.endGame(user);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
    /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryHistory() throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 10.0;
        GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.HISTORY;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
        /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryGames() throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 60.0;
         GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.GAMES;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
            /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryMusic() throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 110.0;
        GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.MUSIC;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
                /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryScience() throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 170.0;
        GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.SCIENCE;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
     /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategoryArt() throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 220.0;
         GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.ART;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
         /**
     * Test of chooseCategory method, of class GameController.
     */
    @Test
    public void testChooseCategorySport()throws RemoteException, NotBoundException {
        System.out.println("chooseCategory");
        double wheel = 320.0;
        GameController instance = new GameController(5,10,gs,gm);
        Category expResult = Category.SPORT;
        Category result = instance.chooseCategory(wheel);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    

    /**
     * Test of getCurrentRound method, of class GameController.
     */
    @Test
    public void testGetCurrentRound() throws RemoteException, NotBoundException {
        System.out.println("getCurrentRound");
         GameController instance = new GameController(5,10,gs,gm);
        Round expResult = null;
        Round result = (Round) instance.getCurrentRound();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of giveRoundQuestion method, of class GameController.
     */
    @Test
    public void testGiveRoundQuestion() throws RemoteException, NotBoundException{
        System.out.println("giveRoundQuestion");
        Category category = Category.HISTORY;
        GameController instance = new GameController(5,10,gs,gm);
        instance.giveRoundQuestion(category);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getGame method, of class GameController.
     */
    @Test
    public void testGetGame() throws RemoteException, NotBoundException{
        System.out.println("getGame");
         GameController instance = new GameController(5,10,gs,gm);
        int expResult = 5;
        int result = instance.getGame().getAmountOfRounds();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getGameState method, of class GameController.
     */
    @Test
    public void testGetGameState() throws RemoteException, NotBoundException{
        System.out.println("getGameState");
        GameController instance = new GameController(5,10,gs,gm);
        instance.setGameState(GameState.GAMERUNNING);
        GameState expResult = GameState.GAMERUNNING;
        GameState result = instance.getGameState();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of setGameState method, of class GameController.
     */
    @Test
    public void testSetGameState() throws RemoteException, NotBoundException{
        System.out.println("setGameState");
        GameState gameState = GameState.GAMERUNNING;
         GameController instance = new GameController(5,10,gs,gm);
        instance.setGameState(gameState);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getCurrentAnswer method, of class GameController.
     */
    @Test
    public void testGetCurrentAnswer() throws RemoteException, NotBoundException{
        System.out.println("getCurrentAnswer");
         GameController instance = new GameController(5,10,gs,gm);
        instance.setCurrentAnswer(1);
        int expResult = 1;
        int result = instance.getCurrentAnswer();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of setCurrentAnswer method, of class GameController.
     */
    @Test
    public void testSetCurrentAnswer()throws RemoteException, NotBoundException {
        System.out.println("setCurrentAnswer");
        int currentAnswer = 1;
         GameController instance = new GameController(5,10,gs,gm);
        instance.setCurrentAnswer(currentAnswer);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getCorrectAnswer method, of class GameController.
     */
    @Test
    public void testGetCorrectAnswer() throws RemoteException, NotBoundException{
        System.out.println("getCorrectAnswer");
         GameController instance = new GameController(5,10,gs,gm);
        instance.startNextRound();
        instance.giveRoundQuestion(Category.HISTORY);
        int expResult = instance.getCurrentRound().getQuestion().getCorrectAnswer();
        int result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getCurrentScore method, of class GameController.
     */
    @Test
    public void testGetCurrentScore()throws RemoteException, NotBoundException {
        System.out.println("getCurrentScore");
         GameController instance = new GameController(5,10,gs,gm);
        int expResult = 0;
        int result = instance.getCurrentScore();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getCurrentRoundIndex method, of class GameController.
     */
    @Test
    public void testGetCurrentRoundIndex()throws RemoteException, NotBoundException {
        System.out.println("getCurrentRoundIndex");
        GameController instance = new GameController(5,10,gs,gm);
        instance.startNextRound();
        int expResult = 0;
        int result = instance.getCurrentRoundIndex();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of checkAnswer method, of class GameController.
     */
    @Test
    public void testCheckAnswer() throws RemoteException, NotBoundException{
        System.out.println("checkAnswer");
        Profile profile = new Profile("IkHak@live.nl","Jorrit","HardcoreJorrit",46,0,0);     
        double timeTaken = 5.0;
        GameController instance = new GameController(5,10,gs,gm);
        boolean expResult = false;
        instance.startNextRound();
        instance.giveRoundQuestion(Category.HISTORY);
        instance.setCurrentAnswer(1);
        boolean result = instance.checkAnswer(profile, timeTaken);
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    

    


    
}
