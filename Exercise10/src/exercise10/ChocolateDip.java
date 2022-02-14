/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Nils Kimman s107368
 * @author Ole ten Hove s1007616
 */
public class ChocolateDip extends Topping {

    public ChocolateDip(Ice ice) {
        super(ice);
    }

    @Override
    protected String description() {
        if (ice instanceof WhippedCream) {
            return ice.description();
        }
        if (ice instanceof Topping) {
            return ice.description() + " and chocolate dip";
        }
        return ice.description() + " with chocolate dip";
    }

    @Override
    protected int price() {
        if (ice instanceof WhippedCream) {
            return ice.price();
        }
        return ice.price() + 30;
    }

}
