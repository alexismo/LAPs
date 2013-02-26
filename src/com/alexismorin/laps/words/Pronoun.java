package com.alexismorin.laps.words;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.Subjecting;

public abstract class Pronoun extends Word implements Subjecting, Grammar{
	public Pronoun(String word){
		super(word);
	}

	@Override
	public boolean is_subject(Word followingWord) {
		return followingWord instanceof Verb;
	}
	
	
}
