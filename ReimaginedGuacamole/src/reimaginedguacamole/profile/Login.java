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
 *
 * @author roy_v
 */
public class Login {
    MessageDigest md;

    public Login() {
        try {
            this.md = MessageDigest.getInstance("SHA-256");
            String test = "xy331GuaCam0l3";
            System.out.println("Input string: "+ test);
            byte[] result = md.digest(test.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<result.length; i++){
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println("Coded string: "+sb.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
