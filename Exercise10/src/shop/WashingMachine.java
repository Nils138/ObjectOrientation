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
public class WashingMachine extends Item {

    public WashingMachine() {
        super("Washing machine", 499.00);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public double shippingCost() {
        return 30.00;
    }
}
