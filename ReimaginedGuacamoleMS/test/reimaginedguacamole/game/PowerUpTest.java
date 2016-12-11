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
 * @author Jorrit
 */
public class PowerUpTest {
    
   public PowerUpTest() {
    }

    /**
     * Test of getDescription method, of class PowerUp.
     */
    @Test
    public void testGetDescription() throws RemoteException {
        System.out.println("getDescription");
        PowerUp instance = new PowerUp("Extra Punten" , "Krijg bij de volgende vraag extra punten");
        String expResult = "Krijg bij de volgende vraag extra punten";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class PowerUp.
     */
    @Test
    public void testGetName() throws RemoteException {
        System.out.println("getName");
        PowerUp instance = new PowerUp("Extra Punten" , "Krijg bij de volgende vraag extra punten");
        String expResult = "Extra Punten";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
