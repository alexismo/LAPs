package com.alexismorin.laps.grammar.errors;

import com.alexismorin.laps.grammar.errors.WordError;

public class NoVerbError extends WordError {
	
	public NoVerbError(){
		this.message = "I need a verb.";
	}
}
