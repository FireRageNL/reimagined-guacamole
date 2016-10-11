/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.util.ArrayList;
import reimaginedguacamole.game.GameInfo;
import java.util.List;
import reimaginedguacamole.database.ProfileDB;

/**
 *
 * @author Marc
 */
public class Profile {

    private String email;
    private String name;
    private String nickname;
    private int pid;
    private int wins;
    private int losses;
    private List<Achievement> achievements;
    private List<Statistic> statistics;
    private List<GameInfo> GameHistory;
    private final ProfileDB pdb;

    public Profile(String email, String name, String nickname, int pid, int wins, int losses) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.pid = pid;
        this.wins = wins;
        this.losses = losses;
        pdb = new ProfileDB();
        achievements = new ArrayList<>();

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public int getPid() {
        return pid;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void addWin() {
        wins++;
        pdb.addWin(this);
    }

    public void addLoss() {
        losses++;
        pdb.addLoss(this);
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> stat) {
        statistics = stat;
    }

    public void setNickName(String nick) {
        this.nickname = nick;
        pdb.saveNickname(this);
    }
    
    public List<Achievement> getAchievements(){
        return achievements;
    }
    public void addAchievement(Achievement toAdd){
        achievements.add(toAdd);
        pdb.storeAchievement(toAdd,this);
    }

}
