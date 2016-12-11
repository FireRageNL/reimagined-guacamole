/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.List;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.profile.Achievement;
import reimaginedguacamole.profile.History;
import reimaginedguacamole.profile.IHistory;
import reimaginedguacamole.profile.IRanking;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.tooling.Hashing;

/**
 *
 * @author roy_v
 */
public class ProfileDBTest {

    public ProfileDBTest() {
    }

    /**
     * Test of login method, of class ProfileDB.
     */
    /**
     * Test of getProfileData method, of class ProfileDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testGetProfileData() throws RemoteException {
        System.out.println("getProfileData");
        String email = "test@test.test";
        ProfileDB instance = new ProfileDB();
        String expResult = "tessst";
        String result = instance.getProfileData(email).getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatistics method, of class ProfileDB.
     */
    @Test
    public void testGetStatistics() {
        System.out.println("getStatistics");
        int userID = 22;
        ProfileDB instance = new ProfileDB();
        int expResult = 7;
        int result = instance.getStatistics(userID).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveNickname method, of class ProfileDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testSaveNickname() throws RemoteException {
        System.out.println("saveNickname");
        Profile toSave = new Profile("test@email.com", "test", "Testie12345", 2, 10, 20);
        ProfileDB instance = new ProfileDB();
        instance.saveNickname(toSave);
        String expResult = "Testie12345";
        String result = instance.getProfileData("test@email.com").getNickname();
        assertEquals(expResult, result);
    }

    /**
     * Test of newUserRegistration method, of class ProfileDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testNewUserRegistration() throws RemoteException {
        System.out.println("newUserRegistration");
        LinkedHashMap profileData = new LinkedHashMap();
        String email = System.currentTimeMillis()+ "@test.com";
        profileData.put("Email", email);
        profileData.put("Password", Hashing.hashPassword("doot"));
        profileData.put("Nickname", "WhatAWeirdNick");
        profileData.put("Name", Integer.toString((int) System.currentTimeMillis()));
        ProfileDB instance = new ProfileDB();
        instance.newUserRegistration(profileData);
        String expResult = "WhatAWeirdNick";
        String result = instance.getProfileData(email).getNickname();
        assertEquals(expResult,result);
    }

    /**
     * Test of login method, of class ProfileDB.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String password = "";
        String email = "";
        ProfileDB instance = new ProfileDB();
        boolean expResult = false;
        boolean result = instance.login(password, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addWin method, of class ProfileDB.
     */
    @Test
    public void testAddWin() {
        System.out.println("addWin");
        Profile toSave = null;
        ProfileDB instance = new ProfileDB();
        instance.addWin(toSave);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLoss method, of class ProfileDB.
     */
    @Test
    public void testAddLoss() {
        System.out.println("addLoss");
        Profile toSave = null;
        ProfileDB instance = new ProfileDB();
        instance.addLoss(toSave);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeAchievement method, of class ProfileDB.
     */
    @Test
    public void testStoreAchievement() {
        System.out.println("storeAchievement");
        Achievement toAdd = null;
        Profile aThis = null;
        ProfileDB instance = new ProfileDB();
        instance.storeAchievement(toAdd, aThis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRankings method, of class ProfileDB.
     */
    @Test
    public void testGetRankings() {
        System.out.println("getRankings");
        ProfileDB instance = new ProfileDB();
        ObservableList<IRanking> expResult = null;
        ObservableList<IRanking> result = (ObservableList<IRanking>) instance.getRankings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHistory method, of class ProfileDB.
     */
    @Test
    public void testGetHistory() {
        System.out.println("getHistory");
        int username = 0;
        ProfileDB instance = new ProfileDB();
        ObservableList<History> expResult = null;
        ObservableList<IHistory> result = (ObservableList<IHistory>) instance.getHistory(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
