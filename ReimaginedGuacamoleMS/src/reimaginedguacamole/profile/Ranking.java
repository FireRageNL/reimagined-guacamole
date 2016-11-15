/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import javafx.beans.property.SimpleStringProperty;

/**
 *Class that holds a certain ranking in the world ranking list.
 * @author roy_v
 */
public class Ranking {

   private final SimpleStringProperty rank;
   private final SimpleStringProperty nickname;
   private final SimpleStringProperty score;

    public Ranking(int rank, String nickname, int score) {
        this.rank = new SimpleStringProperty(String.valueOf(rank));
        this.nickname = new SimpleStringProperty(nickname);
        this.score = new SimpleStringProperty(String.valueOf(score));
    }
    
    public String getNickname(){
        return nickname.get();
    }
    
    public int getRank(){
        return Integer.parseInt(rank.get());
    }
    
    public int getScore(){
        return Integer.parseInt(score.get());
    }
}
