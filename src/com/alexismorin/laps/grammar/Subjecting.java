package com.alexismorin.laps.grammar;

import com.alexismorin.laps.words.Word;

public interface Subjecting {
	/** 
	 * Returns whether or not the word can be used as a grammatical subject.
	 * Sticking with Pronouns for now. 
	 */
	boolean is_subject(Word followingWord);
}