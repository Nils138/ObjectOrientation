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
public class Negate extends SingleArgument {

    public Negate(Expression value) {
        super(value);
    }
    @Override
    public String toString() {
        return value1.toString();
    }

    @Override
    public Expression pe() {
        if (value1 instanceof Constant) {
            return new Constant(Double.parseDouble(value1.toString()) * -1);
        }
        if (value1 instanceof Variable || value1 instanceof Add || value1 instanceof Multiply) {
            return new Variable("-" + value1.pe());
        }
        return this;
    }
    
    @Override
    public double eval(Map<String, Double> store){
        return store.get(this.toString());
    }
}
