/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise8.polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class PolynomialTest {
    
    public PolynomialTest() {
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
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String input = "1 0 3 2";
        Polynomial instance = new Polynomial(input);
        String expResult = "1,000000 + 3,000000x^2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial b = new Polynomial("1 0 3 2");
        Polynomial instance = new Polynomial("-1 0 -3 2");
        instance.plus(b);
        assertEquals(instance.toString(), "0");
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = new Polynomial("1 0 3 2");
        Polynomial instance = new Polynomial(b);
        instance.minus(b);
        assertEquals(instance.toString(), "0");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = new Polynomial("1 0 3 2");
        Polynomial instance = new Polynomial();
        instance.times(b);
        assertEquals(instance.toString(), "0");
    }

    /**
     * Test of divide method, of class Polynomial.
     * Doesn't work properly: only counts exponents
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = new Polynomial("3 4");
        Polynomial instance = new Polynomial("3 2");
        Polynomial expResult = new Polynomial("1 2");
        Polynomial result = instance.divide(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = new Polynomial("1 2 3 4");
        Polynomial instance = new Polynomial("1 2 3 4");
        boolean expResult = true;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
    }
    
}
