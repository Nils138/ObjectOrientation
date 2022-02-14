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
public class WhippedCream extends Topping {

    public WhippedCream(Ice ice) {
        super(ice);
    }

    @Override
    protected String description() {
        if (ice instanceof Topping) {
            return ice.description() + " and whipped cream";
        }
        return ice.description() + " with whipped cream";
    }

    @Override
    protected int price() {
        return ice.price() + 50;
    }

}
