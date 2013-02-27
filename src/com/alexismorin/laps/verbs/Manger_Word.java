package com.alexismorin.laps.verbs;

import com.alexismorin.laps.grammar.Conjugable;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.GrammaticalPerson;
import com.alexismorin.laps.grammar.Subjecting;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Manger_Word extends Verb implements Conjugable, Grammar {

	public Manger_Word() {
		super("manger");
	}

	@Override
	public String conjugate(int person, String tense) {
		/**
		 * @returns conjugated form of the verb
		 */
		if (tense.equals("present")) {
			switch (person) {
			case 1:
				return "mange";
			case 2:
				return "manges";
			case 3:
				return "mange";
			case 4:
				return "mangeons";
			case 5:
				return "mangez";
			case 6:
				return "mangent";
			default:
				break;
			}
		}
		
		if(tense.equals("infinitive")){
			return "manger";
		}

		return null;
	}

	@Override
	public boolean do_grammar(Word previousWord, Word nextWord) {
		int gramPerson;
		
		if (previousWord instanceof GrammaticalPerson){
			gramPerson = ((GrammaticalPerson) previousWord).person();
			
			this.setWord(this.conjugate(gramPerson, "present"));
			return true;
		}
		else{
			this.setWord(this.conjugate(0, "infinitive"));
			return false;
		}
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
