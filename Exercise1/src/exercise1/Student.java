/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author Ole ten Hove s1007616
 * @author Nils Kimman s1007368
 */
public class Student {

    //atributes
    private String firstName;
    private String lastName;
    private final int studentNumber; //student number doesn't change so it 
    //can be made final

    //constructor
    public Student(String firstName, String lastName, int studentNumber) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.studentNumber = studentNumber;
    }

    //methods   
    public int getStudentNumber() {
	return this.studentNumber;
    }

    public void changeName(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

    /**
     * displays the student name and s-number
     *
     * @param student
     */
    public void showStudent(Student student) {
	System.out.println(student.firstName + " " + student.lastName + " - s"
		+ student.studentNumber);
    }
}
