/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import java.rmi.RemoteException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class RoundTest {
    
    public RoundTest() {
    }

    /**
     * Test of getQuestion method, of class Round.
     */
    @Test
    public void testGetQuestion() throws RemoteException {
        System.out.println("getQuestion");
        Round instance = new Round();
        Question expResult = new Question("dit","is","een","coole","vraag",1,Category.ENTERTAINMENT);
        instance.setQuestion(expResult);
        Question result = (Question) instance.getQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestion method, of class Round.
     */
    @Test
    public void testSetQuestion() throws RemoteException {
        System.out.println("setQuestion");
        Question expResult = new Question("dit","is","een","coole","vraag",1,Category.ENTERTAINMENT);
        Round instance = new Round();
        instance.setQuestion(expResult);
        assertEquals(expResult, instance.getQuestion());
    }

    /**
     * Test of setGivenAnswer method, of class Round.
     */
    @Test
    public void testSetGivenAnswer() throws RemoteException {
        System.out.println("setGivenAnswer");
        int answer = 1;
        Round instance = new Round();
        instance.setGivenAnswer(answer);
        assertEquals(1, instance.getGivenAnswer());
    }

    /**
     * Test of getGivenAnswer method, of class Round.
     */
    @Test
    public void testGetGivenAnswer() throws RemoteException {
        System.out.println("getGivenAnswer");
        Round instance = new Round();
        int expResult = 1;
        instance.setGivenAnswer(1);
        int result = instance.getGivenAnswer();
        assertEquals(expResult, result);
    }
    
}
