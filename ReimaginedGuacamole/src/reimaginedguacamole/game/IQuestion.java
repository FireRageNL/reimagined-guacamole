/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author roy_v
 */
public interface IQuestion extends Remote {

    public String getQuestionContents() throws RemoteException;

    public String getAnswer1() throws RemoteException;

    public String getAnswer2() throws RemoteException;

    public String getAnswer3() throws RemoteException;

    public String getAnswer4() throws RemoteException;

    public int getCorrectAnswer() throws RemoteException;

    public Category getCategory() throws RemoteException;

}
