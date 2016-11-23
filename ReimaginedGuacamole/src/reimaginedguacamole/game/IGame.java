/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import reimaginedguacamole.profile.IProfile;

/**
 *
 * @author Marc
 */
public interface IGame extends Remote {

    public List<IQuestion> getQuestionsList() throws RemoteException;

    public int getRoundDuration() throws RemoteException;

    public void setRoundDuration(int roundDuration) throws RemoteException;

    public void setAmountOfRounds(int amount) throws RemoteException;

    public int getAmountOfRounds() throws RemoteException;

    public void updateStats(IProfile prof, Category cat, boolean right) throws RemoteException;
    
    public void endGame(int userID, int score) throws RemoteException;
}
