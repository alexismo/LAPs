package com.alexismorin.laps.grammar;

public interface GrammaticalPerson {
	/** return 1 to 6 (more as needed)
	 * 1 - I
	 * 2 - You (singular)
	 * 3 - He/She/It
	 * 4 - We
	 * 5 - You (plural)
	 * 6 - They
	 */
	int person();
}
