/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.IProfile;
import reimaginedguacamole.profile.IStatistic;

/**
 *
 * @author daan
 */
public class GameDB extends Database {

    /**
     * Function to update a statistic in the database, called when a question
     * has been anwsered
     *
     * @param prof the profile to update the statistic of
     * @param cat The catergory the anwsered question was about
     * @param right a boolean declaring if the question was anwsered correctly
     * or not
     * @throws RemoteException
     */
    public void updateStats(IProfile prof, Category cat, boolean right) throws RemoteException {
        //Statistic to store the statistic that needs to be updated
        IStatistic toUpdate = null;
        //loops through profile statistics until it has the right category and stores it in the statistic
        for (IStatistic s : prof.getStatistics()) {
            if (s.getCategory() == cat) {
                toUpdate = s;
            }
        }
        if (toUpdate != null) {
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
                    sql = "UPDATE Statistic SET Rights = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ?";
                } else {
                    sql = "UPDATE Statistic SET Wrong = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ? ";
                }
                PreparedStatement ps = this.conn.prepareStatement(sql);
                //sets the parameters
                if (right) {
                    ps.setInt(1, toUpdate.getRight());
                } else {
                    ps.setInt(1, toUpdate.getWrong());
                }
                ps.setInt(2, cat.ordinal() + 1);
                ps.setInt(3, prof.getPid());
                //executes the query
                ps.executeUpdate();
                //closes the connection
                this.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(GameDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Logger.getLogger(GameDB.class.getName()).log(Level.SEVERE, null, "No statistics have been updated for Profile " + prof.getPid());
        }

    }

    /**
     * Function that gets called at the end of a game to save the play data of
     * this game per user
     *
     * @param userid the userid of the user this gamedata has to be wrtiiten to
     * to the database
     * @param score the score the user attained in a game
     */
    public void endGame(int userid, int score) {
        //list to store profile and score
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Score", Integer.toString(score));
        hm.put("Profile_ProfileID", Integer.toString(userid));
        //updates the score of the profile
        this.insert("GameInfo", hm);
    }
}
