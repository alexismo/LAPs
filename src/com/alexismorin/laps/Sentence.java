package com.alexismorin.laps;

import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;

import com.alexismorin.laps.words.Word;

public class Sentence {
	WordList sentenceWords;
	
	public Sentence(){
		sentenceWords = new WordList();
	}
	
	public void setWords(ArrayList<Word> newWords){
		sentenceWords.clear();
		sentenceWords.addAll(newWords);
	}
	
	public String getSentence(){
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
}
