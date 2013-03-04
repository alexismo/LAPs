package com.alexismorin.laps.words.verbs;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.grammar.Conjugable;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.GrammaticalPerson;
import com.alexismorin.laps.grammar.Subjecting;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

public class Eat_Word extends Verb implements Conjugable, Grammar{

	public Eat_Word() {
		super("to eat");
	}
	
	@Override
	public String conjugate(int person, String tense) {
		/**
		 * @returns conjugated form of the verb
		 */
		if (tense.equals("present")) {
			switch (person) {
			case 1:
				return "eat";
			case 2:
				return "eat";
			case 3:
				return "eats";
			case 4:
				return "eat";
			case 5:
				return "eat";
			case 6:
				return "eat";
			default:
				break;
			}
		}
		
		if (tense.equals("past")) {
			return "ate";
		}
		
		if(tense.equals("infinitive")){
			return "to eat";
		}

		return null;
	}
	
	@Override
	public boolean do_grammar(Sentence sentence, int i) {
		int gramPerson;
		Word prevWord = sentence.getPrevWord(i);
		String tense = sentence.findTimeIndicator();
		
		//previous word should be of a grammatical person and be a potential subject
		if (prevWord instanceof GrammaticalPerson && prevWord instanceof Subjecting){
			gramPerson = ((GrammaticalPerson) prevWord).person();
			
			this.setWord(this.conjugate(gramPerson, tense));
			return true;
		}
		else{
			this.setWord(this.conjugate(0, "infinitive"));
			return false;
		}
	}

}
