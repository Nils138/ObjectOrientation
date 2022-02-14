/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;

/**
 *
 * @author Nils Kimman
 */
public class Sequence<E> extends Node<E> {
    protected List<Node<E>> children;
    protected String name;
    public Sequence(String kind, List<Node<E>> children, String name) {
        super(kind);
        this.children = children;
        this.name = name;
    }
    
    public String getSName() {
        return name;
    }
    
    public List<Node<E>> getChildren() {
        return children;
    }
    
    public Sequence(String kind, String name, Node<E>... children) {
        this(kind, Arrays.asList(children), name);
    }
    
    public void accept(Visitor<E> v) {
        v.visit(this);
    }
}
