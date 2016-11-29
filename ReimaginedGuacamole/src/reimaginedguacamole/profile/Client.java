/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author roy_v
 */
public class Client extends UnicastRemoteObject implements IClient {

    private String name;
    private IChatServer server;
    private ObservableList<String> lobbyChat;
    
    

    public Client(IProfile prof, ObservableList<String> lobbyChat) throws RemoteException{
        try {
            this.lobbyChat = lobbyChat;
            this.name = prof.getNickname();
            Registry reg2 = LocateRegistry.getRegistry("127.0.0.1", 666);
            server = (IChatServer) reg2.lookup("ChatServer");
            server.clientEnter(this);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        String msg = this.name + ": "+ message;
        server.broadcastMessage(msg);
    }

    @Override
    public void addMessage(String message) throws RemoteException {
        this.lobbyChat.add(message);
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

}
