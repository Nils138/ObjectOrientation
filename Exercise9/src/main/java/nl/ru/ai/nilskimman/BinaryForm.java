/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ru.ai.nilskimman;

import java.util.function.BinaryOperator;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class BinaryForm implements Form, BinaryOperator<Form> {

    Form a;
    Form b;
    Operator operator;

    public BinaryForm(Operator operator, Form a, Form b) {
        this.operator = operator;
        this.a = a;
        this.b = b;
    }

    public Form getA() {
        return this.a;
    }

    public Form getB() {
        return this.b;
    }

    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public Form apply(Form a, Form b) {
        return this;
    }

    @Override
    public <Boolean> Boolean accept(FormVisitor<Boolean> visitor) {
        return visitor.visit(this);
    }

}
