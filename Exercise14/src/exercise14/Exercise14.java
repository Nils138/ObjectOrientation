/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package exercise14;

import java.util.*;

/**
 *
 * @author Nils Kimman s1007368
 *
 * First 20 prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
 * 47, 53, 59, 61, 67, 71
 */
public class Exercise14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer(2);
        Iterator<Integer> source = new Generator();
        int prime = 2;
        System.out.println(1 + ": " + prime);
        for (int i = 1; i < 100; i++) {
            source = new Sieve(prime, source);
            PrimeFinder finder = new PrimeFinder(source, prime);
            Thread thread = new Thread(finder);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted: " + i);
            }
            prime = finder.getPrime();
            System.out.println(i + 1 + ": " + prime);
        }
    }

}
