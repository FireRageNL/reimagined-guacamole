/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Jorrit
 */
public interface IProfile  extends Remote{
    public String getEmail() throws RemoteException;
    public String getName() throws RemoteException;
    public String getNickname() throws RemoteException;
    public int getPid() throws RemoteException;
    public int getWins() throws RemoteException;
    public int getLosses() throws RemoteException;
    public void addWin() throws RemoteException;
    public void addLoss() throws RemoteException;
    public List<IStatistic> getStatistics() throws RemoteException;
    public void setStatistics(ArrayList<IStatistic> stat) throws RemoteException;
    public void setNickName(String nick) throws RemoteException;
    public List<IAchievement> getAchievements() throws RemoteException;
    public void addAchievement(IAchievement toAdd) throws RemoteException;
    public ArrayList<IRanking> getRankings() throws RemoteException;
    public ArrayList<IHistory> getHistory() throws RemoteException;
}
