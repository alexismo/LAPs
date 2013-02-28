package com.alexismorin.laps.words.articles;

import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Word;

public class Les_Word extends Article implements Definiteness, GrammaticalNumber {

	public Les_Word() {
		super("les");
	}

	@Override
	public String definiteness() {
		return "definite";
	}

	@Override
	public int number() {
		return 3;
	}
}