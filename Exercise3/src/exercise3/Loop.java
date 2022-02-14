/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise3;

/**
 * @author Ole ten Hove s1007616
 * @author Nils Kimman s1007368
 */
public class Loop {

    //attributes
    boolean done; //set to true when user enters "quit"
    int i;//index of how far the array is filled with objects
    String command;

    //constructor
    public Loop(boolean done, int i, String command) {
	this.done = done;
	this.i = i;
	this.command = command;
    }

    //methods
    public boolean isDone() {
	return done;
    }

    public void setDone() {
	done = true; //this is possible because done will only ever go from 
	//false to true
    }

    public void setCommand(String command) {
	this.command = command;
    }

    public String getCommand() {
	return this.command;
    }

    public int getIndex() {
	return i;
    }

    public void addIndex() {
	this.i++;
    }

    public void removeIndex() { //could use setIndex but this is nicer i think
	this.i--;
    }
}
