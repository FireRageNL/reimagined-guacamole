/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import reimaginedguacamolems.database.ProfileDB;

/**
 *Class that holds important profile information.
 * @author Marc
 */
public class Profile extends UnicastRemoteObject implements IProfile,Serializable {

    private String email;
    private String name;
    private String nickname;
    private int pid;
    private int wins;
    private int losses;
    private ArrayList<Achievement> achievements;
    private ArrayList<Statistic> statistics;
    private final ProfileDB pdb = new ProfileDB();

    public Profile() throws RemoteException {
    }
    
    //Default constructor for 
    public Profile(String email, String name, String nickname, int pid, int wins, int losses)throws RemoteException {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.pid = pid;
        this.wins = wins;
        this.losses = losses;
        achievements = new ArrayList<>();

    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public int getPid() {
        return pid;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getLosses() {
        return losses;
    }

    @Override
    public void addWin() {
        wins++;
        pdb.addWin(this);
    }

    @Override
    public void addLoss() {
        losses++;
        pdb.addLoss(this);
    }

    @Override
    public List<Statistic> getStatistics() {
        return statistics;
    }
    @Override
    public void setStatistics(List<Statistic> stat) {
        statistics = (ArrayList) stat;
    }

    @Override
    public void setNickName(String nick) {
        this.nickname = nick;
        pdb.saveNickname(this);
    }
    
    @Override
    public List<Achievement> getAchievements(){
        return achievements;
    }
    @Override
    public void addAchievement(Achievement toAdd){
        achievements.add(toAdd);
        pdb.storeAchievement(toAdd,this);
    }
    
    @Override
    public List<Ranking> getRankings(){
       return pdb.getRankings();
    }

    @Override
    public List<History> getHistory() {
        return pdb.getHistory(pid);
    }

}
