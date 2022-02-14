package exercise5;
import static exercise5.Factory.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Variable x = var("x");
        Expression e1 = add(mul(con(2), con(3)), x);
        e1.store.put("x", 5.0);
        System.out.println(e1.eval(e1.store));
        System.out.println(e1.pe());
        System.out.println(mul(con(0), con(5)).pe());
    }

}
