/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise8;

import exercise8.polynomial.*;
import java.util.Scanner;

/**
 * We really don't know what you mean with distributive/associative/
 * commutative and those terms weren't in the slides.
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test cases
        Polynomial test1 = new Polynomial();
        System.out.println(test1);
        Polynomial test2 = new Polynomial("1 0 3 2");
        System.out.println(test2);
        Polynomial test3 = new Polynomial(test2);
        System.out.println(test3);
        test3.plus(test2);
        System.out.println(test3);
        test2.times(test3);
        System.out.println(test2);
        test2.minus(test3);
        System.out.println(test2);
        test2.divide(test3);
        System.out.println(test2);
        System.out.println(test2.equals(test3));
        Term test4 = new Term(4, 1);
        System.out.println(test4);
        Term test5 = new Term(test4);
        System.out.println(test5);
        test4.plus(test5);
        System.out.println(test4);
        test5.times(new Term(5, 0));
        System.out.println(test5);
        test4.divide(test5);
        System.out.println(test4);
        test5.neg();
        System.out.println(test5);
        System.out.println(test5.equals(test5));
        Scanner scan = new Scanner("5 3");
        System.out.println(Term.scanTerm(scan));
        //edge cases
        Polynomial edge1 = new Polynomial("2 1 3 2 4 3");
        edge1.minus(new Polynomial("3 2"));
        System.out.println(edge1);
        edge1.plus(new Polynomial("-2 1"));
        System.out.println(edge1);
        edge1.times(new Polynomial());
        System.out.println(edge1);
        Term edge2 = new Term(-2, -1);
        Term edge3 = new Term(2, -1);
        edge2.plus(new Term(2, -1)); //doesn't dissappears
        System.out.println(edge2);
        Term edge4 = new Term(-2, 1);
        edge3.plus(edge4); //doesn't dissappear
        System.out.println(edge3);
        edge4.plus(new Term(500, 300)); //doesn't check whether the terms added
        //have the same exponent
        System.out.println(edge4);
        Term edge5 = new Term(2, 5);
        edge5.times(new Term(0, 0)); //doesn't dissappear
        System.out.println(edge5);
        Term edge6 = new Term(2, 3);
        edge6.divide(new Term(0, 0));//this one made me laugh
        System.out.println(edge6);
    }
}
