/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.IQuestion;
import reimaginedguacamole.game.IRound;

/**
 * Class which contains the information about the current round
 *
 * @author daan
 */
public class Round extends UnicastRemoteObject implements IRound {

    private IQuestion question;
    private int givenAnswer;

    public Round() throws RemoteException {
        //Empty constcurtor to overwrihte default constructor

    }

    @Override
    public IQuestion getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(IQuestion question) {
        this.question = question;
    }

    @Override
    public void setGivenAnswer(int answer) {
        this.givenAnswer = answer;
    }

    @Override
    public int getGivenAnswer() {
        return givenAnswer;
    }

    @Override
    public IRound createRound() throws RemoteException {
        Logger.getLogger(Round.class.getCanonicalName()).log(Level.INFO, "ROUND ADDED!");
        return new Round();
    }
}
