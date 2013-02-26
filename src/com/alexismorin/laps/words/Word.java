package com.alexismorin.laps.words;

import processing.core.PVector;

public class Word extends Tile implements Comparable<Word>{

	private String word;

	public Word(PVector pos, String word) {
		super(pos);
		this.word = word;
	}

	public Word(String word) {
		this.word = word;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String newWord){//use this to set words for conjugation
		this.word = newWord;
	}
	
	@Override
	public int compareTo(Word o) {
		int compareX = Math.round(((Word) o).pos.x);
		
		return compareX - Math.round(this.pos.x);
	}

	public boolean do_grammar(Word prevWord, Word nextWord) {
		/**
		 * Override this as soon as possible.
		 */
		return true;
	}
}


