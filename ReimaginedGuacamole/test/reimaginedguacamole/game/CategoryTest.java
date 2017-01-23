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
        System.out.println("Entertainment");
        Category expResult = Category.ENTERTAINMENT;
        Category result = Category.values()[3];
        assertEquals(expResult, result);
    }
    
     /**
     * Test of values method, of class Category.
     */
    @Test
    public void testValuesSport() {
        System.out.println("Sport");
        Category expResult = Category.SPORT;
        Category result = Category.values()[5];
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfHistory() {
        System.out.println("History");
        Category expResult = Category.HISTORY;
        Category result = Category.values()[0];
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfArt() {
        System.out.println("Art");
        Category expResult = Category.values()[1];
        Category  result = Category.ART;
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfGames() {
        System.out.println("Games");
        Category  expResult = Category.GAMES;
        Category  result = Category.values()[2];
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfMusic() {
        System.out.println("Music");
        Category expResult = Category.MUSIC;
        Category result = Category.values()[4];
        assertEquals(expResult, result);

    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfScience() {
        System.out.println("Science");
        Category expResult = Category.SCIENCE;
        Category result = Category.values()[6];
        assertEquals(expResult, result);
    }
    
}
