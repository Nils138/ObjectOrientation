/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.List;

/**
 *
 * @author Nils Kimman s107368
 * @author Ole ten Hove s1007616
 */
public class ShoppingCart implements Visitable {

    protected List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public double totalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
            totalPrice += item.shippingCost();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        items.forEach(item -> output.append(item).append("\n"));
        return output.toString();
    }

    public boolean pay(double amount) {
        System.out.println(amount + " to be payed via: ");
        return true;
    }
}
