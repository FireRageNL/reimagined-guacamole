/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

/**
 *
 * @author Marc
 */
public class Achievement {
    
    private String description;
    private String name;
    /**
     * Default constructor for an Achievement
     * @param description the description of an achievement
     * @param name the name of an achievement
     */
    public Achievement(String description, String name) {
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
