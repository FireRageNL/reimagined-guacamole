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
 * @author roy_v
 */
public interface IQuestion extends Remote {

    /**
     * Get the question itself
     *
     * @return the question
     * @throws RemoteException
     */
    public String getQuestionContents() throws RemoteException;

    /**
     * Get the first anwser
     *
     * @return the first anwser
     * @throws RemoteException
     */
    public String getAnswer1() throws RemoteException;

    /**
     * Get the second anwser
     *
     * @return the second anwser
     * @throws RemoteException
     */
    public String getAnswer2() throws RemoteException;

    /**
     * Get the third anwser
     *
     * @return the third anwser
     * @throws RemoteException
     */
    public String getAnswer3() throws RemoteException;

    /**
     * Get the fourth anwser
     *
     * @return the fourth anwser
     * @throws RemoteException
     */
    public String getAnswer4() throws RemoteException;

    /**
     * Get the correct anwser
     *
     * @return an integer representing the correct anwser
     * @throws RemoteException
     */
    public int getCorrectAnswer() throws RemoteException;

    /**
     * Get the category the question belongs to
     *
     * @return the catergory
     * @throws RemoteException
     */
    public Category getCategory() throws RemoteException;

}
