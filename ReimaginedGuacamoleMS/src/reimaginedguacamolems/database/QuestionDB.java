/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

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
        List<Question> Questions = GetQuestions(GetQuestionsCategory(amount));
        return Questions;
    }
    //gets a single question 
    public Question GetSingleQuestion(String QuestionID){
        //sets the data to get
        List<String> Data = new ArrayList<>(Arrays.asList("Question","Answer1","Answer2","Answer3","Answer4","CorrectAnswer","Category_CategoryID"));
       //gets the question by id
        List<String> QuestionContent = this.ReadStringWithCondition(Data, "Question", "QuestionID", QuestionID);
        //makes the question
        Question q = new Question(QuestionContent.get(0),QuestionContent.get(1),QuestionContent.get(2),QuestionContent.get(3),QuestionContent.get(4),Integer.parseInt(QuestionContent.get(5)),(Category.values()[(Integer.parseInt(QuestionContent.get(6))-1)]));
        //returns the question
        return q;
    }
    //gets list of questions by question id's
    public List<Question> GetQuestions(List<String> QuestionIDs){
        //list of questions
        List<Question> Questions = new ArrayList<>();
        //sets the data to get
        List<String> Data = new ArrayList<>(Arrays.asList("Question","Answer1","Answer2","Answer3","Answer4","CorrectAnswer","Category_CategoryID"));
        //gets the questions content by ids
        List<String> QuestionContent = this.ReadWithInCondition(Data, "Question", "QuestionID", QuestionIDs,QuestionIDs.size());
        //loops through results and makes the questions
        for (int i = 0; i < QuestionContent.size(); i+=7) {
             Questions.add(new Question(QuestionContent.get(i),QuestionContent.get(i+1),QuestionContent.get(i+2),QuestionContent.get(i+3),QuestionContent.get(i+4),Integer.parseInt(QuestionContent.get(i+5)),(Category.values()[(Integer.parseInt(QuestionContent.get(i+6))-1)])));
        } 
        //returns the questions
        return Questions;
    }
    
    //gets the id of the questions for each category
    public List<String> GetQuestionsCategory(int amount){
        List<String> idsToReturn = new ArrayList<>();
        //randomizer
        Random rn = new Random();
         //loops for each category
        for (int i = 1; i <= 7; i++) {
            //creates a list with questionID as content
             List<String> Data = new ArrayList<>(Arrays.asList("QuestionID"));
             //list that contains all questions for the current category
             List<String> QuestionContent = this.ReadStringWithCondition(Data, "Question", "Category_CategoryID",(Integer.toString(i)));
             //loops for the amount of questions wanted
             for (int j = 1; j <= amount; j++) {
                 //selects random id from the list
                 int id = rn.nextInt(QuestionContent.size());
                 //if list already contains the question it gets another one
                 while(idsToReturn.contains(QuestionContent.get(id))) {
                     id = rn.nextInt(QuestionContent.size());
                 }
                 //adds the id to the list
                 idsToReturn.add(QuestionContent.get(id));
             }   
        }//returns the list with question ids
        return idsToReturn;
    }
    
    
}
