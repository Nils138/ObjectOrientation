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
public abstract class Node<E> {

    private String kind;

    public String getName() {
        return kind;
    }
    public abstract void accept(Visitor<E> v);
    
    public Node(String kind) {
        this.kind = kind;
    }
}
