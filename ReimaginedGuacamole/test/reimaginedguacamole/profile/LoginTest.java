/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author roy_v
 */
public class LoginTest {
    
    public LoginTest() {
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
     * Test of tryLogin method, of class Login.
     */
    @Test
    public void testTryLogin() {
        System.out.println("tryLogin");
        String email = "test@email.com";
        String password = "test";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.tryLogin(email, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTryLoginWrong(){
        System.out.println("tryLogin Wrong");
        String email = "test@email.com";
        String password = "wrongpassword";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.tryLogin(email,password);
        assertEquals(expResult,result);
    }

    /**
     * Test of getCurrentProfile method, of class Login.
     */
    @Test
    public void testGetCurrentProfile() {
        System.out.println("getCurrentProfile");
        String email = "test@email.com";
        Login instance = new Login();
        String expResult = "Test";
        Profile result = instance.getCurrentProfile(email);
        assertEquals(expResult, result.getName());
    }
}
