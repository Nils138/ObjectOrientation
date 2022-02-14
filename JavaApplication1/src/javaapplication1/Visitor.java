/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Nils Kimman
 */
public interface Visitor<E> {
    public void visit(Leaf<E> l);
    public void visit(Sequence<E> s);
}
