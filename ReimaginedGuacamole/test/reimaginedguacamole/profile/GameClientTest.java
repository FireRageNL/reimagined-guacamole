/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.GameState;

/**
 *
 * @author Jorrit
 */
public class GameClientTest {
    
    public GameClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProf method, of class GameClient.
     */
    @Test
    public void testGetProf() {
        System.out.println("getProf");
        GameClient instance = null;
        IProfile expResult = null;
        IProfile result = instance.getProf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProf method, of class GameClient.
     */
    @Test
    public void testSetProf() {
        System.out.println("setProf");
        IProfile prof = null;
        GameClient instance = null;
        instance.setProf(prof);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfile method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetProfile() throws Exception {
        System.out.println("getProfile");
        GameClient instance = null;
        IProfile expResult = null;
        IProfile result = instance.getProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of joinGame method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testJoinGame() throws Exception {
        System.out.println("joinGame");
        GameClient instance = null;
        instance.joinGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disableStartButton method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testDisableStartButton() throws Exception {
        System.out.println("disableStartButton");
        boolean state = false;
        GameClient instance = null;
        instance.disableStartButton(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disableButtons method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testDisableButtons() throws Exception {
        System.out.println("disableButtons");
        boolean state = false;
        GameClient instance = null;
        instance.disableButtons(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disableSpinButton method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testDisableSpinButton() throws Exception {
        System.out.println("disableSpinButton");
        boolean state = false;
        GameClient instance = null;
        instance.disableSpinButton(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGameState method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheckGameState() throws Exception {
        System.out.println("checkGameState");
        GameState gameState = null;
        GameClient instance = null;
        instance.checkGameState(gameState);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserIndex method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetUserIndex() throws Exception {
        System.out.println("setUserIndex");
        int i = 0;
        GameClient instance = null;
        instance.setUserIndex(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spinWheel method, of class GameClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testSpinWheel() throws Exception {
        System.out.println("spinWheel");
        int wheelspeed = 0;
        int time = 0;
        GameClient instance = null;
        instance.spinWheel(wheelspeed, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
