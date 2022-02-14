/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise5;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Factory {

    public static Add add(Expression value1, Expression value2) {
        return new Add(value1, value2);
    }

    public static Constant con(double value) {
        return new Constant(value);
    }

    public static Negate neg(Expression value) {
        return new Negate(value);
    }

    public static Multiply mul(Expression value1, Expression value2) {
        return new Multiply(value1, value2);
    }

    public static Variable var(String value) {
        return new Variable(value);
    }
}
