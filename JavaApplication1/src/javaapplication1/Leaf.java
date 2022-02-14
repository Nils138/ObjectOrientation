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
public class Leaf<E> extends Node<E> {
    protected E e;
    
    public Leaf (E e, String kind) {
        super(kind);
        this.e = e;
    }
    public void accept(Visitor<E> v) {
        v.visit(this);
    }
}
