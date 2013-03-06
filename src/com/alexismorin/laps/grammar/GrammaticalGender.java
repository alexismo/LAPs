package com.alexismorin.laps.grammar;

public interface GrammaticalGender {
	/**
	 * 
	 * @return String "masculin", "feminin", "neuter"(das, ett), "common"(en)
	 * Will vary according to language
	 * http://en.wikipedia.org/wiki/Swedish_grammar#Articles_and_definite_forms
	 */
	String gender();
}
