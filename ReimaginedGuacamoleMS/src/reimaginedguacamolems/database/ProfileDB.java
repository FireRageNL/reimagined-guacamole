/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.profile.Achievement;
import reimaginedguacamole.profile.History;
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
    //checks the login
    public boolean login(String password, String email) {
        //gets the password for the inserted email
        String dbPassword = this.readStringWithCondition("Password", "Profile", "Email", email);
        //checks if input is the same as in the database
        return password.equals(dbPassword);
    }

    /**
     * Gets profile data based on username
     *
     * @param email
     * @return Profile object
     */
    //gets the user profile
    public Profile getProfileData(String email) throws RemoteException {
        //list for the columns to get from the database
        List<String> columns = new ArrayList<>();
        columns.add("Name");
        columns.add("Email");
        columns.add("Nickname");
        columns.add("ProfileID");
        columns.add("Wins");
        columns.add("Losses");
        //gets the result for the user with current email
        List<String> results = this.readStringWithCondition(columns, "Profile", "Email", email);
        //sets profileID 
        int pid = Integer.parseInt(results.get(3));
        // sets wins
        int wins = Integer.parseInt(results.get(4));
        //sets losses
        int losses = Integer.parseInt(results.get(5));
        //creates the profile
        Profile ret = new Profile(results.get(1), results.get(0), results.get(2), pid, wins, losses);
        //gets the statistics for the current user
        List<Statistic> list = getStatistics(ret.getPid());
        //sets the statistics for the current user
        ret.setStatistics((ArrayList<Statistic>) list);
        return ret;
    }
    /**
     * Gets the statistics from a certain user
     * @param userID the user to get the ID from
     * @return all the statistics from said user
     */
    public List<Statistic> getStatistics(int userID) {
        List<Statistic> list = new ArrayList<>();
        try {
            //opens the connection
            this.initConnection();
            //gets the statistics for current profile id
            String sql = "SELECT Rights,Wrong,Category_CategoryID FROM Statistic WHERE Profile_ProfileID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //sets the parameter
            ps.setString(1, Integer.toString(userID));
            //result set to store the result
            ResultSet rs = ps.executeQuery();
            // loops through the results and creates and adds the statistics to the list
            while (rs.next()) {
                Statistic add = new Statistic(Category.values()[(rs.getInt(3)) - 1], rs.getInt(1), rs.getInt(2));
                list.add(add);
            }
            //closes the connection
            this.closeConnection();
            //returns the list
            return list;
        } catch (Exception ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    /**
     * Change the nickname in the database from a certain profile.
     * @param toSave Profile to change and save.
     */
    public void saveNickname(Profile toSave) {
        try {
            //opens the connection
            this.initConnection();
            //sets the statement
            String sql = "UPDATE Profile SET Nickname = ? WHERE ProfileID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //sets the parameters
            ps.setString(1, toSave.getNickname());
            ps.setInt(2, toSave.getPid());
            //executes the query
            ps.executeUpdate();
            Logger.getLogger(ProfileDB.class.getName()).log(Level.INFO, "Nickname for user " + "{0}" + " changed", toSave.getPid());
            //closes the connection
            this.closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Function to save a new registered user
     * @param profileData Data to enter into database to save the user
     */
    public void newUserRegistration(Map profileData) {
        this.insert("Profile", profileData);
        //gets the email from the profile and sets it in a string
        String email = (String) profileData.get("Email");
        //sets the userid
        int userID = Integer.parseInt(this.readStringWithCondition("ProfileID", "Profile", "Email", email));
        //list to store profile id and category statistics
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Profile_ProfileID", Integer.toString(userID));
        for (int i = 1; i <= 7; i++) {
            hm.put("Category_CategoryID", Integer.toString(i));
            this.insert("Statistic", hm);
        }
    }

    /**
     * Function that is called when someone wins a game
     * @param toSave The profile to alter
     */
    public void addWin(Profile toSave) {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Wins", Integer.toString(toSave.getWins()));
        this.update("Profile", hm, "ProfileID", Integer.toString(toSave.getPid()));
    }

    /**
     * Function that is called when someone loses a game
     * @param toSave The profile to alter
     */
    public void addLoss(Profile toSave) {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("Losses", Integer.toString(toSave.getLosses()));
        this.update("Profile", hm, "ProfileID", Integer.toString(toSave.getPid()));
    }
    /**
     * Function to add an achievement to a profile
     * @param toAdd The achievement to add
     * @param aThis The profile that gained the achievement
     */
    public void storeAchievement(Achievement toAdd, Profile aThis) {
//Should have so is not implemented yet

    }
/**
 * Function to get all the rankings
 * @return A list of all the rankings in the DB
 */
    public List<Ranking> getRankings() {
        ArrayList<Ranking> rankings = new ArrayList();
        try {
            //opens the connection
            this.initConnection();
            //sets the statement
            String sql = "SELECT SUM(Score) AS Score, (SELECT Nickname FROM Profile WHERE ProfileID = Profile_ProfileID ) as Nickname FROM `GameInfo` GROUP BY Profile_ProfileID ORDER BY Score DESC";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //executes the query and puts restults in the resultset
            ResultSet rs = ps.executeQuery();
            int rank = 1;
            //loops through results and adds it to the list
            while (rs.next()) {
                Ranking add = new Ranking(rank, rs.getString(2), rs.getInt(1));
                rankings.add(add);
                rank++;
            }
            //closes the connection
            this.closeConnection();
            //returns the list
            return rankings;
        } catch (SQLException | RemoteException ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    /**
     * Function to get all the played games by a user
     * @param username is the user to get the gamehistory from
     * @return The gamehistory in the DB
     */
    public List<History> getHistory(int username) {
        ArrayList<History> history = new ArrayList();
        try {
            //opens the connection
            this.initConnection();
            //sets the statement
            String sql = "SELECT Score, Date FROM GameInfo WHERE Profile_ProfileID = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            //sets the parameter
            ps.setInt(1, username);
            //executes the query and puts restults in the resultset
            ResultSet rs = ps.executeQuery();
            //loops through the results and adds it to the list
            while (rs.next()) {
                History add = new History(rs.getTimestamp(2).toString(), rs.getInt(1));
                history.add(add);
            }
            //closes the connection
            this.closeConnection();
            //returns the list
            return history;
        } catch (SQLException | RemoteException ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    void newUserRegistration(String profile, LinkedHashMap profileData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
