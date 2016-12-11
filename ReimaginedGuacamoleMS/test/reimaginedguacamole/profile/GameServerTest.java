/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;

/**
 *
 * @author Jorrit
 */
public class GameServerTest {
    
    public GameServerTest() {
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
     * Test of tryLogin method, of class GameServer.
     */
    @Test
    public void testTryLogin() throws Exception {
        System.out.println("tryLogin");
        String username = "";
        String password = "";
        GameServer instance = new GameServer();
        boolean expResult = false;
        boolean result = instance.tryLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentProfile method, of class GameServer.
     */
    @Test
    public void testGetCurrentProfile() throws Exception {
        System.out.println("getCurrentProfile");
        String email = "";
        GameServer instance = new GameServer();
        IProfile expResult = null;
        IProfile result = instance.getCurrentProfile(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerNewUser method, of class GameServer.
     */
    @Test
    public void testRegisterNewUser() throws Exception {
        System.out.println("registerNewUser");
        Map profileData = null;
        GameServer instance = new GameServer();
        instance.registerNewUser(profileData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGameRoom method, of class GameServer.
     */
    @Test
    public void testCreateGameRoom() throws Exception {
        System.out.println("createGameRoom");
        int duration = 0;
        int rounds = 0;
        String roomname = "";
        String ip = "";
        GameServer instance = new GameServer();
        IGameRoom expResult = null;
        IGameRoom result = instance.createGameRoom(duration, rounds, roomname, ip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendGameRoomData method, of class GameServer.
     */
    @Test
    public void testSendGameRoomData() throws Exception {
        System.out.println("sendGameRoomData");
        GameServer instance = new GameServer();
        List<IGameRoom> expResult = null;
        List<IGameRoom> result = instance.sendGameRoomData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of joinRoom method, of class GameServer.
     */
    @Test
    public void testJoinRoom() throws Exception {
        System.out.println("joinRoom");
        IGameClient user = null;
        IGameRoom room = null;
        GameServer instance = new GameServer();
        instance.joinRoom(user, room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class GameServer.
     */
    @Test
    public void testStartGame() throws Exception {
        System.out.println("startGame");
        IGameRoom joinedRoom = null;
        GameServer instance = new GameServer();
        instance.startGame(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of broadcastGameState method, of class GameServer.
     */
    @Test
    public void testBroadcastGameState() throws Exception {
        System.out.println("broadcastGameState");
        GameState gameState = null;
        IGameRoom gr = null;
        GameServer instance = new GameServer();
        instance.broadcastGameState(gameState, gr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class GameServer.
     */
    @Test
    public void testGetCurrentUser() throws Exception {
        System.out.println("getCurrentUser");
        IGameRoom joinedRoom = null;
        GameServer instance = new GameServer();
        int expResult = 0;
        int result = instance.getCurrentUser(joinedRoom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIndex method, of class GameServer.
     */
    @Test
    public void testGetUserIndex() throws Exception {
        System.out.println("getUserIndex");
        IGameRoom joinedRoom = null;
        GameServer instance = new GameServer();
        instance.getUserIndex(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spinWheel method, of class GameServer.
     */
    @Test
    public void testSpinWheel() throws Exception {
        System.out.println("spinWheel");
        IGameRoom joinedRoom = null;
        GameServer instance = new GameServer();
        instance.spinWheel(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
