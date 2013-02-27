package com.alexismorin.laps.grammar;

import com.alexismorin.laps.Sentence;
import com.alexismorin.laps.words.Word;

public interface Grammar {
/**
 * A series of grammatical requirements.
 */
	boolean do_grammar(Sentence sentence, int wordIndex);
}
