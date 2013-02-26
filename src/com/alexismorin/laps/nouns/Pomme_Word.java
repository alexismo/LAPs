package com.alexismorin.laps.nouns;

import java.util.ArrayList;

import com.alexismorin.laps.grammar.Actionnable;
import com.alexismorin.laps.words.Noun;

public class Pomme_Word extends Noun implements Actionnable{

	public Pomme_Word() {
		super("pomme");
	}

	@Override
	public ArrayList<String> action_categories() {
		ArrayList<String> categories = new ArrayList<String>();
		
		categories.add("food");
		categories.add("physical");
		categories.add("small");
		
		return categories;
	}
}
