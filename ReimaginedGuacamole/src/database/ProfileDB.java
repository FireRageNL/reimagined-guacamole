/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *Class that handles all databaserequests for a user's profile
 * @author daan
 */
public class ProfileDB {
    
    /**
     * checks if a user can login with the provided credentials
     * @param Email
     * @param Password
     * @return true when user can be logged in, else false.
     */
    public boolean login(String Email, String Password){
        return false;
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
