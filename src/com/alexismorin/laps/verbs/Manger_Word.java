package com.alexismorin.laps.verbs;

import com.alexismorin.laps.Sentence;
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
	public boolean do_grammar(Sentence sentence, int i) {
		int gramPerson;
		Word prevWord = sentence.getPrevWord(i);
		
		//previous word should be of a grammatical person and be a potential subject
		if (prevWord instanceof GrammaticalPerson && prevWord instanceof Subjecting){
			gramPerson = ((GrammaticalPerson) prevWord).person();
			
			this.setWord(this.conjugate(gramPerson, "present"));
			return true;
		}
		else{
			this.setWord(this.conjugate(0, "infinitive"));
			return false;
		}
	}
}
