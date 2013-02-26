package com.alexismorin.laps.grammar;

import com.alexismorin.laps.words.Word;

public interface Grammar {
/**
 * A series of grammatical requirements.
 */
	boolean do_grammar(Word previousWord, Word nextWord);
	
	boolean is_first_word();
	
	boolean is_last_word();
}
