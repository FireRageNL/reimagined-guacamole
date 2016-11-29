/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javafx.beans.property.SimpleStringProperty;

/**
 *Class that holds a certain ranking in the world ranking list.
 * @author roy_v
 */
public class Ranking extends UnicastRemoteObject implements IRanking,Serializable {

   private final SimpleStringProperty rank;
   private final SimpleStringProperty nickname;
   private final SimpleStringProperty score;

    public Ranking(int rank, String nickname, int score) throws RemoteException{
        this.rank = new SimpleStringProperty(String.valueOf(rank));
        this.nickname = new SimpleStringProperty(nickname);
        this.score = new SimpleStringProperty(String.valueOf(score));
    }
    
   @Override
    public String getNickname(){
        return nickname.get();
    }
    
   @Override
    public int getRank(){
        return Integer.parseInt(rank.get());
    }
    
   @Override
    public int getScore(){
        return Integer.parseInt(score.get());
    }
}
