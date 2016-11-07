/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrition.app;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mitch
 */
public class MealTest {
    
    public MealTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLocation method, of class Meal.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Meal instance = null;
        Venue expResult = null;
        Venue result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Meal.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        Venue location = null;
        Meal instance = null;
        instance.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Meal.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Meal instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Meal.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Meal instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMealEntries method, of class Meal.
     */
    @Test
    public void testGetMealEntries() {
        System.out.println("getMealEntries");
        int index = 0;
        Meal instance = null;
        List<MealEntry> expResult = null;
        List<MealEntry> result = instance.getMealEntries(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
