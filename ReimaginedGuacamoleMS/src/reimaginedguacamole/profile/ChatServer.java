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
    
    public ChatServer() throws RemoteException{
        
    }
    
    @Override
    public List<String> listClients() throws RemoteException {
        List<String> nicks = new ArrayList();
        for(IClient p : connectedProfiles){
            nicks.add(p.getName());
        }
        return nicks;
    }

    @Override
    public void broadcastMessage(String message) throws RemoteException {
        Logger.getLogger(ChatServer.class.getCanonicalName()).log(Level.INFO,"New chat message sent to lobby: "+ message);
        for(IClient p: connectedProfiles){
           p.addMessage(message);
        }
    }

    @Override
    public void clientEnter(IClient client) throws RemoteException {
        connectedProfiles.add(client);
    }

    @Override
    public void clientExit(IClient client) throws RemoteException {
        connectedProfiles.remove(client);
    }
    
}
