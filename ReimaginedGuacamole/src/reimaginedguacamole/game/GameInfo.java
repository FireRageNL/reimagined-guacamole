/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.util.Date;

/**
 *Holds information for history of games
 * @author Marc
 */
public class GameInfo {

    private Date date;
    private int score;
    
    public GameInfo(Date date, int score) {
        this.date = date;
        this.score = score;
    }


    public Date getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

   
    
}
