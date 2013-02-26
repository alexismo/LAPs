package com.alexismorin.laps.words;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.Subjecting;

public class Pronoun extends Word implements Subjecting, Grammar{
	public Pronoun(String word){
		super(word);
	}

	@Override
	public boolean is_subject(Word followingWord) {
		return followingWord instanceof Verb;
	}

	@Override
	public boolean do_grammar(Word previousWord, Word nextWord) {
		return is_subject(nextWord);
	}

	@Override
	public boolean is_first_word() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is_last_word() {
		// TODO Auto-generated method stub
		return false;
	}
}
