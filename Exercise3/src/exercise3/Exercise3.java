/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise3 {

    static final int MAX_SIZE = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Geometric[] objects = new Geometric[MAX_SIZE];
	loopCommands(objects);
    }

    /**
     * big function with a huge while loop and switch, terminates only when user
     * enters "quit". Difficult to separate in different functions because of
     * variables done and i.
     *
     * @param objects
     */
    public static void loopCommands(Geometric[] objects) {
	assert objects != null : "array should be initialized";
	Loop loop = new Loop(false, 0, "");

	while (!loop.isDone()) {

	    System.out.println("Please enter the next command:");

	    Scanner input = new Scanner(System.in);
	    loop.setCommand(input.next());
	    switchComm(input, loop, objects); //abbreviation of switchCommand:
	    //if the name was switchCommand it'd exceed the 80 char limit.

	}
    }

    public static void switchComm(Scanner s, Loop loop, Geometric[] objects) {
	assert objects != null : "Array should be initialized";
	assert loop != null : "Class should be initialized";
	assert s != null : "Scanner should be initialized";

	switch (loop.getCommand()) { //this will be one big switch
	    case "quit":
		loop.setDone(); //nice and easy way to do this
		break;
	    case "show":
		showObjects(objects); //this operation can easily be put 
		//in a different function
		break;
	    case "circle":
		double x = s.nextDouble();
		double y = s.nextDouble();
		double r = s.nextDouble(); //doing this three times in a row
		//works fine, but does add to the size of this switch

		objects[loop.getIndex()] = new Circle(x, y, r);
		loop.addIndex(); //only increment i after adding objects
		break;
	    case "rectangle":
		x = s.nextDouble(); //i wanted to keep the variable names
		y = s.nextDouble(); //but they're already initialized
		double h = s.nextDouble();
		double w = s.nextDouble();

		objects[loop.getIndex()] = new Rectangle(x, y, h, w);
		loop.addIndex();
		break;
	    case "move":
		int index = s.nextInt();
		double dx = s.nextDouble();
		double dy = s.nextDouble();

		if (objects[index] == null) {
		    throw new IllegalArgumentException("index out of "
			    + "bounds");
		}
		objects[index].move(dx, dy);
		break;
	    case "remove":
		index = s.nextInt();
		objects[index] = null; //leaves a gap in the array
		//does this need to be fixed?
		shiftLeft(objects, index);
		loop.removeIndex();
		break;
	    case "sort":
		//need a good way to check whether the input is " x", " y", 
		//or empty: this way works but there might be a nicer solution
		//useDelimiter doesn't work; need spaces for the other cases

		String argument = s.nextLine();
		char method; //scope
		if (argument.length() > 1) {
		    method = argument.charAt(1);
		    // charAt(0) is a space, so charAt(1) is the argument
		} else {
		    method = 'a'; //this basically lets me choose this char
		}

		GeometricComparator gComp = new GeometricComparator(method);
		//i now realize this class name might be too long...
		Arrays.sort(objects, 0, loop.getIndex(), gComp);
		break;
	    default:
		System.out.println("Invalid command");
		break;
	}
    }

    /**
     * loops through the array and shows all existing objects.
     *
     * @param objects
     */
    public static void showObjects(Geometric[] objects) {
	assert objects != null : "Array should be initialized";
	for (Geometric object : objects) {
	    if (object != null) {
		System.out.println(object.toString());
	    }
	}
    }

    /**
     * shifts objects left if an object is removed in the middle of the array
     *
     * @param objects
     * @param index
     */
    public static void shiftLeft(Geometric[] objects, int index) {
	assert index < objects.length : "index out of bounds";
	assert objects != null : "Array should be initialized";
	for (int i = index; i < objects.length - 1; i++) {
	    if (objects[i] == null && objects[i + 1] != null) {
		objects[i] = objects[i + 1];
		objects[i + 1] = null;
	    }
	}
    }
}
