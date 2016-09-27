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
     * @param input is the password that has to be hashed,
     * @return is the hash that gets generated
     */
    public String tryLogin(String input) {
        try {
            this.md = MessageDigest.getInstance("SHA-256");
            String test = input;
            byte[] result = md.digest(test.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
