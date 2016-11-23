/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *class that holds information about the powerups.
 * @author Marc
 */
public class PowerUp extends UnicastRemoteObject implements IPowerUp{
    
    private String description;
    private String name;

    /**
     *
     * @param name
     * @param description
     */
    public PowerUp(String name, String description) throws RemoteException{
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
