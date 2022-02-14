/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.Scanner;

/**
 *
 * @author Ole ten Hove s1007616
 * @author Nils Kimman s1007368
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

	//making the group
	System.out.println("How big is the student group?");
	Scanner groupSize = new Scanner(System.in);
	//Are we allowed to name scanners "s" or "scanner"?
	final int SIZE = groupSize.nextInt();

	if (SIZE < 0) //handling negative array size inputs
	{
	    throw new IllegalArgumentException("Invalid array size");
	}

	Student[] group = new Student[SIZE];

	//size >= 0
	//doing something with the group
	fillGroup(group, SIZE);
	if (SIZE > 0) {
	    changeGroup(group);
	}
    }

    /**
     * Fills the group with new students; uses size rather than group.length.
     *
     * @param group
     * @param size
     */
    public static void fillGroup(Student[] group, int size) { //assuming group
	// != null and size is in group bounds. Q: do we need to use asserts?
	for (int i = 0; i < size; i++) { //loop through the entire group; can't 
	    //do this with a " : " construction because I really need the index
	    group[i] = askInfo(group);
	}
	dumpGroup(group); //made this a new function: I used it at least twice
    }

    /**
     * asks the user to enter the student's full name and their student number.
     *
     * @param group
     * @return a new student with the entered info
     */
    public static Student askInfo(Student[] group) {
	//made this function because I used it at least twice,
	//but I changed the second one so now it's just here to reduce the 
	//amount of lines in the fillGroup function
	Scanner name = new Scanner(System.in);
	System.out.println("Please enter the first name of the student");//this
	//is the cleanest way to determine which counts as first name and which
	//counts as last name.
	String firstName = name.nextLine(); //not next() because people can have
	//multiple first names

	System.out.println("Please enter the last name of the student");
	String lastName = name.nextLine(); //same reason for nextLine()

	System.out.println("Please enter the student's student number");
	int studentNumber = name.nextInt(); //can be negative here
	if (studentNumber < 0) //things will be problematic if negative student
	//numbers are allowed so from here on studentNumber >= 0.
	{
	    throw new IllegalArgumentException("Negative student number");
	}
	return new Student(firstName, lastName, studentNumber);
    }

    /**
     * dumps each student's full name and student number
     *
     * @param group
     */
    public static void dumpGroup(Student[] group) { //simple but often-used
	System.out.println("The group now contains: ");
	for (Student student : group) {
	    student.showStudent(student);
	}
    }

    /**
     * gives the user the opportunity to change the group as long as they want;
     * terminates if a negative student number is entered.
     *
     * @param group
     */
    public static void changeGroup(Student[] group) { //assuming group != null
	boolean done = false;//boolean > System.exit(1)/break/return, it's nice

	//loop
	while (!done) {
	    Scanner newStudent = new Scanner(System.in);
	    System.out.println("Please enter the student number of the student "
		    + "who's name you want to change:");
	    int studentNumber = newStudent.nextInt();
	    if (studentNumber < 0) {
		done = true;
	    } else { //ensures that if done = true, the porgam stops immediately
		newStudent.nextLine(); //used to skip the newlines leftover from
		//the nextInt() output; ensures that I can use nextLine for both
		//the first and last name entries.

		System.out.println("Please enter the new first name:");
		String firstName = newStudent.nextLine();

		System.out.println("Please enter the new last name:");
		String lastName = newStudent.nextLine();

		Student s = new Student(firstName, lastName, studentNumber);
		int index = group.length;
		for (int i = 0; i < group.length; i++) {
		    if (s.getStudentNumber() == group[i].getStudentNumber()) {
			index = i;
		    }
		}
		if (index == group.length) {
		    throw new IllegalArgumentException("Student number not "
			    + "found");
		}
		//index i is valid because an exception is thrown if no student
		//with that student number is found.
		group[index].changeName(firstName, lastName);

		dumpGroup(group);
	    }
	}
    }
}
