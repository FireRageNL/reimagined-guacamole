/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import reimaginedguacamole.profile.Profile;

/**
 *Class that handles all databaserequests for a user's profile
 * @author daan
 */
public class ProfileDB extends Database {
    
    /**
     * checks if a user can login with the provided credentials
     * @param email
     * @param password
     * @return true when user can be logged in, else false.
     */
    public boolean login(String email, String password){
        String dbPassword = this.ReadStringWithCondition("Password","Profile","Email",email);
        return password.equals(dbPassword);
    }
    
    public void register(String email, String password, String username, String name){
        //DO NOTHING
    }
    /**
     * Gets profile data based on username
     * @return Profile object
     */
    public Profile getProfileData(String username){
        return null;
    }
    
    public void saveProfileData(Profile toSave){
        
    }
}
