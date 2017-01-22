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
 * Class that holds important profile information.
 *
 * @author Marc
 */
public class Profile extends UnicastRemoteObject implements IProfile, Serializable {

    private String email;
    private String name;
    private String nickname;
    private int pid;
    private int wins;
    private int losses;
    private ArrayList<IAchievement> achievements;
    private ArrayList<IStatistic> statistics;
    private final ProfileDB pdb = new ProfileDB();
    private int score;

    public Profile() throws RemoteException {
        //Empty constructor to overwrite the default constructor
    }

    /**
     * Constructor to create a new profile with all the data required to create
     * one
     *
     * @param email the email of the user
     * @param name the name of the user
     * @param nickname the nickname of the user
     * @param pid the ID value of the user in the database
     * @param wins the amount of wins the user has
     * @param losses the amount of losses the user has
     * @throws RemoteException
     */
    public Profile(String email, String name, String nickname, int pid, int wins, int losses) throws RemoteException {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.pid = pid;
        this.wins = wins;
        this.losses = losses;
        this.score = 0;
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
    }

    @Override
    public void addLoss() {
        losses++;
    }

    @Override
    public List<IStatistic> getStatistics() {
        return statistics;
    }

    @Override
    public void setStatistics(List<IStatistic> stat) {
        statistics = (ArrayList) stat;
    }

    @Override
    public void setNickName(String nick) {
        this.nickname = nick;
        pdb.saveNickname(this);
    }

    @Override
    public List<IAchievement> getAchievements() {
        return achievements;
    }

    @Override
    public List<IRanking> getRankings() {
        return pdb.getRankings();
    }

    @Override
    public List<IHistory> getHistory() {
        return pdb.getHistory(pid);
    }

    @Override
    public void addAchievement(IAchievement toAdd) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setScore(int score) throws RemoteException {
        this.score = score;
    }

    @Override
    public int getScore() throws RemoteException {
        return score;
    }

    @Override
    public void addScore(int score) throws RemoteException {
        this.score += score;
    }

}
