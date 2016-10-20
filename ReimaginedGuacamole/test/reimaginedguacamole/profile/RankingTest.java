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

/**
 *
 * @author Jorrit
 */
public class RankingTest {
    
    public RankingTest() {
    }

    /**
     * Test of getNickname method, of class Ranking.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Ranking instance = new Ranking(10,"nickname", 10);
        String expResult = "nickname";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRank method, of class Ranking.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Ranking instance = new Ranking(10,"nickname", 10);
        int expResult = 10;
        int result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Ranking.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Ranking instance = new Ranking(10,"nickname", 10);
        int expResult = 10;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }
    
}
