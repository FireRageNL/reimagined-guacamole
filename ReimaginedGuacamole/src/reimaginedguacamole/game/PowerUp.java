/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

/**
 *class that holds information about the powerups.
 * @author Marc
 */
public class PowerUp {
    
    private String description;
    private String name;

    public PowerUp(String name, String description) {
        this.description = description;
        this.name = name;
    }
        
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }    
}
