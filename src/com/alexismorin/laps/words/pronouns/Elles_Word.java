package com.alexismorin.laps.words.pronouns;

import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.GrammaticalPerson;
import com.alexismorin.laps.grammar.Subjecting;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Elles_Word extends Pronoun implements GrammaticalNumber, GrammaticalPerson, Subjecting{

	public Elles_Word() {
		super("elles");
	}

	@Override
	public int number() {
		return 3;
	}

	@Override
	public int person() {
		return 6;
	}
	
	@Override
	public boolean is_subject(Word followingWord){
		if(followingWord instanceof Verb)
			return true;
		else
			return false;
	}
}