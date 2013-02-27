package com.alexismorin.laps.words;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.grammar.LinkTo;

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
		Word nWord = s.getNextWord(i);
		if(nWord != null){
			if(is_article(nWord)){
				grammarOK = true;
				linkToThis = nWord;
				return true;
			}else{
				grammarOK = false;
				linkToThis = null;
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

	@Override
	public Word linkToWord() {
		return linkToThis;
	}
}
