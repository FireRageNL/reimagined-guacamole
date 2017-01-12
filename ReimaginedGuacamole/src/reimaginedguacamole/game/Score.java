/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author roy_v
 */
public class Score implements Serializable, Comparable {

    private final String name;
    private final int playerScore;

    public Score(String name, int score) {
        this.name = name;
        this.playerScore = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return playerScore;
    }

    @Override
    public int compareTo(Object o) {
        Score comp = (Score) o;
        return Integer.compare(this.playerScore, comp.getScore());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Score sc = (Score) o;
        return sc.getName().equals(this.getName()) && sc.getScore() == this.getScore();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.playerScore;
        return hash;
    }
}
