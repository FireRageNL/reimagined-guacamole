/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import reimaginedguacamole.game.Category;
import reimaginedguacamolems.database.ProfileDB;

/**
 *
 * @author roy_v
 */
public class ProfileTest {
    
    public ProfileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getEmail method, of class Profile.
     */
    @Test
    public void testGetEmail() throws RemoteException {
        System.out.println("getEmail");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        String expResult = "test@email.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Profile.
     */
    @Test
    public void testGetName() throws RemoteException {
        System.out.println("getName");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNickname method, of class Profile.
     */
    @Test
    public void testGetNickname() throws RemoteException {
        System.out.println("getNickname");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        String expResult = "Testie";
        String result = instance.getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPid method, of class Profile.
     */
    @Test
    public void testGetPid() throws RemoteException {
        System.out.println("getPid");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        int expResult = 2;
        int result = instance.getPid();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWins method, of class Profile.
     */
    @Test
    public void testGetWins() throws RemoteException {
        System.out.println("getWins");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        int expResult = 10;
        int result = instance.getWins();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLosses method, of class Profile.
     */
    @Test
    public void testGetLosses() throws RemoteException {
        System.out.println("getLosses");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        int expResult = 20;
        int result = instance.getLosses();
        assertEquals(expResult, result);
    }

    /**
     * Test of addWin method, of class Profile.
     */
    @Test
    public void testAddWin() throws RemoteException {
        System.out.println("addWin");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.addWin();
        int expResult = 11;
        int result = instance.getWins();
        assertEquals(expResult,result);
    }

    /**
     * Test of addLoss method, of class Profile.
     */
    @Test
    public void testAddLoss() throws RemoteException {
        System.out.println("addLoss");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.addLoss();
        int expResult = 21;
        int result = instance.getLosses();
        assertEquals(expResult,result);
    }

    /**
     * Test of getStatistics method, of class Profile.
     */
    @Test
    public void testGetStatistics() throws RemoteException {
        System.out.println("getStatistics");
        ProfileDB db = new ProfileDB();
        Profile instance = db.getProfileData("test@test.test");
        int expResult = 7;
        int result = instance.getStatistics().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNickName method, of class Profile.
     */
    @Test
    public void testSetNickName() throws RemoteException {
        System.out.println("setNickName");
        String nick = "testnickname1234";
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.setNickName(nick);
        assertEquals(nick,instance.getNickname());
    }

    /**
     * Test of getAchievements method, of class Profile.
     */
    @Test
    public void testGetAchievements() throws RemoteException {
        System.out.println("getAchievements");
        Achievement toAdd = new Achievement("Such a pretty test achievement","test");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.addAchievement(toAdd);
        String result = instance.getAchievements().get(0).getName();
        String expResult = "test";
        assertEquals(expResult,result);
    }

    /**
     * Test of addAchievement method, of class Profile.
     */
    @Test
    public void testAddAchievement() throws RemoteException {
        System.out.println("addAchievement");
        Achievement toAdd = new Achievement("Such a pretty test achievement","test");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.addAchievement(toAdd);
        String result = instance.getAchievements().get(0).getName();
        String expResult = "test";
        assertEquals(expResult,result);
    }
}
