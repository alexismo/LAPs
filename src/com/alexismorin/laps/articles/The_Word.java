package com.alexismorin.laps.articles;

import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.words.Article;

public class The_Word extends Article implements Definiteness {

	public The_Word() {
		super("the");
	}

	@Override
	public String definiteness() {
		return "definite";
	}
}
