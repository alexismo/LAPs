package com.alexismorin.laps.grammar;

public interface GrammaticalNumber {
	
	int number();
	/**
	 * @returns the grammatical number of a noun/pronoun
	 * 
	 * This should be expanded according to the language
	 * English supports: 1 or 1+
	 * Languages with a singular/dual/plural case (such as Arabic or Slovene) should support
	 * 1, 2, 2+[3]
	 * 
	 * Chinese...I have no idea how to deal with since pluralization is context specific
	 * and only partially affects sentence structure
	 */
}
