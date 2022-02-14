/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

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
public class SequenceTest {
    
    public SequenceTest() {
    }

    /**
     * Test of accept method, of class Sequence.
     */
    @Test
    public void testConstructor() {
        Leaf leaf1 = new Leaf<Integer>(5, "");
        Leaf leaf2 = new Leaf<Integer>(4, "");
        Sequence instance = new Sequence("", "", leaf1, leaf2);
        assertEquals(instance.getChildren().size(), 2);
        fail("Sequence list length incorrect: " + instance.getChildren().size());
    }
    
}
