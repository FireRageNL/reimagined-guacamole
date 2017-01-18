/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.gameserver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.GameRoom;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.gui.FXMLController;
import reimaginedguacamole.networking.IMasterServer;
import reimaginedguacamole.profile.GameClient;
import reimaginedguacamole.profile.IChatServer;
import reimaginedguacamole.profile.IGameClient;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author Marc
 */
public class GameServerTest {
    
    FXMLController application;
    IMasterServer ms;
    GameRoom gr;

    
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
     * Test of createGameRoom method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateGameRoom() throws Exception {
        System.out.println("createGameRoom");
        int duration = 5;
        int rounds = 10;
        String roomname = "Test";
        String ip = "127.0.0.1";
        GameServer instance = new GameServer();
        IGameRoom result = instance.createGameRoom(duration, rounds, roomname, ip,ms);
        assertEquals(roomname, result.toString());
    }

    /**
     * Test of sendGameRoomData method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testSendGameRoomData() throws Exception {
        System.out.println("sendGameRoomData");
        GameServer instance = new GameServer();
        List<IGameRoom> result = new ArrayList<>();
        result.add(instance.sendGameRoomData());
        assertEquals(true, result.isEmpty());
    }

    /**
     * Test of joinRoom method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testJoinRoom() throws Exception {
        System.out.println("joinRoom");
        IGameRoom room = new GameRoom();
        GameServer instance = new GameServer();
        IGameClient user = new GameClient(application);
        instance.joinRoom(user);
    }

    /**
     * Test of leaveRoom method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testLeaveRoom() throws Exception {
        System.out.println("leaveRoom");
        IGameClient user = new GameClient(application);
        GameServer instance = new GameServer();
        instance.leaveRoom(user);
    }

    /**
     * Test of startGame method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testStartGame() throws Exception {
        System.out.println("startGame");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.startGame(joinedRoom);
    }

    /**
     * Test of nextRound method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testNextRound() throws Exception {
        System.out.println("nextRound");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.nextRound(joinedRoom);
    }

    /**
     * Test of broadcastGameState method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testBroadcastGameState() throws Exception {
        System.out.println("broadcastGameState");
        GameState gameState = null;
        IGameRoom gr = new GameRoom();
        GameServer instance = new GameServer();
        instance.broadcastGameState(gameState, gr);
    }

    /**
     * Test of getCurrentUser method, of class GameServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurrentUser() throws Exception {
        System.out.println("getCurrentUser");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        int expResult = 0;
        int result = instance.getCurrentUser(joinedRoom);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestUser method, of class GameServer.
     */
    @Test
    public void testGetHighestUser() throws Exception {
        System.out.println("getHighestUser");
        GameServer instance = new GameServer();
        IProfile expResult = gr.getPlayers().get(0).getProfile();
        IProfile result = instance.getHighestUser();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of stopSpin method, of class GameServer.
     */
    @Test
    public void testStopSpin() throws Exception {
        System.out.println("stopSpin");
        IGameRoom joinedRoom = new GameRoom();
        double rotation = 60.0;
        GameServer instance = new GameServer();
        instance.stopSpin(joinedRoom, rotation);
    }

    /**
     * Test of getCategory method, of class GameServer.
     */
    @Test
    public void testGetCategory() throws Exception {
        System.out.println("getCategory");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        String expResult = null;
        String result = instance.getCategory(joinedRoom);
        assertEquals(expResult, result);
    }

    /**
     * Test of startRound method, of class GameServer.
     */
    @Test
    public void testStartRound() throws Exception {
        System.out.println("startRound");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.startRound(joinedRoom);
    }

    /**
     * Test of getQuestion method, of class GameServer.
     */
    @Test
    public void testGetQuestion() throws Exception {
        System.out.println("getQuestion");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        List<String> expResult = null;
        List<String> result = instance.getQuestion(joinedRoom);
        assertEquals(expResult, result);
    }

    /**
     * Test of playerAnswered method, of class GameServer.
     */
    @Test
    public void testPlayerAnswered() throws Exception {
        System.out.println("playerAnswered");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.playerAnswered(joinedRoom);
    }

    /**
     * Test of checkAnswers method, of class GameServer.
     */
    @Test
    public void testCheckAnswers() throws Exception {
        System.out.println("checkAnswers");
        IGameRoom joinedRoom = new GameRoom();
        int userIndex = 0;
        int score = 0;
        GameServer instance = new GameServer();
        instance.checkAnswers(joinedRoom, userIndex, score);
    }

    /**
     * Test of refreshUI method, of class GameServer.
     */
    @Test
    public void testRefreshUI() throws Exception {
        System.out.println("refreshUI");
        IGameRoom joinedRoom = new GameRoom();
        GameServer instance = new GameServer();
        instance.refreshUI(joinedRoom);
    }

    /**
     * Test of uploadStatistics method, of class GameServer.
     */
    @Test
    public void testUploadStatistics() throws Exception {
        System.out.println("uploadStatistics");
        GameServer instance = new GameServer();
        IProfile prof = gr.getPlayers().get(0).getProfile();
        instance.uploadStatistics(ms, prof);
    }

    /**
     * Test of getChatServer method, of class GameServer.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testGetChatServer() throws RemoteException {
        System.out.println("getChatServer");
        GameServer instance = new GameServer();
        IChatServer expResult = null;
        IChatServer result = instance.getChatServer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIp method, of class GameServer.
     */
    @Test
    public void testGetIp() throws Exception {
        System.out.println("getIp");
        GameServer instance = new GameServer();
        String expResult = "127.0.0.1";
        String result = instance.getIp();
        assertEquals(expResult, result);
    }
    
}
