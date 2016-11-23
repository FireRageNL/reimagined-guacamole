/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class which contains the information about the current round
 *
 * @author daan
 */
public class Round extends UnicastRemoteObject implements IRound {

    private Question question;
    private int givenAnswer;

    public Round() throws RemoteException{

    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(Question question) {
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
}
