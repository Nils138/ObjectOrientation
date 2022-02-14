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
public class Generator implements Iterator<Integer> {

    private int next = 2;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return next++;
    }

}
