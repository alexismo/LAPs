package com.alexismorin.laps.grammar.errors;

public class GrammaticalGenderError extends WordError {
	public GrammaticalGenderError(){
		this.message = "That article isn't of the same gender as this word.";
	}
}
