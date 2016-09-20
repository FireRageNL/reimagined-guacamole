/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole;

import java.util.List;

/**
 *
 * @author Marc
 */
public class Profile extends Player {

    private String email;
    private String name;
    private String nickname;
    private int pid;
    private int wins;
    private int losses;
    private List<Achievement> Achievements;
    private List<Statistic> Statistics;
    private List<GameInfo> GameHistory;
    
    public Profile(String email, String name, String nickname, int pid, int wins, int losses) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.pid = pid;
        this.wins = wins;
        this.losses = losses;
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

    public void addWin(){
        
    }
    
    public void addLoss(){
        
    }
    
    
    
}
