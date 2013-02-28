package com.alexismorin.laps.nouns;

import java.util.ArrayList;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Actionnable;
import com.alexismorin.laps.grammar.GrammaticalGender;
import com.alexismorin.laps.grammar.GrammaticalNumber;
import com.alexismorin.laps.grammar.GrammaticalPerson;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.grammar.Pluralizable;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Noun;
import com.alexismorin.laps.words.Word;

public class Pomme_Word extends Noun implements Actionnable, Pluralizable, GrammaticalGender{

	public Pomme_Word() {
		super("pomme");
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
			this.setWord("pommes");
		}else{
			this.setWord("pomme");
		}
		return this.getWord();
	}
	
	@Override
	public boolean do_grammar(Sentence s, int i) {
		int gramNumber;
		Word pWord = s.getPrevWord(i);
		if (pWord instanceof GrammaticalNumber && (pWord instanceof Article /* pWord instanceof Adjective*/)){
			gramNumber = ((GrammaticalNumber) pWord).number();
			
			this.setWord(this.pluralize(gramNumber));
			return true;
		}
		
		return false;
	}

	@Override
	public String gender() {
		return "feminin";
	}
}
