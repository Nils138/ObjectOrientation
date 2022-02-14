/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise8.polynomial;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils Kimman
 */
public class TermTest {

    public TermTest() {
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
     * Test of getExp method, of class Term.
     */
    @Test
    public void testGetExp() {
        System.out.println("getExp");
        Term instance = new Term(3, 2);
        int expResult = 2;
        int result = instance.getExp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCoef method, of class Term.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        Term instance = new Term(3, 2);
        double expResult = 3.0;
        double result = instance.getCoef();
        assertEquals(expResult, result, 3.0);
    }

    /**
     * Test of plus method, of class Term.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Term t = new Term(3, 2);
        Term instance = new Term(-3, 2);
        instance.plus(t);
        assertEquals(instance, new Term(0, 0));
    }

    /**
     * Test of times method, of class Term.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Term t = new Term(2, 5);
        Term instance = new Term(0, 0);
        instance.times(t);
        assertEquals(instance, new Term(0,0));
    }

    /**
     * Test of neg method, of class Term.
     */
    @Test
    public void testNeg() {
        System.out.println("neg");
        Term instance = new Term(3, 2);
        instance.neg();
        assertEquals(instance, new Term(-3, 2));
    }

    /**
     * Test of divide method, of class Term.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Term t = new Term(3, 2);
        Term instance = new Term(3, 4);
        instance.divide(t);
        assertEquals(instance, new Term(1, 2));
    }

    /**
     * Test of toString method, of class Term.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Term instance = new Term(3, 2);
        String expResult = "3,000000x^2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Term.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object may_be_term = new Term(3, 2);
        Term instance = new Term(3, 2);
        boolean expResult = true;
        boolean result = instance.equals(may_be_term);
        assertEquals(expResult, result);
    }

    /**
     * Test of scanTerm method, of class Term.
     */
    @Test
    public void testScanTerm() {
        System.out.println("scanTerm");
        Scanner s = new Scanner("3 2");
        Term expResult = new Term(3, 2);
        Term result = Term.scanTerm(s);
        assertEquals(expResult, result);
    }

}
