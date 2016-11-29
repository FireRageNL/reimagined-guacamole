/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Marc
 */
public interface IRound extends Remote {

    /**
     * Get the question for this round
     *
     * @return the question for this round
     * @throws RemoteException
     */
    public IQuestion getQuestion() throws RemoteException;

    /**
     * Set the question for this round
     *
     * @param question the question for the round
     * @throws RemoteException
     */
    public void setQuestion(IQuestion question) throws RemoteException;

    /**
     * Set the anwser the player gave for this round
     *
     * @param answer the anwser the player gave
     * @throws RemoteException
     */
    public void setGivenAnswer(int answer) throws RemoteException;

    /**
     * Get the given anwser the player gave
     *
     * @return the given anwser
     * @throws RemoteException
     */
    public int getGivenAnswer() throws RemoteException;

    /**
     * Create a new empty round
     *
     * @return a new empty round
     * @throws RemoteException
     */
    public IRound createRound() throws RemoteException;
}
