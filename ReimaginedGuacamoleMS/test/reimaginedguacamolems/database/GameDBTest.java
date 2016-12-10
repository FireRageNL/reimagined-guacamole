/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.IStatistic;
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
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testUpdateStatsWrong() throws RemoteException {
        System.out.println("updateStats");
        Profile prof;
        Category cat = Category.ART;
        boolean right = false;
        GameDB instance = new GameDB();
        ProfileDB test = new ProfileDB();
        prof = test.getProfileData("test@test.test");
        int expResult = 0;
        List<IStatistic> stats = prof.getStatistics();
        for(IStatistic s : stats){
            if(s.getCategory() == Category.ART){
                expResult = s.getWrong() + 1;
            }
        }
        int result = 0;
        instance.updateStats(prof, cat, right);
        List<IStatistic> updatedStats = test.getStatistics(prof.getPid());
        for(IStatistic s: updatedStats){
            if(s.getCategory() == Category.ART){
                result = s.getWrong();
            }
        }
        assertEquals(expResult,result);
    }
    
     /**
     * Test of updateStats method, of class GameDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testUpdateStatsRight() throws RemoteException {
        System.out.println("updateStats");
        Profile prof;
        Category cat = Category.ART;
        boolean right = true;
        GameDB instance = new GameDB();
        ProfileDB test = new ProfileDB();
        prof = test.getProfileData("test@test.test");
        int expResult = 0;
        List<IStatistic> stats = prof.getStatistics();
        for(IStatistic s : stats){
            if(s.getCategory() == Category.ART){
                expResult = s.getRight() + 1;
            }
        }
        int result = 0;
        instance.updateStats(prof, cat, right);
        List<IStatistic> updatedStats = test.getStatistics(prof.getPid());
        for(IStatistic s: updatedStats){
            if(s.getCategory() == Category.ART){
                result = s.getRight();
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
