package com.alexismorin.laps.words.nouns;

import java.util.ArrayList;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Actionnable;
import com.alexismorin.laps.grammar.Definiteness;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.Pluralizable;
import com.alexismorin.laps.grammar.errors.GrammaticalGenderError;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Noun;
import com.alexismorin.laps.words.Word;

public class Tomat_Word extends Noun implements Actionnable, Pluralizable, Definiteness, GrammaticalGender{

	private String definiteness;
	
	public Tomat_Word() {
		super("tomat");
		definiteness = "none";
	}

	@Override
	public ArrayList<String> action_categories() {
		ArrayList<String> categories = new ArrayList<String>();
		
		categories.add("food");
		categories.add("physical");
		categories.add("small");
		
		return categories;
	}
	
	@Override
	public String pluralize(int number) {
		if(number > 1){
			this.setWord("tomater");
		}else{
			this.setWord("tomat");
		}
		return this.getWord();
	}

	@Override
	public boolean do_grammar(Sentence s, int i) {
		this.errors.clear();
		
		int gramNumber;
		Word pWord = s.getPrevWord(i);
		Word nWord = s.getNextWord(i);
		if ((pWord instanceof Article || nWord instanceof Article) && 
				(pWord instanceof GrammaticalGender || nWord instanceof GrammaticalGender)){
			
			if(pWord instanceof GrammaticalGender){
				if(! ((GrammaticalGender)pWord).gender().equals(this.gender()) ){
					this.errors.add(new GrammaticalGenderError());
					return false;
				}
			}
			
			if(nWord instanceof GrammaticalGender){
				if(! ((GrammaticalGender)nWord).gender().equals(this.gender()) ){
					this.errors.add(new GrammaticalGenderError());
					return false;
				}
			}
		}
		
		if(nWord instanceof Article){
				this.definiteness = "definite";
				return true;
		}
		
		if(pWord instanceof Article){
			this.definiteness = "indefinite";
			return true;
		}
		
		return false;
	}

	@Override
	public String definiteness() {
		return this.definiteness;
	}

	@Override
	public String gender() {
		return "common";
	}
}
