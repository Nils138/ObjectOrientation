package exercise5;

import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Constant extends NoArguments {

    private double constant;

    public Constant(double constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return Double.toString(constant);
    }

    /**
     * optimizes the constant (which is already optimal)
     *
     * @return the same object
     */
    @Override
    public Expression pe() {
        return this;
    }

    /**
     * evaluates function
     *
     * @param store
     * @return store item
     */
    @Override
    public double eval(Map<String, Double> store) {
        return store.get(this.toString());
    }

}
