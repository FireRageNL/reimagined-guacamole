/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import reimaginedguacamole.database.ProfileDB;
import reimaginedguacamole.game.Category;

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
    public void testGetEmail() {
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
    public void testGetName() {
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
    public void testGetNickname() {
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
    public void testGetPid() {
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
    public void testGetWins() {
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
    public void testGetLosses() {
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
    public void testAddWin() {
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
    public void testAddLoss() {
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
    public void testGetStatistics() {
        System.out.println("getStatistics");
        ProfileDB db = new ProfileDB();
        Profile instance = db.getProfileData("test@test.test");
        int expResult = 7;
        int result = instance.getStatistics().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatistics method, of class Profile.
     */
    @Test
    public void testSetStatistics() {
        System.out.println("setStatistics");
        
        List<Statistic> stat = new ArrayList<>();
        stat.add(new Statistic(Category.Art,9,2));
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.setStatistics(stat);
        int expResult = 9;
        int result = instance.getStatistics().get(0).getRight();
        assertEquals(expResult,result);
    }

    /**
     * Test of setNickName method, of class Profile.
     */
    @Test
    public void testSetNickName() {
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
    public void testGetAchievements() {
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
    public void testAddAchievement() {
        System.out.println("addAchievement");
        Achievement toAdd = new Achievement("Such a pretty test achievement","test");
        Profile instance = new Profile("test@email.com","test","Testie",2,10,20);
        instance.addAchievement(toAdd);
        String result = instance.getAchievements().get(0).getName();
        String expResult = "test";
        assertEquals(expResult,result);
    }
}
