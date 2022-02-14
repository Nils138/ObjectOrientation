/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Iterator;

/**
 *
 * @author Nils Kimman
 */
public class toStringVisitor<E> implements Visitor<E> {
    public toStringVisitor() {
        
    }

    @Override
    public void visit(Leaf<E> l) {
        System.out.println("  " + l.getName() + ": " + l.e);
    }

    @Override
    public void visit(Sequence<E> s) {
        System.out.println(s.getSName() + "  " + s.getName() + ": ");
        Iterator<Node<E>> iter = s.getChildren().iterator();
        while (iter.hasNext()) {
            iter.next().accept(this);
        }
    }
    
}
