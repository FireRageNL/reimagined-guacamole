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
 * @author roy_v
 */
public class ProfileTest {
    
    public ProfileTest() {
    }

    /**
     * Test of getEmail method, of class Profile.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        String expResult = "test@email.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Profile.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNickname method, of class Profile.
     */
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        String expResult = "Testie";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPid method, of class Profile.
     */
    @Test
    public void testGetPid() {
        System.out.println("getPid");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        int expResult = 3;
        int result = instance.getPid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWins method, of class Profile.
     */
    @Test
    public void testGetWins() {
        System.out.println("getWins");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        int expResult = 10;
        int result = instance.getWins();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLosses method, of class Profile.
     */
    @Test
    public void testGetLosses() {
        System.out.println("getLosses");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        int expResult = 20;
        int result = instance.getLosses();
        assertEquals(expResult, result);
    }

    /**
     * Test of addWin method, of class Profile.
     */
    @Test
    public void testAddWin() {
        System.out.println("addWin");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        instance.addWin();
        int expResult = 11;
        int result = instance.getWins();
        assertEquals(expResult,result);
    }

    /**
     * Test of addLoss method, of class Profile.
     */
    @Test
    public void testAddLoss() {
        System.out.println("addLoss");
        Profile instance = new Profile("test@email.com","test","Testie",3,10,20);
        instance.addLoss();
        int expResult = 21;
        int result = instance.getLosses();
        assertEquals(expResult,result);
    }
    
}
