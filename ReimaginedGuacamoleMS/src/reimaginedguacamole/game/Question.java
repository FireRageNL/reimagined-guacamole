/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

/**
 *Class that holds necessary information for a question
 * @author daan
 */
public class Question {
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
     */
    public Question(String questionContents, String answer1, String answer2, String answer3, String answer4, int correctAnswer, Category category) {
        this.questionContents = questionContents;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    public String getQuestionContents() {
        return questionContents;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public Category getCategory() {
        return category;
    }
    
    
    
}
