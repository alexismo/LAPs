package com.alexismorin.laps.nouns;

import java.util.ArrayList;

import com.alexismorin.laps.words.Noun;

public class Apple_Word extends Noun implements Actionnable{

	public Apple_Word() {
		super("apple");
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
