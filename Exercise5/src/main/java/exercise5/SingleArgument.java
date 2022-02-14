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
public abstract class SingleArgument extends Expression {

    protected Expression value1;

    public SingleArgument(Expression value1) {
        this.value1 = value1;
    }
}
