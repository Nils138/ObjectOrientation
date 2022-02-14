/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

/**
 *
 * @author Nils Kimman s107368
 * @author Ole ten Hove s1007616
 */
public interface Visitor {

    void visit(Watermelon watermelon);

    void visit(WineGlass wineglass);

    void visit(WashingMachine washingMachine);

    default void visit(ShoppingCart shoppingCart) {
        for (Item i : shoppingCart.getItems()) {
            i.accept(this);
        }
    }
}
