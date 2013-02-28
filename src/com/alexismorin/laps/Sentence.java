package com.alexismorin.laps;

import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.errors.NoVerbInSentenceError;
import com.alexismorin.laps.grammar.errors.SentenceError;
import com.alexismorin.laps.grammar.errors.StartsWithError;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Sentence {
	WordList sentenceWords;
	boolean hasErrors = false;
	ArrayList<SentenceError> errors;

	public Sentence() {
		errors = new ArrayList<SentenceError>();
		sentenceWords = new WordList();
	}

	public void setWords(ArrayList<Word> newWords) {
		sentenceWords.clear();
		sentenceWords = new WordList();

		sentenceWords.addAll(newWords);
	}

	@Override
	public String toString() {
		String sentence = "";

		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			String s = w.getWord();

			if (i == 0) {// capitalize
				s = WordUtils.capitalize(s);
			}
			if (i == sentenceWords.size() - 1) {
				sentence += s + ".";// add period
			} else {
				sentence += s + " ";// add a space
			}
		}

		return sentence;
	}

	public void checkSentenceGrammar() {
		hasErrors = false;
		errors.clear();
		boolean hasVerb = false;

		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			if (w instanceof Grammar && w.snapped) {
				Word prevW = getPrevWord(i);
				Word nextW = getNextWord(i);

				// start checking for sentence-wide errors
				if (i == 0) {// for starting word
					if (w instanceof Pronoun /* && w instanceof Time */) {
					} else {
						errors.add(new StartsWithError());
					}
				}

				if (w instanceof Verb && !hasVerb) {
					hasVerb = true;
				}

			}
		}
		
		if (!hasVerb) {
			NoVerbInSentenceError e = new NoVerbInSentenceError();
			if (!errors.contains(e))
				errors.add(e);
		}

		if (errors.size() > 0) {
			hasErrors = true;
		}
	}

	public Word getNextWord(int i) {
		if (i < sentenceWords.size() - 1) {
			return sentenceWords.get(i + 1);
		} else {
			return null;
		}
	}

	public Word getPrevWord(int i) {
		if (i > 0) {
			return sentenceWords.get(i - 1);
		} else {
			return null;
		}
	}
}
