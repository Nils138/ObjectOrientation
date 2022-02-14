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
public class Rectangle implements Geometric {

    //attributes
    private double x;
    private double y;
    private final double h;
    private final double w;

    //constructor
    public Rectangle(double x, double y, double h, double w) {
	this.x = x;
	this.y = y;
	this.h = h;
	this.w = w;
    }

    //methods
    @Override
    public double getArea() {
	return h * w;
    }

    @Override
    public String toString() {
	return "rectangle (" + this.x + "," + this.y + ") h: " + this.h + " w: "
		+ this.w;
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
	return x;
    }

    @Override
    public double bottomBorder() {
	return y;
    }

}
