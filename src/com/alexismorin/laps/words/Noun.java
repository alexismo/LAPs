package com.alexismorin.laps.words;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.Pluralizable;
import com.alexismorin.laps.grammar.errors.NoArticleError;

public abstract class Noun extends Word implements Grammar{

	public Noun(String word) {
		super(word);
	}

	@Override
	public boolean do_grammar(Sentence s, int i) {
		this.errors.clear();
		Word pWord = s.getPrevWord(i);		
		
		int gramNumber;
		if (pWord instanceof GrammaticalNumber && this instanceof Pluralizable){
			gramNumber = ((GrammaticalNumber) pWord).number();
			
			this.setWord(((Pluralizable)this).pluralize(gramNumber));
		}
		
		if(!(pWord instanceof Article /* || pWord instanceof Adjective*/)){
			this.errors.add(new NoArticleError());
		}
		
		if(this.errors.size() == 0)	
			return true;
		else
			return false;
	}
	
}
