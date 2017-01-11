/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roy_v
 */
public class ChatServer extends UnicastRemoteObject implements IChatServer {

    private List<IClient> connectedProfiles = new ArrayList();

    public ChatServer() throws RemoteException {
        //Empty constcurtor to overwrihte default constructor
    }

    @Override
    public List<String> listClients() throws RemoteException {
        List<String> nicks = new ArrayList();
        for (IClient p : connectedProfiles) {
            nicks.add(p.getName());
        }
        return nicks;
    }

    @Override
    public void broadcastMessage(String message) throws RemoteException {
        Logger.getLogger(ChatServer.class.getCanonicalName()).log(Level.INFO, "New chat message sent to lobby: {0}", message);
        connectedProfiles.stream().forEach(p -> {
            try {
                p.addMessage(message);
            } catch (Exception ex) {
                Logger.getLogger(ChatServer.class.getCanonicalName()).log(Level.WARNING, "Removing person from chatlist!");
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                connectedProfiles.remove(p);
                connectedProfiles.stream().forEach(c -> {
                    try {
                        c.updatePlayerList(listClients());
                    } catch (RemoteException ex1) {
                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                });
            }
        });
    }

    @Override
    public void clientEnter(IClient client) throws RemoteException {
        connectedProfiles.add(client);
        for (IClient c : connectedProfiles) {
            c.updatePlayerList(listClients());
        }
        Logger.getLogger(ChatServer.class.getCanonicalName()).log(Level.INFO, "New client entered the lobby chatroom: {0}", client.getName());

    }

    @Override
    public synchronized void clientExit(IClient client) throws RemoteException {
        connectedProfiles.remove(client);
        for (IClient c : connectedProfiles) {
            c.updatePlayerList(listClients());
        }
        Logger.getLogger(ChatServer.class.getCanonicalName()).log(Level.INFO, "Client has left the lobby chatroom: {0}", client.getName());
    }

}
