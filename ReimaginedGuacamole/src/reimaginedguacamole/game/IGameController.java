/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import reimaginedguacamole.profile.IProfile;

/**
 * This class handles all game mechanics It is an observable class with the
 * FXMLController as its observer.
 *
 * @author daan
 */
public interface IGameController extends Remote {

    /**
     * Starts the next round and sets currentRound to the new Round object
     *
     * @throws java.rmi.RemoteException
     */
    public void startNextRound() throws RemoteException;

    /**
     * Ends the game and uploads the game information to the database
     *
     * @param user Logged in profile
     * @throws java.rmi.RemoteException
     */
    public void endGame(IProfile user) throws RemoteException;

    /**
     * Chooses a category based on the rotation of the wheel. categories are
     * divided in 7 equal parts.
     *
     * @param wheel rotation of the wheel at this time
     * @return Category enum type
     * @throws java.rmi.RemoteException
     */
    public Category chooseCategory(double wheel) throws RemoteException;

    /**
     * Gets the current round object and returns it
     *
     * @return the current round object
     * @throws RemoteException
     */
    public IRound getCurrentRound() throws RemoteException;

    /**
     * Inserts a question into the round object based on the chosen category
     * then removes this question from the orgiinal list.
     *
     * @param category
     * @throws java.rmi.RemoteException
     */
    public void giveRoundQuestion(Category category) throws RemoteException;

    /**
     * Getter for the game in the current gameController
     *
     * @return the current game
     * @throws RemoteException
     */
    public IGame getGame() throws RemoteException;

    /**
     * Get the current state the game is in
     *
     * @return an Enum describing the gamestate
     * @throws RemoteException
     */
    public GameState getGameState() throws RemoteException;

    /**
     * Sets the gamestate and notifies the Observer so the game can update.
     *
     * @param gameState
     * @throws java.rmi.RemoteException
     */
    public void setGameState(GameState gameState) throws RemoteException;

    /**
     * A function to get the current anwser given
     *
     * @return the integer of the current anwser given
     * @throws RemoteException
     */
    public int getCurrentAnswer() throws RemoteException;

    /**
     * Sets the current anwser given
     *
     * @param currentAnswer the integer of the answser the user gave
     * @throws RemoteException
     */
    public void setCurrentAnswer(int currentAnswer) throws RemoteException;

    /**
     * Gets the correct anwser
     *
     * @return the integer of the correct anwser
     * @throws RemoteException
     */
    public int getCorrectAnswer() throws RemoteException;

    /**
     * Gets the current score of the game
     *
     * @return the current score
     * @throws RemoteException
     */
    public int getCurrentScore() throws RemoteException;

    /**
     * Get an integer representation of the current round the game is in
     *
     * @return an integer value of the current round
     * @throws RemoteException
     */
    public int getCurrentRoundIndex() throws RemoteException;

    /**
     * Check how many players are currently in the waitingforgame state
     *
     * @return the number of players waiting
     * @throws RemoteException
     */
    public int checkPlayers() throws RemoteException;

    /**
     * Checks the answer given and adds the score based on time.
     *
     * @param profile the profile the anwser has to be checked for
     * @param timeLeft the time the user had remaning when they anwsered the
     * question
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean checkAnswer(IProfile profile, double timeLeft) throws RemoteException;

    /**
     * Adds a player to the game controller when someone joins, to be able to
     * easily checked in other functions
     *
     * @throws RemoteException
     */
    public void addPlayersCount() throws RemoteException;

    /**
     * Removes a player to the game controller when someone leaves, to be able
     * to easily checked in other functions
     *
     * @throws RemoteException
     */
    public void removePlayersCount() throws RemoteException;

    /**
     * Gets the user that is allowed to spin
     * @return int of the user that is allowed to spin
     * @throws RemoteException 
     */
    public int getCurrentUser() throws RemoteException;
    

}
