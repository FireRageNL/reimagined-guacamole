/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.game.GameState;
import reimaginedguacamole.game.IGameRoom;
import reimaginedguacamole.networking.IMasterServer;

/**
 *
 * @author roy_v
 */
public interface IGameServer extends Remote {



    /**
     * Function that creates a new gameRoom to be created and registered on the
     * gameserver
     *
     * @param duration the time each user has to anwser one question
     * @param rounds the amout of rounds in a game
     * @param roomname the name of the gameroom
     * @param ip the IP address the game runs on
     * @return the newly created gameroom object
     * @throws RemoteException
     */
    public IGameRoom createGameRoom(int duration, int rounds, String roomname, String ip, IMasterServer ms) throws RemoteException;

    /**
     * Function to publish the roomdata into the lobby view
     *
     * @return
     * @throws RemoteException
     */
    public List<IGameRoom> sendGameRoomData() throws RemoteException;

    /**
     * Function to add a user to the current list of users in the room, so that
     * data gets pushed to every user in the lobby
     *
     * @param user the user to add to the list of users
     * @param room the room that the user is joining
     * @throws RemoteException
     */
    public void joinRoom(IGameClient user, IGameRoom room) throws RemoteException;

    /**
     * Start the first round of the game
     *
     * @param joinedRoom the room the game has to be started for
     * @throws RemoteException
     */
    public void startGame(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Function to broadcast a certain gamestate to all the gameclients in the
     * room
     *
     * @param gameState the gamestate to be broadcast
     * @param gr the gameroom the state has to be broadcast
     * @throws RemoteException
     */
    public void broadcastGameState(GameState gameState, IGameRoom gr) throws RemoteException;

    /**
     * Get the user who can spin the wheel
     *
     * @param joinedRoom the room to get the user from
     * @return an integer representation of the users who can spin
     * @throws RemoteException
     */
    public int getCurrentUser(IGameRoom joinedRoom) throws RemoteException;

    /**
     * get all the current user indexes from a certain room
     *
     * @param joinedRoom the room to get the indexes from
     * @throws RemoteException
     */
    public void getUserIndex(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Function to spin the wheel in a gameroom
     *
     * @param joinedRoom the gameroom the wheel is being spinned in
     * @throws RemoteException
     */
    public void spinWheel(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Function that gets called when the wheel has stopped spinning
     *
     * @param joinedRoom the room the wheel has been spun in
     * @param rotation the rotation the wheel achieved
     * @throws RemoteException
     */
    public void stopSpin(IGameRoom joinedRoom, double rotation) throws RemoteException;

    /**
     * Get the category for the next question
     *
     * @param joinedRoom the room to get the category from
     * @return The category of the next question
     * @throws RemoteException
     */
    public String getCategory(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Starts the first round in the room
     *
     * @param joinedRoom the room to start the room in
     * @throws RemoteException
     */
    public void startRound(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Get the current question to be anwsered in the room
     *
     * @param joinedRoom the room the question has to be get for
     * @return a string array with the question, the 4 anwsers and the right
     * answer
     * @throws RemoteException
     */
    public List<String> getQuestion(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Function that gets called when a player answered a question
     *
     * @param joinedRoom the room a player anwsered the question in
     * @throws RemoteException
     */
    public void playerAnswered(IGameRoom joinedRoom) throws RemoteException;

    /**
     * function to check all the anwsers of a user and add their scores
     *
     * @param joinedRoom the room that the anwser is to be checked for
     * @param userIndex the user this answser is getting checked for
     * @param score the score to be added to the current users score
     * @throws RemoteException
     */
    public void checkAnswers(IGameRoom joinedRoom, int userIndex, int score) throws RemoteException;

    /**
     * Refresh the current game UI with the updated scores and such.
     *
     * @param joinedRoom the room to update the UI for
     * @throws RemoteException
     */
    public void refreshUI(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Start the next round for a game
     *
     * @param joinedRoom the room to start the next round in
     * @throws RemoteException
     */
    public void nextRound(IGameRoom joinedRoom) throws RemoteException;

    /**
     * Function that removes a user from a room
     *
     * @param user the user that is leaving the room
     * @param room the room the user is leaving
     * @throws RemoteException
     */
    public void leaveRoom(IGameClient user, IGameRoom room) throws RemoteException;
}
