/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Marc
 */
public class Achievement extends UnicastRemoteObject implements IAchievement {
    
    private String description;
    private String name;
    /**
     * Default constructor for an Achievement
     * @param description the description of an achievement
     * @param name the name of an achievement
     * @throws RemoteException
     */
    public Achievement(String description, String name) throws RemoteException {
        this.description = description;
        this.name = name;
    }
        
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    

    

    
    
}
