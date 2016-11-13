/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrition.app;

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
public class NutrientTest {
    
    public NutrientTest() {
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
     * Test of getName method, of class Nutrient.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Nutrient instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Nutrient.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Nutrient instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnit method, of class Nutrient.
     */
    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        Nutrient instance = null;
        String expResult = "";
        String result = instance.getUnit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnit method, of class Nutrient.
     */
    @Test
    public void testSetUnit() {
        System.out.println("setUnit");
        String unit = "";
        Nutrient instance = null;
        instance.setUnit(unit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Nutrient.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Nutrient instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Nutrient.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Nutrient instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Nutrient.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Nutrient instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
