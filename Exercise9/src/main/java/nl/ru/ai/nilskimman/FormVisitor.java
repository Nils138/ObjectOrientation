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
public interface FormVisitor<R> {

    R visit(NotForm notform);

    R visit(BinaryForm binaryform);

    R visit(AtomForm string);

    R visit(BasicForm base);
}
