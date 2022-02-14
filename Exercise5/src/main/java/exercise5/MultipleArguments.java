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
public abstract class MultipleArguments extends Expression {

    protected Expression value1;
    protected Expression value2;

    public MultipleArguments(Expression value1, Expression value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
