/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.Achievement;
import reimaginedguacamole.profile.Profile;
import reimaginedguacamole.profile.Ranking;
import reimaginedguacamole.profile.Statistic;

/**
 * Class that handles all databaserequests for a user's profile
 *
 * @author daan
 */
public class ProfileDB extends Database {

    /**
     * checks if a user can login with the provided credentials
     *
     * @param email
     * @param password
     * @return true when user can be logged in, else false.
     */
    public boolean login(String password, String email) {
        String dbPassword = this.ReadStringWithCondition("Password", "Profile", "Email", email);
        return password.equals(dbPassword);
    }

    /**
     * Gets profile data based on username
     *
     * @param email
     * @return Profile object
     */
    public Profile getProfileData(String email) {
        List<String> Columns = new ArrayList<>();
        Columns.add("Name");
        Columns.add("Email");
        Columns.add("Nickname");
        Columns.add("ProfileID");
        Columns.add("Wins");
        Columns.add("Losses");
        List<String> results = this.ReadStringWithCondition(Columns, "Profile", "Email", email);
        int pid = Integer.parseInt(results.get(3));
        int wins = Integer.parseInt(results.get(4));
        int losses = Integer.parseInt(results.get(5));
        Profile ret = new Profile(results.get(1), results.get(0), results.get(2), pid, wins, losses);
        List<Statistic> list = getStatistics(ret.getPid());
        ret.setStatistics(list);
        return ret;
    }

    public List<Statistic> getStatistics(int userID) {
        List<Statistic> list = new ArrayList<Statistic>();
        try {
            this.initConnection();
            String sql = "SELECT Rights,Wrong,Category_CategoryID FROM Statistic WHERE Profile_ProfileID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, Integer.toString(userID));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Statistic add = new Statistic(Category.values()[((rs.getInt(3)) - 1)], rs.getInt(1), rs.getInt(2));
                list.add(add);
            }
            this.closeConnection();
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void saveNickname(Profile toSave) {
        try {
            this.initConnection();
            String sql = "UPDATE Profile SET Nickname = ? WHERE ProfileID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, toSave.getNickname());
            ps.setInt(2, toSave.getPid());
            ps.executeUpdate();
            this.closeConnection();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void newUserRegistration(String profile, LinkedHashMap profileData) {
        this.Insert(profile, profileData);
        String email = (String) profileData.get("Email");
        int userID = Integer.parseInt(this.ReadStringWithCondition("ProfileID", "Profile", "Email", email));
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Profile_ProfileID", Integer.toString(userID));
        for (int i = 1; i <= 7; i++) {
            hm.put("Category_CategoryID", Integer.toString(i));
            this.Insert("Statistic", hm);
        }
    }

    public void addWin(Profile toSave) {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Wins", Integer.toString(toSave.getWins()));
        this.Update("Profile", hm, "ProfileID", Integer.toString(toSave.getPid()));
    }

    public void addLoss(Profile toSave) {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Losses", Integer.toString(toSave.getLosses()));
        this.Update("Profile", hm, "ProfileID", Integer.toString(toSave.getPid()));
    }

    public void storeAchievement(Achievement toAdd, Profile aThis) {
//Should have so is not implemented yet

    }

    public ObservableList<Ranking> getRankings() {
        ArrayList<Ranking> rankings = new ArrayList<>();
        try {
            this.initConnection();
            String sql = "SELECT SUM(Score) AS Score, (SELECT Nickname FROM Profile WHERE ProfileID = Profile_ProfileID ) as Nickname FROM `GameInfo` GROUP BY Profile_ProfileID ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int rank = 1;
            while (rs.next()) {
                Ranking add = new Ranking(rank,rs.getString(2),rs.getInt(1));
                rankings.add(add);
                rank++;
            }
            this.closeConnection();
            return (ObservableList<Ranking>) rankings;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
