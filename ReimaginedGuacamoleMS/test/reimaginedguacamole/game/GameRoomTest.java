/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.gameserver.GameServer;
import reimaginedguacamole.profile.IGameClient;


/**
 *
 * @author Jorrit
 */
public class GameRoomTest {
    
    GameServer gs;
    
    public GameRoomTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws RemoteException {
        gs = new GameServer();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNrOfPlayers method, of class GameRoom.
     */
    @Test
    public void testGetNrOfPlayers() throws Exception {
        System.out.println("getNrOfPlayers");
        GameRoom instance = new GameRoom();
        int expResult = 0;
        int result = instance.getNrOfPlayers();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of joinRoom method, of class GameRoom.
     */
    @Test
    public void testJoinRoom() throws Exception {
        System.out.println("joinRoom");
        IGameClient profile = null;
        GameRoom instance = new GameRoom();
        instance.joinRoom(profile);
        // TODO review the generated test code and remove the default call to fail.
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of leaveRoom method, of class GameRoom.
     */
    @Test
    public void testLeaveRoom() throws Exception {
        System.out.println("leaveRoom");
        IGameClient profile = null;
        GameRoom instance = new GameRoom();
        instance.leaveRoom(profile);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getName method, of class GameRoom.
     */
    @Test
    public void testGetName() throws RemoteException, NotBoundException, UnknownHostException {
        System.out.println("getName");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        String expResult = "room";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getIp method, of class GameRoom.
     */
    @Test
    public void testGetIp() throws RemoteException, NotBoundException, UnknownHostException {
        System.out.println("getIp");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        String expResult = "127.0.0.1";
        String result = instance.getIp();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getNumberOfRounds method, of class GameRoom.
     */
    @Test
    public void testGetNumberOfRounds() throws Exception {
        System.out.println("getNumberOfRounds");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        String expResult = "5";
        String result = instance.getNumberOfRounds();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getNicknames method, of class GameRoom.
     */
    @Test
    public void testGetNicknames() throws Exception {
        System.out.println("getNicknames");
       GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        int expResult = 0;
        int result = instance.getNicknames().size();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of createGameRoom method, of class GameRoom.
     */
    @Test
    public void testCreateGameRoom() throws Exception {
        System.out.println("createGameRoom");
        int duration = 0;
        int rounds = 0;
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        instance.createGameRoom(duration, rounds);
        fail("Faalt door RMI(alleen interface beschikbaar)");
   }

    /**
     * Test of announceRoom method, of class GameRoom.
     */
    @Test
    public void testAnnounceRoom() throws Exception {
        System.out.println("announceRoom");
       GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        instance.announceRoom();
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of toString method, of class GameRoom.
     */
    @Test
    public void testToString() throws RemoteException {
        System.out.println("toString");
        GameRoom instance = new GameRoom();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getGameController method, of class GameRoom.
     */
    @Test
    public void testGetGameController() throws Exception {
        System.out.println("getGameController");
       GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        IGameController expResult = null;
        IGameController result = instance.getGameController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getPlayers method, of class GameRoom.
     */
    @Test
    public void testGetPlayers() throws Exception {
        System.out.println("getPlayers");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        int expResult = 0;
        int result = instance.getPlayers().size();
        assertEquals(expResult, result);
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getGameRoomListing method, of class GameRoom.
     */
    @Test
    public void testGetGameRoomListing() throws Exception {
        System.out.println("getGameRoomListing");
        GameRoom instance = new GameRoom();
        String expResult = "";
        String result = instance.getGameRoomListing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of getPlayersDone method, of class GameRoom.
     */
    @Test
    public void testGetPlayersDone() throws Exception {
        System.out.println("getPlayersDone");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        instance.getPlayersDone();
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of addPlayerDone method, of class GameRoom.
     */
    @Test
    public void testAddPlayerDone() throws Exception {
        System.out.println("addPlayerDone");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        instance.addPlayerDone();
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }

    /**
     * Test of setPlayersDone method, of class GameRoom.
     */
    @Test
    public void testSetPlayersDone() throws Exception {
        System.out.println("setPlayersDone");
        GameRoom instance = new GameRoom(5,10,"room","127.0.0.1",gs);
        instance.setPlayersDone();
        fail("Faalt door RMI(alleen interface beschikbaar)");
    }
    
}
