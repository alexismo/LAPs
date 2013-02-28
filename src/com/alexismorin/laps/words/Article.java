package com.alexismorin.laps.words;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.grammar.LinkTo;
import com.alexismorin.laps.grammar.errors.GrammaticalGenderError;
import com.alexismorin.laps.grammar.errors.NoNounError;

public class Article extends Word implements Grammar, IsArticle, LinkTo{
	Word linkToThis;
	
	public Article(String word) {
		super(word);
	}
	
	public boolean is_article(Word nextWord){
		if(nextWord instanceof Noun)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean do_grammar(Sentence s, int i) {
		this.errors.clear();
		Word nWord = s.getNextWord(i);
		
		if(nWord != null){
			
			if(nWord instanceof GrammaticalGender && this instanceof GrammaticalGender){
				String nGender;
				String thisGender;
				if(nWord instanceof GrammaticalGender){
					nGender = ((GrammaticalGender) nWord).gender();
					thisGender = ((GrammaticalGender) this).gender();
					
					if(!nGender.equals(thisGender)){
						this.errors.add(new GrammaticalGenderError());//adding the error to the article?
					}
				}
			}
			
			if(is_article(nWord)){
				linkToThis = nWord;
			}else{
				linkToThis = null;
				this.errors.add(new NoNounError());
			}
		}else{
			this.errors.add(new NoNounError());
		}
		
		if(this.errors.size() == 0)	
			return true;
		else
			return false;
	}

	@Override
	public boolean is_first_word() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is_last_word() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Word linkToWord() {
		return linkToThis;
	}
}
