/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.GameRoom;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.tooling.Hashing;

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
        String username = "daan@email.com";
        String password = "8f447168a4a83aa70f492d927abf96843dc2b33d0e4f45d4199955ba9496135d";
        GameServer instance = new GameServer();
        boolean expResult = true;
        boolean result = instance.tryLogin(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentProfile method, of class GameServer.
     */
    @Test
    public void testGetCurrentProfile() throws Exception {
        System.out.println("getCurrentProfile");
        String email = "daan@email.com";
        GameServer instance = new GameServer();
        String expResult = "Daan";
        IProfile result = instance.getCurrentProfile(email);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of registerNewUser method, of class GameServer.
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
        GameServer instance = new GameServer();
        instance.registerNewUser(profileData);
    }

    /**
     * Test of createGameRoom method, of class GameServer.
     */
    @Test
    public void testCreateGameRoom() throws Exception {
        System.out.println("createGameRoom");
        int duration = 5;
        int rounds = 10;
        String roomname = "Test";
        String ip = "127.0.0.1";
        GameServer instance = new GameServer();
        IGameRoom result = instance.createGameRoom(duration, rounds, roomname, ip);
        assertEquals(roomname, result.toString());
    }

    /**
     * Test of sendGameRoomData method, of class GameServer.
     */
    @Test
    public void testSendGameRoomData() throws Exception {
        System.out.println("sendGameRoomData");
        GameServer instance = new GameServer();
        List<IGameRoom> result = instance.sendGameRoomData();
        assertEquals(true, result.isEmpty());
    }

    /**
     * Test of joinRoom method, of class GameServer.
     */
    @Test
    public void testJoinRoom() throws Exception {
        System.out.println("joinRoom");
        IGameRoom room = new GameRoom();
        GameServer instance = new GameServer();
        IGameClient user = (IGameClient) instance.getCurrentProfile("daan@email.com");
        instance.joinRoom(user, room);
        // TODO review the generated test code and remove the default call to fail.
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of startGame method, of class GameServer.
     */
    @Test
    public void testStartGame() throws Exception {
        System.out.println("startGame");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.startGame(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
         fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of broadcastGameState method, of class GameServer.
     */
    @Test
    public void testBroadcastGameState() throws Exception {
        System.out.println("broadcastGameState");
        GameState gameState = null;
        IGameRoom gr = new GameRoom();
        GameServer instance = new GameServer();
        instance.broadcastGameState(gameState, gr);
        // TODO review the generated test code and remove the default call to fail.
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getCurrentUser method, of class GameServer.
     */
    @Test
    public void testGetCurrentUser() throws Exception {
        System.out.println("getCurrentUser");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        int expResult = 0;
        int result = instance.getCurrentUser(joinedRoom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getUserIndex method, of class GameServer.
     */
    @Test
    public void testGetUserIndex() throws Exception {
        System.out.println("getUserIndex");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.getUserIndex(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
         fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of spinWheel method, of class GameServer.
     */
    @Test
    public void testSpinWheel() throws Exception {
        System.out.println("spinWheel");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.spinWheel(joinedRoom);
        // TODO review the generated test code and remove the default call to fail.
         fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
}
