/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
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
     * Test of getRoundDuration method, of class Game.
     */
    @Test
    public void testGetRoundDuration() throws RemoteException {
        System.out.println("getRoundDuration");
        Game instance = new Game();
        instance.setAmountOfRounds(10);
        int expResult = 10;
        int result = instance.getRoundDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoundDuration method, of class Game.
     */
    @Test
    public void testSetRoundDuration() throws RemoteException {
        System.out.println("setRoundDuration");
        int roundDuration = 15;
        int expResult = roundDuration;
        Game instance = new Game();
        instance.setRoundDuration(roundDuration);
        int result = instance.getRoundDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmountOfRounds method, of class Game.
     */
    @Test
    public void testGetAmountOfRounds() throws RemoteException {
        System.out.println("getAmountOfRounds");
        Game instance = new Game();
        int expResult = 5;
        int result = instance.getAmountOfRounds();
        assertEquals(expResult, result);
    }
    
}
