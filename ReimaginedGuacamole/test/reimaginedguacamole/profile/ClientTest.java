/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class ClientTest {
    
    public ClientTest() {
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
     * Test of sendMessage method, of class Client.
     */
    @Test
    public void testSendMessage() throws Exception {
        System.out.println("sendMessage");
        String message = "";
        Client instance = null;
        instance.sendMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMessage method, of class Client.
     */
    @Test
    public void testAddMessage() throws Exception {
        System.out.println("addMessage");
        String message = "";
        Client instance = null;
        instance.addMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() throws Exception {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leaveChatroom method, of class Client.
     */
    @Test
    public void testLeaveChatroom() throws Exception {
        System.out.println("leaveChatroom");
        Client instance = null;
        instance.leaveChatroom();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePlayerList method, of class Client.
     */
    @Test
    public void testUpdatePlayerList() throws Exception {
        System.out.println("updatePlayerList");
        List<String> playerData = null;
        Client instance = null;
        instance.updatePlayerList(playerData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterChatroom method, of class Client.
     */
    @Test
    public void testEnterChatroom() throws Exception {
        System.out.println("enterChatroom");
        Client instance = null;
        instance.enterChatroom();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
