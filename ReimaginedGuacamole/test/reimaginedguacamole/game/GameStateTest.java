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
 * @author roy_v
 */
public class GameStateTest {
    
    public GameStateTest() {
    }

    /**
     * Test of values method, of class GameState.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        GameState expResult = GameState.WaitingForCategory;
        GameState result = GameState.values()[0];
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class GameState.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "Waiting";
        GameState expResult = GameState.Waiting;
        GameState result = GameState.valueOf(name);
        assertEquals(expResult, result);

    }
    
}
