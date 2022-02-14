/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp2;

/**
 *
 * @author Nils Kimman
 */
public enum Drink {
    Cola(1.50), Beer(2.0), Water(0.75);
    public final double price;

    Drink(double price) {
        this.price = price;
    }
}
