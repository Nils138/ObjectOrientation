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
public class Circle implements Geometric {

    //attributes
    private double x;
    private double y;
    final private double r;

    //constructor
    public Circle(double x, double y, double r) {
	this.x = x;
	this.y = y;
	this.r = r;
    }

    //methods
    @Override
    public double getArea() {
	return this.r * 2 * Math.PI;
    }

    @Override
    public String toString() {
	return "circle (" + this.x + "," + this.y + ") with radius " + this.r;
    }

    @Override
    public void move(double dx, double dy) {
	this.x += dx;
	this.y += dy;
    }

    @Override
    public int compareTo(Geometric o) {
	return (int) (this.getArea() - o.getArea());
    }

    @Override
    public double leftBorder() {
	return x - r;
    }

    @Override
    public double bottomBorder() {
	return y - r;
    }

}
