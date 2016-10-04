/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.game.Question;

/**Class which handles all databaserequests for the Question class
 *
 * @author daan
 */
public class QuestionDB extends Database {
    
    /**
     * gets a set amount of questions from the database 
     * @param amount
     * @return List of Question objects
     */
    public List<Question> getQuestions(int amount){
        List<Question> Questions = new ArrayList<>();
        for (String questionID : GetQuestionsCategory(amount)) {
             Questions.add(GetQuestion(questionID));
        }
        return Questions;
    }
    
    public Question GetQuestion(String QuestionID){
        List<String> Data = new ArrayList<>(Arrays.asList("Question","Answer1","Answer2","Answer3","Answer4","CorrectAnswer","Category_CategoryID"));
        List<String> QuestionContent = this.ReadStringWithCondition(Data, "Question", "QuestionID", QuestionID);
        Question q = new Question(QuestionContent.get(0),QuestionContent.get(1),QuestionContent.get(2),QuestionContent.get(3),QuestionContent.get(4),Integer.parseInt(QuestionContent.get(5)),(Category.values()[(Integer.parseInt(QuestionContent.get(6))-1)]));
        return q;
    }
    
    public List<String> GetQuestionsCategory(int amount){
        List<String> idsToReturn = new ArrayList<>();
        Random rn = new Random();
         
        for (int i = 1; i <= 7; i++) {
             List<String> Data = new ArrayList<>(Arrays.asList("QuestionID"));
             List<String> QuestionContent = this.ReadStringWithCondition(Data, "Question", "Category_CategoryID",(Integer.toString(i)));
             
             for (int j = 1; j <= amount; j++) {
             int id = rn.nextInt(QuestionContent.size());
             idsToReturn.add(QuestionContent.get(id));
             }   
        }
        return idsToReturn;
    }
    
    
}
