package com.alexismorin.laps.words.articles;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Actionnable;
import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.grammar.IsSuffix;
import com.alexismorin.laps.grammar.errors.NoNounError;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Word;

public class En_Word extends Article implements GrammaticalGender, GrammaticalNumber, IsSuffix {
	Word linkToThis;
	boolean isSuffix;
	
	public En_Word() {
		super("en");
		linkToThis = null;
		isSuffix = false;
	}
	
	@Override 
	public boolean do_grammar(Sentence s, int i){
		this.errors.clear();
		Word nWord = s.getNextWord(i);
		Word pWord = s.getPrevWord(i);
		
		if(nWord instanceof Definiteness || pWord instanceof Definiteness){
			
			if(nWord instanceof Definiteness){
				isSuffix = false;
				linkToThis = nWord;
			}
			
			if(pWord instanceof Definiteness){
				isSuffix = true;
				linkToThis = pWord;
			}
			
			return true;
		}else{
			this.errors.add(new NoNounError());
			return false;
		}
	}
	
	@Override
	public String gender() {
		return "common";
	}

	@Override
	public int number() {
		return 1;
	}
	
	@Override
	public Word linkToWord() {
		return linkToThis;
	}

	@Override
	public boolean isSuffix() {
		return isSuffix;
	}
}