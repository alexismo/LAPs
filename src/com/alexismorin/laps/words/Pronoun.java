package com.alexismorin.laps.words;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.LinkTo;
import com.alexismorin.laps.grammar.Subjecting;

public abstract class Pronoun extends Word implements Subjecting, Grammar, LinkTo {
	Word linkToThis;
	
	public Pronoun(String word) {
		super(word);
	}

	@Override
	public boolean is_subject(Word followingWord) {
		return followingWord instanceof Verb;
	}

	@Override
	public boolean do_grammar(Word prevWord, Word nextWord) {
		if (is_subject(nextWord)){
			grammarOK = true;
			linkToThis = nextWord;
			return true;
		}
		else{
			grammarOK = false;
			linkToThis = null;
			return false;
		}
	}
	
	@Override
	public Word linkToWord(){
		
		return linkToThis;
	}
}