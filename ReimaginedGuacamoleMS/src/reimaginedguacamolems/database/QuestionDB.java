/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import reimaginedguacamole.game.Category;
import reimaginedguacamole.game.IQuestion;
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
    public List<IQuestion> getQuestions(int amount) throws RemoteException{
        return getQuestions(getQuestionsCategory(amount));
    }
    /**
     * Get a single question from the database
     * @param questionID The ID of the question to get
     * @return the question retrieved from the database
     */
    public IQuestion getSingleQuestion(String questionID) throws RemoteException{
        //sets the data to get
        List<String> data = new ArrayList<>(Arrays.asList("Question","Answer1","Answer2","Answer3","Answer4","CorrectAnswer","Category_CategoryID"));
       //gets the question by id
        List<String> questionContent = this.readStringWithCondition(data, "Question", "QuestionID", questionID);
        //makes the question and returns it
        return new Question(questionContent.get(0),questionContent.get(1),questionContent.get(2),questionContent.get(3),questionContent.get(4),Integer.parseInt(questionContent.get(5)),Category.values()[Integer.parseInt(questionContent.get(6))-1]);
    }
    /**
     * Get a list of questions by QuestionID's
     * @param questionIDs to retrieve from the database
     * @return The list of questions retrieved from the database
     */
    public List<IQuestion> getQuestions(List<String> questionIDs) throws RemoteException{
        //list of questions
        List<IQuestion> questions = new ArrayList<>();
        //sets the data to get
        List<String> data = new ArrayList<>(Arrays.asList("Question","Answer1","Answer2","Answer3","Answer4","CorrectAnswer","Category_CategoryID"));
        //gets the questions content by ids
        List<String> questionContent = this.readWithInCondition(data, "Question", "QuestionID", questionIDs,questionIDs.size());
        //loops through results and makes the questions
        for (int i = 0; i < questionContent.size(); i+=7) {
             questions.add(new Question(questionContent.get(i),questionContent.get(i+1),questionContent.get(i+2),questionContent.get(i+3),questionContent.get(i+4),Integer.parseInt(questionContent.get(i+5)),Category.values()[Integer.parseInt(questionContent.get(i+6))-1]));
        } 
        //returns the questions
        long seed = System.nanoTime();
        Collections.shuffle(questions,new Random(seed));
        return questions;
    }
    
    /**
     * Gets a list of ID's for all the questions per category
     * @param amount The amount of questions per category to get
     * @return a list of questionID's
     */
    public List<String> getQuestionsCategory(int amount){
        List<String> idsToReturn = new ArrayList<>();
        //randomizer
        Random rn = new Random();
         //loops for each category
        for (int i = 1; i <= 7; i++) {
            //creates a list with questionID as content
             List<String> data = new ArrayList<>(Arrays.asList("QuestionID"));
             //list that contains all questions for the current category
             List<String> questionContent = this.readStringWithCondition(data, "Question", "Category_CategoryID",Integer.toString(i));
             //loops for the amount of questions wanted
             for (int j = 1; j <= amount; j++) {
                 //selects random id from the list
                 int id = rn.nextInt(questionContent.size());
                 //if list already contains the question it gets another one
                 while(idsToReturn.contains(questionContent.get(id))) {
                     id = rn.nextInt(questionContent.size());
                 }
                 //adds the id to the list
                 idsToReturn.add(questionContent.get(id));
             }   
        }//returns the list with question ids
        return idsToReturn;
    }
    
    
}
