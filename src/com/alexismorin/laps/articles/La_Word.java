package com.alexismorin.laps.articles;

import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Word;

public class La_Word extends Article implements Definiteness, GrammaticalGender {

	public La_Word() {
		super("la");
	}

	@Override
	public String definiteness() {
		return "definite";
	}

	@Override
	public String gender() {
		return "feminin";
	}
}