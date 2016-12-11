/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class QuestionTest {
    
   public QuestionTest() {
    }

    /**
     * Test of getQuestionContents method, of class Question.
     */
    @Test
    public void testGetQuestionContents() throws RemoteException {
        System.out.println("getQuestionContents");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        String expResult = "What is your name?";
        String result = instance.getQuestionContents();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer1 method, of class Question.
     */
    @Test
    public void testGetAnswer1() throws RemoteException {
        System.out.println("getAnswer1");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        String expResult = "Arthur";
        String result = instance.getAnswer1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer2 method, of class Question.
     */
    @Test
    public void testGetAnswer2() throws RemoteException {
        System.out.println("getAnswer2");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        String expResult = "Lancelot";
        String result = instance.getAnswer2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer3 method, of class Question.
     */
    @Test
    public void testGetAnswer3() throws RemoteException {
        System.out.println("getAnswer3");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        String expResult = "John";
        String result = instance.getAnswer3();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer4 method, of class Question.
     */
    @Test
    public void testGetAnswer4() throws RemoteException {
        System.out.println("getAnswer4");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        String expResult = "Jimmy";
        String result = instance.getAnswer4();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorrectAnswer method, of class Question.
     */
    @Test
    public void testGetCorrectAnswer() throws RemoteException {
        System.out.println("getCorrectAnswer");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        int expResult = 1;
        int result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class Question.
     */
    @Test
    public void testGetCategory() throws RemoteException {
        System.out.println("getCategory");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.HISTORY);
        Category expResult = Category.HISTORY;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }
    
}
