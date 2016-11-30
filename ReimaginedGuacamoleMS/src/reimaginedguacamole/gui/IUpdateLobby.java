/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reimaginedguacamole.gui;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author roy_v
 */
public interface IUpdateLobby extends Remote {
    
    public void updateGameRooms(List<String> gameRoomsData) throws RemoteException;
    
}
