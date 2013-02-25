package com.alexismorin.laps;

import java.util.ArrayList;
import java.util.Collections;

import com.alexismorin.laps.words.Word;

public class WordList{
	private ArrayList<Word> words;
	
	public WordList(){
		words = new ArrayList<Word>();
	}

	public void add(Word w){
		this.words.add(w);
	}
	
	public int size(){
		return words.size();
	}
	
	public Word get(int x){
		return words.get(x);
	}
	
	public void sort(){
		Collections.sort(words, new WordPositionComparator());
	}
}
