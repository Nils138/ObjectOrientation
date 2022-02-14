/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ru.ai.nilskimman;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class EvalFormVisitor implements FormVisitor {

    Map map = new HashMap();

    public EvalFormVisitor(HashMap map) {
        this.map = map;
    }

    /**
     * The visit method evaluates the given formula and return the result
     *
     * @param notForm
     * @return the evaluation of the given formula
     */
    @Override
    public Boolean visit(NotForm notForm) {
        if (notForm.getOperand().accept(this) == Boolean.TRUE) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean visit(BinaryForm binaryForm) {
        Operator command = binaryForm.getOperator();
        switch (command) {
            case AND:
                if (binaryForm.getA().accept(this) == Boolean.TRUE && binaryForm
                        .getB().accept(this) == Boolean.TRUE) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            case OR:
                if (binaryForm.getA().accept(this) == Boolean.TRUE || binaryForm
                        .getB().accept(this) == Boolean.TRUE) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            case IMPLIES:
                if (binaryForm.getA().accept(this) == Boolean.TRUE && binaryForm
                        .getB().accept(this) == Boolean.FALSE) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            default:
                break;
        }
        return null;
    }

    @Override
    public Boolean visit(AtomForm Str) {
        if (map.containsKey(Str.getOperand())) {
            if ((boolean) map.get(Str.getOperand())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean visit(BasicForm Boolean) {
        return Boolean.getBoolean();
    }

}
