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
public class NotForm implements Form {

    private Form operand;

    public NotForm(Form operand) {
        this.operand = operand;
    }

    public Form getOperand() {
        return operand;
    }

    @Override
    public <Boolean> Boolean accept(FormVisitor<Boolean> visitor) {
        return visitor.visit(this);
    }

}
