/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roy_v
 */
public class QuestionTest {
    
    public QuestionTest() {
    }

    /**
     * Test of getQuestionContents method, of class Question.
     */
    @Test
    public void testGetQuestionContents() {
        System.out.println("getQuestionContents");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        String expResult = "What is your name?";
        String result = instance.getQuestionContents();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer1 method, of class Question.
     */
    @Test
    public void testGetAnswer1() {
        System.out.println("getAnswer1");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        String expResult = "Arthur";
        String result = instance.getAnswer1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer2 method, of class Question.
     */
    @Test
    public void testGetAnswer2() {
        System.out.println("getAnswer2");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        String expResult = "Lancelot";
        String result = instance.getAnswer2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer3 method, of class Question.
     */
    @Test
    public void testGetAnswer3() {
        System.out.println("getAnswer3");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        String expResult = "John";
        String result = instance.getAnswer3();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswer4 method, of class Question.
     */
    @Test
    public void testGetAnswer4() {
        System.out.println("getAnswer4");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        String expResult = "Jimmy";
        String result = instance.getAnswer4();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCorrectAnswer method, of class Question.
     */
    @Test
    public void testGetCorrectAnswer() {
        System.out.println("getCorrectAnswer");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        int expResult = 1;
        int result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class Question.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Question instance = new Question("What is your name?","Arthur","Lancelot","John","Jimmy",1,Category.History);
        Category expResult = Category.History;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }
    
}
