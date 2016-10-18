/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    /**
     * Test of setScore method, of class Player.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 100;
        Player instance = new Player("Test@test.nl","Test","Test",1,1,1);
        instance.setScore(score);
        assertEquals(score, instance.getScore());
    }

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Player instance = new Player("Test@test.nl","Test","Test",1,1,1);
        instance.setScore(100);
        int result = instance.getScore();
        assertEquals(100, result);
    }
    
}
