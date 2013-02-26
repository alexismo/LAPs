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
	
	public ArrayList<Word> getList(){
		return this.words;
	}

	public Word getNextSnapped(int i) {
		for(int j = i+1; j < words.size(); j++){//+1 for the NEXT word
			Word w = words.get(j);
			if(w.snapped)
				return w;
		}
		
		return null;
	}
	
	public Word getPrevSnapped(int i) {//-1 for the PREVIOUS word
		for(int j = i-1; j > 0; j--){
			Word w = words.get(j);
			if(w.snapped)
				return w;
		}
		
		return null;
	}
}
