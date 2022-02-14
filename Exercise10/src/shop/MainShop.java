/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nils Kimman s107368
 * @author Ole ten Hove s1007616
 */
public class MainShop {

    public static void main(String[] args) {
        List<Item> items = new LinkedList<>();
        ShoppingCart cart = new ShoppingCart(items);
        cart.add(new Watermelon());
        cart.add(new WineGlass());
        cart.add(new WashingMachine());
        System.out.println(cart);
        System.out.println(cart.totalPrice());
    }
}
