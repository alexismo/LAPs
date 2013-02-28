package com.alexismorin.laps.articles;

import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Word;

public class Le_Word extends Article implements Definiteness, GrammaticalGender, GrammaticalNumber {

	public Le_Word() {
		super("le");
	}

	@Override
	public String definiteness() {
		return "definite";
	}

	@Override
	public String gender() {
		return "masculin";
	}

	@Override
	public int number() {
		return 1;
	}
}