package com.alexismorin.laps;

import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;

import com.alexismorin.laps.grammar.Grammar;
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
	
	@Override
	public String toString(){
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
	
	public void checkSentenceGrammar(){
		for (int i = 0; i < sentenceWords.size(); i++) {
			Word w = sentenceWords.get(i);
			if(w instanceof Grammar && w.snapped){
				Word prevW = getPrevWord(i);
				Word nextW = getNextWord(i);
				
				w.grammarOK = w.do_grammar(prevW, nextW);
			}
		}
	}
	
	public Word getNextWord(int i) {
		if(i <= sentenceWords.size()-1){
			return sentenceWords.get(i);
		}else{
			return null;
		}
	}
	
	public Word getPrevWord(int i) {
		if(i > 0){
			return sentenceWords.get(i);
		}else{
			return null;
		}
	}
}
