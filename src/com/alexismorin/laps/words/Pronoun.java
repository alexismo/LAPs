package com.alexismorin.laps.words;

import com.alexismorin.laps.grammar.Subjecting;

public class Pronoun extends Word implements Subjecting{
	public Pronoun(String word){
		super(word);
	}

	@Override
	public boolean is_subject(Word followingWord) {
		return followingWord instanceof Verb;
	}
}
