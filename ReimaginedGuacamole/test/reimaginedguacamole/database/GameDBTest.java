/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.profile.Statistic;

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
        Profile prof;
        Category cat = Category.Art;
        boolean right = false;
        GameDB instance = new GameDB();
        ProfileDB test = new ProfileDB();
        prof = test.getProfileData("test@test.test");
        int expResult = 0;
        List<Statistic> stats = prof.getStatistics();
        for(Statistic s : stats){
            if(s.getCategory() == Category.Art){
                expResult = s.getWrong() + 1;
            }
        }
        int result = 0;
        instance.updateStats(prof, cat, right);
        List<Statistic> updatedStats = test.getStatistics(prof.getPid());
        for(Statistic s: updatedStats){
            if(s.getCategory() == Category.Art){
                result = s.getWrong();
            }
        }
        assertEquals(expResult,result);
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
        //Cant test properly yet because class isnt used yet, GameHistory not implemented.
    }
    
}
