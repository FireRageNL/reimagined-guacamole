/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of getQuestionsList method, of class Game.
     */
    @Test
    public void testGetQuestionsList() {
        System.out.println("getQuestionsList");
        Question question = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
         List<Question> lijst = new ArrayList<Question>();
         lijst.add(question);
        Game instance = new Game(5,10);
        instance.questionsList = lijst;
        Question expResult = question;
        Question result = instance.getQuestionsList().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoundDuration method, of class Game.
     */
    @Test
    public void testGetRoundDuration() {
        System.out.println("getRoundDuration");
        Game instance = new Game(5,10);
        int expResult = 10;
        int result = instance.getRoundDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoundDuration method, of class Game.
     */
    @Test
    public void testSetRoundDuration() {
        System.out.println("setRoundDuration");
        int roundDuration = 15;
        int expResult = roundDuration;
        Game instance = new Game(5,10);
        instance.setRoundDuration(roundDuration);
        int result = instance.getRoundDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfRounds method, of class Game.
     */
    @Test
    public void testGetAmountOfRounds() {
        System.out.println("getAmountOfRounds");
        Game instance = new Game(5,10);
        int expResult = 5;
        int result = instance.getAmountOfRounds();
        assertEquals(expResult, result);
    }
    
}
