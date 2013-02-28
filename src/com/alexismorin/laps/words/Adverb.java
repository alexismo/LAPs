package com.alexismorin.laps.words;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.Pluralizable;
import com.alexismorin.laps.grammar.errors.NoArticleError;

public abstract class Adverb extends Word implements Grammar{

	public Adverb(String word) {
		super(word);
	}
}
