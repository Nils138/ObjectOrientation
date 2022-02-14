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
public class PrintFormVisitor implements FormVisitor {

    private String formula = "";

    /**
     * the visit functions gets a form as parameter and transforms it into a
     * String while taking into account parentheses and priority order
     *
     * @param notForm
     * @return null
     */
    @Override
    public Void visit(NotForm notForm) {
        formula = "NOT " + formula;
        notForm.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryForm binaryForm) {
        Operator command = binaryForm.getOperator();
        //priority of operations determines parentheses
        boolean not = formula.length() > 3
                && formula.substring(formula.length() - 4).equals("NOT ");
        boolean and = formula.length() > 3
                && formula.substring(formula.length() - 4).equals("AND ");
        boolean or = formula.length() > 2
                && formula.substring(formula.length() - 3).equals("OR ");

        switch (command) {
            case AND:
                if (not) {
                    formula += "(";
                }
                binaryForm.getA().accept(this);
                formula += " AND ";
                binaryForm.getB().accept(this);
                if (not) {
                    formula += ")";
                }
                break;
            case OR:
                if (not || and) {
                    formula += "(";
                }
                binaryForm.getA().accept(this);
                formula += " OR ";
                binaryForm.getB().accept(this);
                if (not || and) {
                    formula += ")";
                }
                break;
            case IMPLIES:
                if (not || and || or) {
                    formula += "(";
                }
                binaryForm.getA().accept(this);
                formula += " IMPLIES ";
                binaryForm.getB().accept(this);
                if (not || and || or) {
                    formula += ")";
                }
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    public Void visit(AtomForm Str) {
        formula += Str.getOperand();
        return null;
    }

    @Override
    public Void visit(BasicForm Boolean) {
        formula += Boolean.getBoolean();
        return null;
    }

    @Override
    public String toString() {
        return formula;
    }
}
