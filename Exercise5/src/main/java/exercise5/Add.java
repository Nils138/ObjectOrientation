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
public class Add extends MultipleArguments {

    public Add(Expression value1, Expression value2) {
        super(value1, value2);
    }

    @Override
    public String toString() {
        return "(" + value1.toString() + " + " + value2.toString() + ")";
    }

    /**
     * optimizes function: x + 0 = 0, x + y = o (with o = x + y) for constants
     *
     * @return optimized expression
     */
    @Override
    public Expression pe() {
        value1 = value1.pe();
        value2 = value2.pe();
        if (value1 instanceof Constant) {
            if ((Double.parseDouble(value1.toString())) == 0) {
                return value2;
            }
            if (value2 instanceof Constant) { //if both constants
                return new Constant(Double.parseDouble(value1.toString()) + (Double.parseDouble(value2.toString())));
            }
        }
        if (value2 instanceof Constant) {
            if ((Double.parseDouble(value2.toString())) == 0) {
                return value1;
            }
        }
        return this;
    }

    /**
     * evaluates function based on expression types
     *
     * @param store
     * @return evaluated sub-function
     */
    @Override
    public double eval(Map<String, Double> store) {
        if (value1 instanceof Variable) {
            return value1.eval(store);
        }
        if (value2 instanceof Variable) {
            return value2.eval(store);
        }
        if (value1 instanceof Multiply || value1 instanceof Add) {
            return value1.eval(store);
        }
        if (value2 instanceof Multiply || value2 instanceof Add) {
            return value1.eval(store);
        }
        return 0;
    }
}
