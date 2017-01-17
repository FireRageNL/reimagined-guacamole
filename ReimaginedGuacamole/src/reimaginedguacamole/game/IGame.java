/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author Marc
 */
public interface IGame extends Remote {

    /**
     * Get the list of questions in the current game
     *
     * @return the list of questions
     * @throws RemoteException
     */
    public List<IQuestion> getQuestionsList() throws RemoteException;

    /**
     * Get the current timespan in which the players can anwser a question
     *
     * @return the duration in secodns
     * @throws RemoteException
     */
    public int getRoundDuration() throws RemoteException;

    /**
     * Set the timespan in which the players can anwser a question
     *
     * @param roundDuration the duration of the timespan in seconds
     * @throws RemoteException
     */
    public void setRoundDuration(int roundDuration) throws RemoteException;

    /**
     * Set the amount of rounds in a game
     *
     * @param amount the amount of rounds
     * @throws RemoteException
     */
    public void setAmountOfRounds(int amount) throws RemoteException;

    /**
     * Get the current amount of rounds in the game
     *
     * @return the amount of rounds
     * @throws RemoteException
     */
    public int getAmountOfRounds() throws RemoteException;

    /**
     * Update the statistics after a player anwsered a question
     *
     * @param prof the profile of the player who anwsered
     * @throws RemoteException
     */
    public void updateStats(IProfile prof) throws RemoteException;

    /**
     * The function called at the end of the game to create a game history
     * record
     *
     * @param userID the ID of the user
     * @param score the score the user achieved
     * @throws RemoteException
     */
    public void endGame(int userID, int score) throws RemoteException;
}
