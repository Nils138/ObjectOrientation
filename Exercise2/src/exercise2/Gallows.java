/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * @author Ole ten Hove s1007616
 * @author Nils Kimman s1007368
 */
public class Gallows {

    private final String word;

    public Gallows(String word) {
	this.word = word;
    }

    public Gallows() {
	WordReader wordReader = new WordReader("words.txt");
	this.word = wordReader.getWord();
    }

    public int length() {
	return this.word.length();
    }

    public String getWord() {
	return this.word;
    }

    public char charAt(int i) {
	return this.word.charAt(i);
    }
}
