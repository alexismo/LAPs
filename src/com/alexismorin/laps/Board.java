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

	public Board(PApplet p) {
		super();
		this.parent = p;
		this.words = new WordList();
		dragger = new Dragger(this, p);
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
		addWord(new Pomme_Word());
	}

	public void addWord(String word) {
		words.add(new Word(word));

		// words.add(new Word(new PVector(100 * words.size() + 20, 100), word));
	}

	public void addWord(Word w) {
		words.add(w);
	}

	public void sortSentence() {
		words.sort();

		/*
		 * sentenceWords.clear(); for(int i = 0; i < words.size(); i++){ Word w
		 * = words.get(i); if(w.snapped) sentenceWords.add(w); }
		 */
	}

	public String getSentence() {
		String theSentence = "";
		for (int i = 0; i < words.size(); i++) {
			Word w = words.get(i);

			if (w.snapped) {
				String s = w.getWord();

				if (i == 0) {// capitalize
					s = WordUtils.capitalize(s);
				}
				if (i == words.size() - 1) {// add period
					theSentence += s;
					theSentence += ".";
				} else {
					theSentence += s;
					theSentence += " ";
				}
			}
		}

		return theSentence;
	}

	public void onMouseEvent(MouseEvent e) {
		dragger.onMouseEvent(e);
	}
}
