/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.database.ProfileDB;
import reimaginedguacamole.tooling.Hashing;

/**
 * This is the class that will handle user logins.
 * @author roy_v
 */
public class Login {

    private MessageDigest md;

    /**
     * Simple tryLogin function that will try to login a user with the provided username and password
     * It will hash the password, compare the hash to the hash in the database and then return
     * true or false according to if the username -> hash combination is correct
     * @param email is the e-mail adress of the user that is to be checked
     * @param password is the password in plain text to be checked
     * @return true or false if combination is correct.
     */
    public boolean tryLogin(String email, String password) {

            ProfileDB pdb = new ProfileDB();
            return pdb.login(Hashing.hashPassword(password),email);
    }
}
