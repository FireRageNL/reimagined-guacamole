/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Jorrit
 */
public interface IProfile extends Remote {

    /**
     * Get the email of the current profile
     *
     * @return The email of the current profile
     * @throws RemoteException
     */
    public String getEmail() throws RemoteException;

    /**
     * Get the name of the current profile
     *
     * @return The name of the current profile
     * @throws RemoteException
     */
    public String getName() throws RemoteException;

    /**
     * Get the nickname of the current profile
     *
     * @return The nickname of the current profile
     * @throws RemoteException
     */
    public String getNickname() throws RemoteException;

    /**
     * Get the ProfileID from the current profile
     *
     * @return The ProfileID of the current profile
     * @throws RemoteException
     */
    public int getPid() throws RemoteException;

    /**
     * Get the current wins associated with the profile
     *
     * @return The current wins of the profile
     * @throws RemoteException
     */
    public int getWins() throws RemoteException;

    /**
     * Get the current losses associated with the profile
     *
     * @return The current losses of the profile
     * @throws RemoteException
     */
    public int getLosses() throws RemoteException;

    /**
     * Add a win to the current profile
     *
     * @throws RemoteException
     */
    public void addWin() throws RemoteException;

    /**
     * Add a loss to the current profile
     *
     * @throws RemoteException
     */
    public void addLoss() throws RemoteException;

    /**
     * Get a list of the statistics per category of the current profile
     *
     * @return the list of statistics
     * @throws RemoteException
     */
    public List<IStatistic> getStatistics() throws RemoteException;

    /**
     * Set a new statistic in the current profile
     *
     * @param stat the statistic to be set
     * @throws RemoteException
     */
    public void setStatistics(List<IStatistic> stat) throws RemoteException;

    /**
     * Change the nickname of the current profile
     *
     * @param nick the new nickname to be set
     * @throws RemoteException
     */
    public void setNickName(String nick) throws RemoteException;

    /**
     * Get all Achievements of the profile
     *
     * @return the achievemnts assoicated with the profile
     * @throws RemoteException
     */
    public List<IAchievement> getAchievements() throws RemoteException;

    /**
     * Add a achievement to the current profile
     *
     * @param toAdd The achievement to be added
     * @throws RemoteException
     */
    public void addAchievement(IAchievement toAdd) throws RemoteException;

    /**
     * Get the current world rankings
     *
     * @return A list of the world rankings
     * @throws RemoteException
     */
    public List<IRanking> getRankings() throws RemoteException;

    /**
     * Get the game history of the current profile
     *
     * @return the game history of the profile
     * @throws RemoteException
     */
    public List<IHistory> getHistory() throws RemoteException;
}
