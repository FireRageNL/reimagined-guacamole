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
public class LoginTest {
    
    public LoginTest() {
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
}
