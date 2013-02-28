package com.alexismorin.laps;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.lang3.text.WordUtils;

import processing.core.PApplet;
import processing.core.PVector;

import com.alexismorin.laps.mouse.MouseEvent;

import com.alexismorin.laps.words.pronouns.*;
import com.alexismorin.laps.verbs.*;
import com.alexismorin.laps.articles.*;
import com.alexismorin.laps.nouns.*;

import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Noun;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Board {

	PApplet parent;
	WordList words;
	Dragger dragger;
	Sentence sentence;

	public Board(PApplet p) {
		super();
		this.parent = p;
		this.words = new WordList();
		dragger = new Dragger(this, p);
		this.sentence = new Sentence();
	}

	public void makeWords() {
		// English things
		/*
		 * addWord( new Eat_Word() ); addWord( new I_Word() ); addWord( new
		 * The_Word() ); addWord( new Apple_Word() );
		 */
		// French things
		addWord(new Manger_Word());
		addWord(new Je_Word());
		addWord(new Tu_Word());
		addWord(new Nous_Word());
		addWord(new La_Word());
		addWord(new Le_Word());
		addWord(new Les_Word());
		addWord(new Pomme_Word());
	}

	public void addWord(Word w) {
		words.add(w);
	}

	public void sortSentence() {
		words.sort();
	}

	public Sentence makeSentence() {
		/**
		 * @returns a sentence object comprised of all the words on the main line, in order
		 */
		ArrayList<Word> newSentence = new ArrayList<Word>();
		
		for (int i = 0; i < words.size(); i++) {
			Word w = words.get(i);

			if (w.snapped) {
				newSentence.add(w);
			}
		}
		
		this.sentence.setWords(newSentence);

		return this.sentence;
	}
	
	public String getSentenceString(){
		return this.sentence.toString();
	}

	public void onMouseEvent(MouseEvent e) {
		dragger.onMouseEvent(e);
	}
}
