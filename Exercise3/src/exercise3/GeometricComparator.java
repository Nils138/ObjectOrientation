/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.util.Comparator;

/**
 *
 * @author Nils Kimman
 */
public class GeometricComparator implements Comparator<Geometric> {

    char method;

    public GeometricComparator(char method) {
	this.method = method;
    }

    @Override
    public int compare(Geometric o1, Geometric o2) {
	switch (method) {
	    case 'x':
		return (int) (o1.leftBorder() - o2.leftBorder());
	    case 'y':
		return (int) (o1.bottomBorder() - o2.bottomBorder());
	    case 'a': //a here can be any value, I chose a for "area"
		return o1.compareTo(o2);
	    default: //for when they add an argument other than x or y
		throw new IllegalArgumentException("Invalid argument");
	}
    }
}
