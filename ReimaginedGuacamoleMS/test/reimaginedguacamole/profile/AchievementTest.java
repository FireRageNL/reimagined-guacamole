/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roy_v
 */
public class AchievementTest {
    
    public AchievementTest() {
    }

    /**
     * Test of getDescription method, of class Achievement.
     */
    @Test
    public void testGetDescription() throws RemoteException {
        System.out.println("getDescription");
        IAchievement instance = new Achievement("This achievement is purely created for test purposes","Testachievement");
        String expResult = "This achievement is purely created for test purposes";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Achievement.
     */
    @Test
    public void testGetName() throws RemoteException {
        System.out.println("getName");
        Achievement instance = new Achievement("This achievement is purely created for test purposes","Testachievement");
        String expResult = "Testachievement";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
