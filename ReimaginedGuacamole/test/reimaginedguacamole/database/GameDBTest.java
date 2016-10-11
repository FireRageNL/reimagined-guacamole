/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.Profile;

/**
 *
 * @author roy_v
 */
public class GameDBTest {
    
    public GameDBTest() {
    }

    /**
     * Test of updateStats method, of class GameDB.
     */
    @Test
    public void testUpdateStats() {
        System.out.println("updateStats");
        Profile prof = null;
        Category cat = null;
        boolean right = false;
        GameDB instance = new GameDB();
        instance.updateStats(prof, cat, right);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endGame method, of class GameDB.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        int userid = 2;
        int score = 1000;
        GameDB instance = new GameDB();
        instance.endGame(userid, score);
    }
    
}
