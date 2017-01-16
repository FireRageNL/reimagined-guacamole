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
 * @author Jorrit
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
        Category expResult = Category.ENTERTAINMENT;
        Category result = Category.values()[3];
        assertEquals(expResult, result);
    }
    
     /**
     * Test of values method, of class Category.
     */
    @Test
    public void testValuesSport() {
        System.out.println("values");
        Category expResult = Category.SPORT;
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
        Category.valueOf("HISTORY");
        String result = Category.HISTORY.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfArt() {
        System.out.println("valueOf");
        String expResult = "Kunst";
        Category.valueOf("ART");
        String result = Category.ART.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfGames() {
        System.out.println("valueOf");
        String expResult = "Spellen";
        Category.valueOf("GAMES");
        String result = Category.GAMES.toString();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfMusic() {
        System.out.println("valueOf");
        String expResult = "Muziek";
        Category.valueOf("MUSIC");
        String result = Category.MUSIC.toString();
        assertEquals(expResult, result);

    }
    
     /**
     * Test of valueOf method, of class Category.
     */
    @Test
    public void testValueOfScience() {
        System.out.println("valueOf");
        String expResult = "Wetenschap";
        Category.valueOf("SCIENCE");
        String result = Category.SCIENCE.toString();
        assertEquals(expResult, result);
    }
}
