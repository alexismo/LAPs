package com.alexismorin.laps.grammar.errors;

public class StartsWithError extends SentenceError {
	public StartsWithError(){
		this.message = "Try starting your sentence with a pronoun.";//pronoun only for now
	}
}
