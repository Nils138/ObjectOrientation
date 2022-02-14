/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.Scanner;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Gallows gallows = setStage();
	Game hangMan = new Game("", new StringBuilder(""), gallows, "");
	hangMan.initialize();
	int guesses = 10;
	System.out.println(hangMan.getProgress());
	while (!hangMan.isDone() && guesses > 0) {
	    nextGuess(hangMan, guesses);
	    guesses--;
	}
	if (hangMan.isDone()) {
	    System.out.println("You win!");
	} else {
	    System.out.println("You lose! The word was: " + gallows.getWord());
	}
    }

    /**
     * States information, then processes a newly entered word/character
     *
     * @param hangMan
     * @param guesses
     */
    public static void nextGuess(Game hangMan, int guesses) {
	assert hangMan != null : "Game doesn't exist";
	assert guesses > 0 : "You are out of guesses!";
	System.out.println("You have " + guesses + " guesses left");
	System.out.println("Used letters: " + hangMan.getUsed());
	System.out.println("Please enter your next guess:");
	
    	hangMan.setGuess(new Scanner(System.in).next());

	hangMan.nextGuess();
    }

    /**
     * Sets the stage for the game: asks the user for which word they want to
     * use, and saves that in a gallows instance.
     *
     * @return gallows
     */
    public static Gallows setStage() {
	assert true;
	Scanner decision = new Scanner(System.in);

	System.out.println("Enter the word you want to use, or nothing if you "
		+ "want to use a random word"); 
	String choice = decision.nextLine(); //nextLine() here instead of next()
	    //becaues nextLine() can recognize an enter as an input.
	
	if (choice.length() > 0) 
	    return new Gallows(choice); //random-word-constructor
	return new Gallows(); //chosen-word-constructor
    }
}
