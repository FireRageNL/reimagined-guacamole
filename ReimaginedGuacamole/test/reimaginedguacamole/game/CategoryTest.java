/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reimaginedguacamole.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class CategoryTest {
    
    public CategoryTest() {
    }
    
    /**
     * Test of values method, of class Category.
     */
    @Test
    public void testValuesEntertaintment() {
        System.out.println("values");
        Category expResult = Category.Entertainment;
        Category result = Category.values()[3];
        assertEquals(expResult, result);
    }
    
     /**
     * Test of values method, of class Category.
     */
    @Test
    public void testValuesSport() {
        System.out.println("values");
        Category expResult = Category.Sport;
        Category result = Category.values()[5];
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfHistory() {
        System.out.println("valueOf");
        String expResult = "Geschiedenis";
        Category.valueOf("History");
        String result = Category.History.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfArt() {
        System.out.println("valueOf");
        String expResult = "Kunst";
        Category.valueOf("Art");
        String result = Category.Art.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfGames() {
        System.out.println("valueOf");
        String expResult = "Spellen";
        Category.valueOf("Games");
        String result = Category.Games.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfMusic() {
        System.out.println("valueOf");
        String expResult = "Muziek";
        Category.valueOf("Music");
        String result = Category.Music.toString();
        assertEquals(expResult, result);

    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfScience() {
        System.out.println("valueOf");
        String expResult = "Wetenschap";
        Category.valueOf("Science");
        String result = Category.Science.toString();
        assertEquals(expResult, result);
    }
    
}
