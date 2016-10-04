/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.profile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reimaginedguacamole.game.Category;

/**
 *
 * @author roy_v
 */
public class StatisticTest {
    
    public StatisticTest() {
    }
    

    /**
     * Test of getCategory method, of class Statistic.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Statistic instance = new Statistic(Category.Art,10,20);
        Category expResult = Category.Art;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRight method, of class Statistic.
     */
    @Test
    public void testGetRight() {
        System.out.println("getRight");
        Statistic instance = new Statistic(Category.Art,10,20);
        int expResult = 10;
        int result = instance.getRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRight method, of class Statistic.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        int right = 20;
        Statistic instance = new Statistic(Category.Art,10,20);
        instance.setRight(right);
        assertEquals(right,instance.getRight());
    }

    /**
     * Test of getWrong method, of class Statistic.
     */
    @Test
    public void testGetWrong() {
        System.out.println("getWrong");
        Statistic instance = new Statistic(Category.Art,10,20);
        int expResult = 20;
        int result = instance.getWrong();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWrong method, of class Statistic.
     */
    @Test
    public void testSetWrong() {
        System.out.println("setWrong");
        int wrong = 30;
        Statistic instance = new Statistic(Category.Art,10,20);
        instance.setWrong(wrong);
        assertEquals(wrong,instance.getWrong());
    }

    /**
     * Test of returnPercenntage method, of class Statistic.
     */
    @Test
    public void testReturnPercenntage() {
        System.out.println("returnPercenntage");
        Statistic instance = new Statistic(Category.Art,20,20);
        int expResult = 50;
        int result = instance.returnPercentage();
        assertEquals(expResult, result);
    }
    
}
