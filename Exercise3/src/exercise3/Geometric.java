/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;


/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public interface Geometric extends Comparable<Geometric> {
    double getArea(); //used for sort
    String toString();
    void move(double dx, double dy);
    double leftBorder(); //used for sort x
    double bottomBorder(); //used for sort y
}
