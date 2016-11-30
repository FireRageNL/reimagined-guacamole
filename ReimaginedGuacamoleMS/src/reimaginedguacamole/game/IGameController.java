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
     */
    public void startNextRound();

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
     */
    public Category chooseCategory(double wheel);

    public IRound getCurrentRound();

    /**
     * Inserts a question into the round object based on the chosen category
     * then removes this question from the orgiinal list.
     *
     * @param category
     * @throws java.rmi.RemoteException
     */
    public void giveRoundQuestion(Category category) throws RemoteException;

    public IGame getGame();

    public GameState getGameState();

    /**
     * Sets the gamestate and notifies the Observer so the game can update.
     *
     * @param gameState
     */
    public void setGameState(GameState gameState);

    public int getCurrentAnswer();

    public void setCurrentAnswer(int currentAnswer);

    public int getCorrectAnswer() throws RemoteException;

    public int getCurrentScore();

    public int getCurrentRoundIndex();
    
    public int CheckPlayers();

    /**
     * Checks the answer given and adds the score based on time.
     *
     * @param profile
     * @param timeLeft
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean checkAnswer(IProfile profile, double timeLeft) throws RemoteException ;

}
