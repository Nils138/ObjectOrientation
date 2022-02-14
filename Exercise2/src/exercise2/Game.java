/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Game {

    private String guess; //current guess; is String because people can try to
    //guess the entire word
    private StringBuilder progress;
    private final Gallows word;
    private String used; //list of previous guesses

    public Game(String guess, StringBuilder progress, Gallows g, String used) {
	this.guess = guess;
	this.progress = progress;
	this.word = g;
	this.used = used;
    }

    public void setGuess(String guess) {
	this.guess = guess;
    }

    public boolean isDone() {
	return this.progress.toString().equals(this.word.getWord());
    }

    public String getUsed() {
	return this.used;
    }

    public StringBuilder getProgress() {
	return this.progress;
    }

    public void initialize() {
	for (int i = 0; i < this.word.length(); i++) {
	    progress.append('.');
	}
    }

    public void nextGuess() {
	assert guess.length() > 0 : "No guess entered"; //question: do we need
	//to put this. in front of every use of an attribute?
	if (guess.length() > 1) {  //for if people want to guess the word itself
	    if (guess.equals(word.getWord())) { //nested if is nicer here
		progress = new StringBuilder(word.getWord()); //hurray
	    }
	} else { //guess.length == 1, for guessing a single letter
	    for (int i = 0; i < word.length(); i++) {
		if (guess.charAt(0) == word.charAt(i)) {
		    progress.setCharAt(i, guess.charAt(0));
		}
	    }
	}
	used += guess + ", ";
	System.out.println(progress);
    }
}
