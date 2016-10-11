/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import reimaginedguacamole.profile.Profile;


/**
 *
 * @author Marc
 */
public class Player extends Profile{
    
    private int score;

    public Player(String email, String name, String nickname, int pid, int wins, int losses) {
        super(email, name, nickname, pid, wins, losses);
        score = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    
    
}
