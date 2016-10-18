/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        Statistic toUpdate = null;
        for (Statistic s : prof.getStatistics()) {
            if (s.getCategory() == cat) {
                toUpdate = s;
            }
        }
        if (right) {
            toUpdate.setRight(1 + toUpdate.getRight());
        } else {
            toUpdate.setWrong(1 + toUpdate.getWrong());
        }
        try{
        this.initConnection();
        String sql;
        if (right) {
            System.out.println("Setting new rights statistic : "+ toUpdate.getRight());
            sql = "UPDATE Statistic SET Rights = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ?";
        } else {
            System.out.println("Setting new wrong statistic: "+ toUpdate.getWrong());
            sql = "UPDATE Statistic SET Wrong = ? WHERE Category_CategoryID = ? AND Profile_ProfileID = ? ";
        }
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        if(right){
            ps.setInt(1, toUpdate.getRight());
        }
        else if(!right){
            ps.setInt(1, toUpdate.getWrong());
        }
        ps.setInt(2, (cat.ordinal() + 1));
        ps.setInt(3,prof.getPid());
        ps.executeUpdate();
        System.out.println("I has executed ze update");
        this.closeConnection();
        }
        catch(SQLException ex){
         System.out.println(ex.getMessage()); 
        }
        
    }
    public void endGame(int userid, int score){
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Score", Integer.toString(score));
        hm.put("Profile_ProfileID", Integer.toString(userid));
        this.Insert("GameInfo", hm);
    }
}
