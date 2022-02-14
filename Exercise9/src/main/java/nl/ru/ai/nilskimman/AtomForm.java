/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ru.ai.nilskimman;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class AtomForm implements Form {

    private String operand;

    public AtomForm(String operand) {
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

    @Override
    public <Boolean> Boolean accept(FormVisitor<Boolean> visitor) {
        return visitor.visit(this);
    }
}
