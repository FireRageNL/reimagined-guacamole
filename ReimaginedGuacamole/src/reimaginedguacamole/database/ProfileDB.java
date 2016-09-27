/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.util.ArrayList;
import java.util.List;
import reimaginedguacamole.profile.Profile;

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
        Profile ret = new Profile(results.get(1),results.get(0),results.get(2),pid,wins,losses);
        return ret;
    }

    public void saveProfileData(Profile toSave) {

    }
}
