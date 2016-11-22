/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.profile.Statistic;

/**
 *
 * @author daan
 */
public class GameDB extends Database {

    public void updateStats(Profile prof, Category cat, boolean right) {
        //Statistic to store the statistic that needs to be updated
        Statistic toUpdate = null;
        //loops through profile statistics until it has the right category and stores it in the statistic
        for (Statistic s : prof.getStatistics()) {
            if (s.getCategory() == cat) {
                toUpdate = s;
            }
        }
        if(toUpdate!= null){
        //checks of question is right or wrong
        try {
            if (right) {
                toUpdate.setRight(1 + toUpdate.getRight());
            } else {
                toUpdate.setWrong(1 + toUpdate.getWrong());
            }
        } catch (Exception ex) {
            Logger.getLogger(GameDB.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            //opens the connection
            this.initConnection();
            //string to store the sql statement
            String sql;
            //sets the sql statement
            if (right) {
                System.out.println("Setting new rights statistic : " + toUpdate.getRight());
                sql = "UPDATE Statistic SET Rights = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ?";
            } else {
                System.out.println("Setting new wrong statistic: " + toUpdate.getWrong());
                sql = "UPDATE Statistic SET Wrong = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ? ";
            }
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //sets the parameters
            try {
                if (right) {
                    ps.setInt(1, toUpdate.getRight());
                } else {
                    ps.setInt(1, toUpdate.getWrong());
                }
            } catch (Exception ex) {
                Logger.getLogger(GameDB.class.getName()).log(Level.SEVERE, null, ex);

            }
            ps.setInt(2, (cat.ordinal() + 1));
            ps.setInt(3, prof.getPid());
            //executes the query
            ps.executeUpdate();
            System.out.println("I has executed ze update");
            //closes the connection
            this.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(GameDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }

    //ends the game
    public void endGame(int userid, int score) {
        //list to store profile and score
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Score", Integer.toString(score));
        hm.put("Profile_ProfileID", Integer.toString(userid));
        //updates the score of the profile
        this.Insert("GameInfo", hm);
    }
}
