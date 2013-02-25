package com.alexismorin.laps.words;

import processing.core.PVector;

public class Word extends Tile implements Comparable<Word>{

	public String word;

	public Word(PVector pos, String word) {
		super(pos);
		this.word = word;
	}

	public Word(String word) {
		this.word = word;
	}
	
	@Override
	public int compareTo(Word o) {
		int compareX = Math.round(((Word) o).pos.x);
		
		return compareX - Math.round(this.pos.x);
	}
}


