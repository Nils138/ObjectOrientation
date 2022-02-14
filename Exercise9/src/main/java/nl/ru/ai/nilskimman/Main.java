/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ru.ai.nilskimman;

import java.util.HashMap;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Main {

    public static void main(String[] args) {

        //example formulas
        Form example0 = new AtomForm("a");
        
        Form example1 = new NotForm(new BinaryForm(Operator.AND, new AtomForm
        ("a"), new AtomForm("b")));
        
        Form example2 = new BinaryForm(Operator.OR, new AtomForm("a"), new 
        BinaryForm(Operator.IMPLIES, new AtomForm("a"), new AtomForm("b")));
        
        Form example3 = new BinaryForm(Operator.OR, new BasicForm(true), new 
        BasicForm(false));
        
        Form example4 = new BinaryForm(Operator.AND, new AtomForm("a"), new 
        AtomForm("b"));

        //printer test cases
        PrintFormVisitor printer0 = new PrintFormVisitor();
        example0.accept(printer0);
        System.out.println(printer0);
        PrintFormVisitor printer1 = new PrintFormVisitor();
        example1.accept(printer1);
        System.out.println(printer1);
        PrintFormVisitor printer2 = new PrintFormVisitor();
        example2.accept(printer2);
        System.out.println(printer2);
        PrintFormVisitor printer3 = new PrintFormVisitor();
        example3.accept(printer3);
        System.out.println(printer3);
        PrintFormVisitor printer4 = new PrintFormVisitor();
        example4.accept(printer4);
        System.out.println(printer4);

        //evaluation test cases
        HashMap map1 = new HashMap();
        map1.put("a", Boolean.TRUE);
        map1.put("b", Boolean.FALSE);
        EvalFormVisitor eval0 = new EvalFormVisitor(map1);
        System.out.println(example0.accept(eval0));
        EvalFormVisitor eval1 = new EvalFormVisitor(map1);
        System.out.println(example1.accept(eval1));
        EvalFormVisitor eval2 = new EvalFormVisitor(map1);
        System.out.println(example2.accept(eval1));
        EvalFormVisitor eval3 = new EvalFormVisitor(map1);
        System.out.println(example3.accept(eval1));
        EvalFormVisitor eval4 = new EvalFormVisitor(map1);
        System.out.println(example4.accept(eval1));
    }
}
