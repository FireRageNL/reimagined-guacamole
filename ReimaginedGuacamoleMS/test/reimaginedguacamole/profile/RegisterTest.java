/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import reimaginedguacamole.tooling.Hashing;

/**
 *
 * @author Jorrit
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerNewUser method, of class Register.
     */
    @Test
    public void testRegisterNewUser() throws Exception {
        System.out.println("registerNewUser");
        Map profileData = new LinkedHashMap();
        String email = System.currentTimeMillis()+ "@test.com";
        profileData.put("Email", email);
        profileData.put("Password", Hashing.hashPassword("doot"));
        profileData.put("Nickname", "WhatAWeirdNick");
        profileData.put("Name", Integer.toString((int) System.currentTimeMillis()));
        Register instance = new Register();
        instance.registerNewUser(profileData);
    }
    
}
