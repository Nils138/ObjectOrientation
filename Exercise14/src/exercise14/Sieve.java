package exercise14;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */

import java.util.Iterator;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
class Sieve implements Iterator<Integer> {

    private int prime;
    private Iterator<Integer> source;

    public Sieve(int prime, Iterator<Integer> generator) {
        this.prime = prime;
        this.source = generator;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int next = source.next();
        while (next % prime == 0) {
            next = source.next();
        }
        return next;
    }
}
