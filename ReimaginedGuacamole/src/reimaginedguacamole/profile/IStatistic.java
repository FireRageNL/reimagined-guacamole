/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import reimaginedguacamole.game.Category;

/**
 *
 * @author roy_v
 */
public interface IStatistic extends Remote {

    /**
     * Get the Statistic's category
     *
     * @return the Category
     * @throws java.rmi.RemoteException
     */
    public Category getCategory() throws RemoteException;

    /**
     * Get the amount of right anwesered questions
     *
     * @return the amount of right anwsered questions
     * @throws java.rmi.RemoteException
     */
    public int getRight() throws RemoteException;

    /**
     * Set the amount of right anwsered questions
     *
     * @param right the amount of right anwsered questions
     * @throws java.rmi.RemoteException
     */
    public void setRight(int right) throws RemoteException;

    /**
     * Get the amount of wronly anwsered questions
     *
     * @return the amount of wrongly anwsered questions
     * @throws java.rmi.RemoteException
     */
    public int getWrong() throws RemoteException;

    /**
     * Set the amount of wrongly anwsered questions
     *
     * @param wrong the amount of wrongly anwsered questions
     * @throws java.rmi.RemoteException
     */
    public void setWrong(int wrong) throws RemoteException;

    /**
     * Percentage of category questions anwsered right
     *
     * @return Percentage(int)
     * @throws java.rmi.RemoteException
     */
    public int returnPercentage() throws RemoteException;
}
