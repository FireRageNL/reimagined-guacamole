/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems;

import reimaginedguacamolems.database.QuestionDB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reimaginedguacamole.game.Question;

/**
 *
 * @author roy_v
 */
public class ReimaginedGuacamoleMS {

    private ReimaginedGuacamoleMS() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Pulling random questions from db to test if code works");
        QuestionDB db = new QuestionDB();
        try {
            List<String> list = db.GetQuestionsCategory(5);
            List<Question> properList = db.GetQuestions(list);
            properList.stream().forEach((s) -> {
                System.out.println(s.getQuestionContents());
            });
        } catch (Exception ex) {
            Logger.getLogger(ReimaginedGuacamoleMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
