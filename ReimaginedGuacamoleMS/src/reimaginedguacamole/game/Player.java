/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import reimaginedguacamole.profile.Profile;


/**
 *Player is a player in the game. in this version still obsolete because we only need the profile class
 * @author Marc
 */
public class Player extends Profile implements IPlayer{
    
    private int score;
    /**
     * Default constructor for player, adds all data to the right variables and sets score to 0
     * @param email 
     * @param name
     * @param nickname
     * @param pid
     * @param wins
     * @param losses 
     */
    public Player(String email, String name, String nickname, int pid, int wins, int losses) throws RemoteException {
        super(email, name, nickname, pid, wins, losses);
        score = 0;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }
    
    
    
}
