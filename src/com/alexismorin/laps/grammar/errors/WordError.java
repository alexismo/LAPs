package com.alexismorin.laps.grammar.errors;

public class WordError {
	String message;
	public WordError(){
		this.message = "You can't say that.";
	}
	
	public String getErrorMsg(){
		return this.message;
	}
}
