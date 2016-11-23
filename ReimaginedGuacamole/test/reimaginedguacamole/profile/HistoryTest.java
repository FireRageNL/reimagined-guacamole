/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class HistoryTest {
    
    public HistoryTest() {
    }

    /**
     * Test of getDate method, of class History.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        History instance = new History("18/10/2016:0000",10);
        String expResult = "18/10/2016";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class History.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
         History instance = new History("18/10/2016:0000",10);
        int expResult = 10;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }
    
}
