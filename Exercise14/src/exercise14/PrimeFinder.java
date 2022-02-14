/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise14;

import java.util.Iterator;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class PrimeFinder implements Runnable {

    private Iterator<Integer> source;
    int prime;

    public PrimeFinder(Iterator<Integer> source, int prime) {
        this.source = source;
        this.prime = prime;
    }

    @Override
    public void run() {
        prime = source.next();
    }

    public int getPrime() {
        return prime;
    }

}
