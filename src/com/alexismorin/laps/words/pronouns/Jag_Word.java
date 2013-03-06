package com.alexismorin.laps.words.pronouns;

import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.GrammaticalPerson;
import com.alexismorin.laps.grammar.Subjecting;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Jag_Word extends Pronoun implements GrammaticalNumber, GrammaticalPerson, Subjecting{

	public Jag_Word() {
		super("jag");
	}

	@Override
	public int number() {
		return 1;
	}

	@Override
	public int person() {
		return 1;
	}
	
	@Override
	public boolean is_subject(Word followingWord){
		if(followingWord instanceof Verb)
			return true;
		else
			return false;
	}
}