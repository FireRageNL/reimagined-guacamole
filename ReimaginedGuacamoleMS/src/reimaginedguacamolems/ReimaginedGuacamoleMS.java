/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems;

import java.sql.SQLException;
import java.util.List;
import reimaginedguacamole.database.*;
import reimaginedguacamole.game.Question;



/**
 *
 * @author roy_v
 */
public class ReimaginedGuacamoleMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("Pulling random questions from db to test if code works");
        QuestionDB db = new QuestionDB();
        try{
            List<String> list = db.GetQuestionsCategory(5);
            List<Question> properList = db.GetQuestions(list);
            properList.stream().forEach((s) -> {
                System.out.println(s.getQuestionContents());
            });
        }
        catch(Exception ex) {
            System.out.println("It errored"+ ex.getMessage());
        }
    }
    
}