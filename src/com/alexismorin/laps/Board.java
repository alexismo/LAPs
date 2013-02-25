package com.alexismorin.laps;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PVector;

import com.alexismorin.laps.mouse.MouseEvent;
import com.alexismorin.laps.articles.The_Word;
import com.alexismorin.laps.verbs.Eat_Word;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Noun;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;
import com.alexismorin.laps.words.pronouns.I_Word;

public class Board {

	WordList words;
	
	Dragger dragger;

	public Board() {
		super();
		this.words = new WordList();
		dragger = new Dragger(this);
	}

	public void makeWords() {
		addWord( new Eat_Word() );
		addWord( new I_Word() );
		addWord( new The_Word() );
		addWord( new Noun("apple") );
	}

	public void addWord(String word) {
		words.add(new Word(word));
		
		//words.add(new Word(new PVector(100 * words.size() + 20, 100), word));
	}
	
	public void addWord(Word w){
		words.add(w);
	}

	public void checkSentence() {
		words.sort();
	}

	public void onMouseEvent(MouseEvent e) {
		dragger.onMouseEvent(e);
	}
}
