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
 * @author Jorrit
 */
public class ChatServerTest {
    
    public ChatServerTest() {
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
     * Test of listClients method, of class ChatServer.
     */
    @Test
    public void testListClients() throws Exception {
        System.out.println("listClients");
        ChatServer instance = new ChatServer();
        int expResult = 0;
        int result = instance.listClients().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of broadcastMessage method, of class ChatServer.
     */
    @Test
    public void testBroadcastMessage() throws Exception {
        System.out.println("broadcastMessage");
        String message = "Testmessage";
        ChatServer instance = new ChatServer();
        instance.broadcastMessage(message);
    }

    /**
     * Test of clientEnter method, of class ChatServer.
     */
    @Test
    public void testClientEnter() throws Exception {
        System.out.println("clientEnter");
        IClient client = null;
        ChatServer instance = new ChatServer();
        instance.clientEnter(client);
        fail("Faalt door rmi");
    }

    /**
     * Test of clientExit method, of class ChatServer.
     */
    @Test
    public void testClientExit() throws Exception {
        System.out.println("clientExit");
        IClient client = null;
        ChatServer instance = new ChatServer();
        instance.clientExit(client);
        fail("Faalt door rmi");
    }
    
}
