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
 * @author Marc
 */
public interface IRound extends Remote{
    public IQuestion getQuestion()throws RemoteException;
    public void setQuestion(IQuestion question)throws RemoteException;
    public void setGivenAnswer(int answer)throws RemoteException;
    public int getGivenAnswer()throws RemoteException;
    public IRound createRound() throws RemoteException;
}
