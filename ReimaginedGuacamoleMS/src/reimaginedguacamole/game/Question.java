/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *Class that holds necessary information for a question
 * @author daan
 */
public class Question extends UnicastRemoteObject implements IQuestion {
    private String questionContents;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;
    private Category category;
    
    /**
     * Object that holds the question and its anwsers
     * @param questionContents the question itself
     * @param answer1 the first anwser
     * @param answer2 the second anwser
     * @param answer3 the third anwser
     * @param answer4 the fourht anwser
     * @param correctAnswer the correct anwser
     * @param category  the category the question belongs to
     * @throws java.rmi.RemoteException
     */
    public Question(String questionContents, String answer1, String answer2, String answer3, String answer4, int correctAnswer, Category category) throws RemoteException {
        this.questionContents = questionContents;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    @Override
    public String getQuestionContents() {
        return questionContents;
    }

    @Override
    public String getAnswer1() {
        return answer1;
    }

    @Override
    public String getAnswer2() {
        return answer2;
    }

    @Override
    public String getAnswer3() {
        return answer3;
    }

    @Override
    public String getAnswer4() {
        return answer4;
    }

    @Override
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public Category getCategory() {
        return category;
    }
    
    
    
}
