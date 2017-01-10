/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.io.Serializable;

/**
 *
 * @author roy_v
 */
public class Score implements Serializable, Comparable {

    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        Score comp = (Score) o;
        return Integer.compare(this.score, comp.getScore());
    }

}
