/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class GameInfoTest {
    
    public GameInfoTest() {
    }

    /**
     * Test of getDate method, of class GameInfo.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Date date = new Date();
        GameInfo instance = new GameInfo(date,1000);
        Date expResult = date;
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class GameInfo.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Date date = new Date();
        GameInfo instance = new GameInfo(date,1000);
        int expResult = 1000;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }
    
}
