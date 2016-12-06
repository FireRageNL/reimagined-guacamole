/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import reimaginedguacamole.gui.FXMLController;

/**
 *
 * @author roy_v
 */
public class Client extends UnicastRemoteObject implements IClient {

    private String name;
    private IChatServer server;
    private ObservableList<String> chat;
    private FXMLController application;

    /**
     * Constructor for a client of the chatserver
     *
     * @param prof the profile to get the nickname for
     * @param chat the list where all the chat messages will be added
     * @throws RemoteException
     */
    public Client(IProfile prof, ObservableList<String> chat,FXMLController app) throws RemoteException {
        try {
            this.chat = chat;
            this.name = prof.getNickname();
            Registry reg2 = LocateRegistry.getRegistry("192.168.1.106", 666);
            server = (IChatServer) reg2.lookup("ChatServer");
            server.clientEnter(this);
            application = app;
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        String msg = this.name + ": " + message;
        server.broadcastMessage(msg);
    }

    @Override
    public void addMessage(String message) throws RemoteException {
        class ChatRunnable implements Runnable {

            ObservableList<String> chat;

            ChatRunnable(ObservableList<String> chat) {
                this.chat = chat;
            }

            @Override
            public void run() {
                this.chat.add(message);
            }
        }
        Platform.runLater(new ChatRunnable(chat));

    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void leaveChatroom() throws RemoteException {
        server.clientExit(this);
    }

    @Override
    public void updatePlayerList(List<String> playerData) throws RemoteException {
        Platform.runLater(() ->{
            application.updatePlayerList(playerData);
        });
    }

    @Override
    public void enterChatroom() throws RemoteException {
        server.clientEnter(this);
    }
}
