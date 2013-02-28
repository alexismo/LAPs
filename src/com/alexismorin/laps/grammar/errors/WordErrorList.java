package com.alexismorin.laps.grammar.errors;

import java.util.ArrayList;

public class WordErrorList {
	ArrayList<WordError> errors;
	
	public WordErrorList(){
		this.errors = new ArrayList<WordError>();
	}
	
	public WordError get(int i){
		return errors.get(i);
	}
	
	public void add(WordError e){
		if(!errors.contains(e)){//no duplicates!
			errors.add(e);
		}
	}
	
	public int size(){
		return errors.size();
	}

	public void clear() {
		this.errors.clear();
	}
}
