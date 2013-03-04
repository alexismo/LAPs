package com.alexismorin.laps.words.adverbs;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.TimeIndicator;
import com.alexismorin.laps.grammar.errors.TimeAdverbPositionError;
import com.alexismorin.laps.words.Adverb;

public class Yesterday_Word extends Adverb implements TimeIndicator{

	/**
	 * @Grammar reference: 
	 * http://www.lepointdufle.net/ressources_fle/expressions_de_temps.htm
	 * http://faculty.virginia.edu/ajmlevine/grammar/verbs_allerhd_multi.html
	 */
	public Yesterday_Word() {
		super("yesterday");
	}

	@Override
	public String getTense() {
		return "past";
	}
	
	@Override
	public boolean do_grammar(Sentence sentence, int i) {
		this.errors.clear();
		
		if(i == 0 || i == sentence.size()-1)
			return true;
		else{
			this.errors.add(new TimeAdverbPositionError());
			return false;
		}
	}
}