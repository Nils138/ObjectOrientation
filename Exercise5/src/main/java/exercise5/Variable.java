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
public class Variable extends NoArguments {

    private String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public Expression pe() {
        return this;
    }

    @Override
    public double eval(Map<String, Double> store) {
        return store.get(this.toString());
    }
}
