package com.alexismorin.laps.words;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.IsArticle;

public class Article extends Word implements Grammar, IsArticle{

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
	public boolean do_grammar(Word previousWord, Word nextWord) {
		if(nextWord != null){
			if(is_article(nextWord)){
				return true;
			}else{
				return false;
			}
		}
		
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

}
