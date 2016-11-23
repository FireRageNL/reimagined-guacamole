/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class that holds the game history objects
 *
 * @author roy_v
 */
public class History extends UnicastRemoteObject implements IHistory {

    private final SimpleStringProperty date;
    private final SimpleStringProperty score;

    /**
     * Default constructor for a GameHistory object
     *
     * @param date the date the game was played
     * @param score the score that the player had in this game
     * @throws RemoteException
     */
    public History(String date, int score) throws RemoteException {
        this.date = new SimpleStringProperty(date);
        this.score = new SimpleStringProperty(String.valueOf(score));
    }

    @Override
    public String getDate() {
        return date.get().substring(0, date.get().length() - 5);
    }

    @Override
    public int getScore() {
        return Integer.parseInt(score.get());
    }
}
