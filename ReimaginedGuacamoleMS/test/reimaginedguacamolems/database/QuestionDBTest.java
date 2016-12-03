/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamolems.database;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import reimaginedguacamole.game.IQuestion;
import reimaginedguacamole.game.Question;

/**
 *
 * @author Jorrit
 */
public class QuestionDBTest {
    
    public QuestionDBTest() {
    }

    /**
     * Test of getQuestions method, of class QuestionDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testGetQuestions_int() throws RemoteException {
        System.out.println("getQuestions");
        int amount = 10;
        QuestionDB instance = new QuestionDB();
        List<IQuestion> result = instance.getQuestions(amount);
        assertEquals(70,result.size());
    }

    /**
     * Test of getSingleQuestion method, of class QuestionDB.
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testGetSingleQuestion() throws RemoteException {
        System.out.println("GetSingleQuestion");
        String QuestionID = "52";
        QuestionDB instance = new QuestionDB();
        Question result = (Question) instance.getSingleQuestion(QuestionID);
        assertEquals("Geschiedenis", result.getCategory().toString());
        assertEquals("In welk jaar was de slag bij Waterloo?", result.getQuestionContents());
        assertEquals("1789", result.getAnswer1());
        assertEquals("1800", result.getAnswer2());
        assertEquals("1812", result.getAnswer3());
        assertEquals("1815", result.getAnswer4());
        assertEquals(4, result.getCorrectAnswer());
    }

    /**
     * Test of GetQuestions method, of class QuestionDB.
     */
    @Test
    public void testGetQuestions_List() throws RemoteException {
        System.out.println("GetQuestions");
        List<String> QuestionIDs = new ArrayList<>(Arrays.asList("52","53"));
        QuestionDB instance = new QuestionDB();
        List<Question> expResult = new ArrayList<>();
        expResult.add((Question) instance.getSingleQuestion("52"));
        expResult.add((Question) instance.getSingleQuestion("53"));
        List<IQuestion> result = instance.getQuestions(QuestionIDs);
        assertEquals(result.get(0).getQuestionContents(),expResult.get(0).getQuestionContents());
        assertEquals(result.get(1).getQuestionContents(),expResult.get(1).getQuestionContents());
    }

    /**
     * Test of GetQuestionsCategory method, of class QuestionDB.
     */
    @Test
    public void testGetQuestionsCategory() {
        System.out.println("GetQuestionsCategory");
        int amount = 10;
        QuestionDB instance = new QuestionDB();
        List<String> result = instance.getQuestionsCategory(amount);
        assertEquals(result.size(), 70);
    }
    
}
