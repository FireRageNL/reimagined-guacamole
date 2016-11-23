/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import javafx.beans.property.SimpleStringProperty;

/**
 * Class that holds the game history objects
 * @author roy_v
 */
public class History {

    private final SimpleStringProperty date;
    private final SimpleStringProperty score;
/**
 * Default constructor for a GameHistory object
 * @param date the date the game was played
 * @param score the score that the player had in this game
 */
    public History(String date, int score) {
        this.date = new SimpleStringProperty(date);
        this.score = new SimpleStringProperty(String.valueOf(score));
    }

    public String getDate() {
        return date.get().substring(0,date.get().length()-5);
    }

    public int getScore() {
        return Integer.parseInt(score.get());
    }
}
