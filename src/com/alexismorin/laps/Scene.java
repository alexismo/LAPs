package com.alexismorin.laps;

import com.alexismorin.laps.grammar.Conjugable;
import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.IsArticle;
import com.alexismorin.laps.grammar.LinkTo;
import com.alexismorin.laps.grammar.Pluralizable;
import com.alexismorin.laps.grammar.Subjecting;
import com.alexismorin.laps.mouse.MouseEvent;
import com.alexismorin.laps.words.Article;
import com.alexismorin.laps.words.Pronoun;
import com.alexismorin.laps.words.Verb;
import com.alexismorin.laps.words.Word;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class Scene {
	PApplet parent;
	PFont ubuntu;
	Board board;

	public Scene(PApplet p, Board board) {
		super();
		this.parent = p;
		this.board = board;
		ubuntu = parent.loadFont("Ubuntu-24.vlw");
	}

	void update() {
		for (int i = 0; i < board.words.size(); i++) {
			Word w = board.words.get(i);
			if (w.pos == null) {// create a default position for the words.
								// simplifies instanciation
				w.pos = new PVector(100 * (i + 1) + 20, 100);
			}

			if (!w.snapped) {//change the words back to singular / infinitive forms
				
				if (w instanceof Conjugable) {
					w.setWord(((Conjugable) w).conjugate(0, "infinitive"));
				}
				
				if (w instanceof Pluralizable) {
					w.setWord(((Pluralizable) w).pluralize(1));
				}
			}
			
		}
	}

	void draw() {
		parent.background(255);
		parent.strokeWeight(2);
		parent.noFill();
		parent.ellipseMode(parent.CENTER);

		// draw the word line
		parent.stroke(38, 133, 36);
		parent.line(0, parent.height / 2, parent.width, parent.height / 2);

		// draw tiles
		drawTiles();
	}

	void drawTiles() {
		parent.rectMode(parent.CORNER);
		parent.textFont(ubuntu, 24);

		// not useful for now
		Sentence sentence = board.makeSentence();
		sentence.checkSentenceGrammar();

		for (int i = 0; i < board.words.size(); i++) {
			Word w = board.words.get(i);

			parent.stroke(0);// paint word outline the default color: black

			if (w.snapped) {
				Word nextW = board.words.getNextSnapped(i);
				Word prevW = board.words.getPrevSnapped(i);
				if (w.do_grammar(prevW, nextW)) {
					parent.stroke(38, 133, 36);// paint it green for correct
												// grammar
					// draw a bezier, like a bawss
					if (w instanceof LinkTo) {
						drawBezier(w, ((LinkTo) w).linkToWord());
					}

				} else {
					parent.stroke(205, 24, 24);// paint it red for bad grammar
				}
			}

			// finish drawing the tile
			parent.fill(200);
			parent.rect(w.pos.x, w.pos.y, Config.wordSize, Config.wordSize);

			// draw the words from the tiles
			parent.fill(0);
			parent.text(w.getWord(), w.pos.x + 10, w.pos.y + Config.wordSize
					/ 2);
			// parent.text(String.valueOf(i), w.pos.x + 10, w.pos.y +
			// Config.wordSize / 3);

		}
		// draw the Sentence
		parent.text(board.getSentenceString(), parent.width / 2,
				parent.height - 100);
	}

	void drawBezier(Word w1, Word w2) {
		// center of the 1st word
		parent.noFill();
		parent.bezier(w1.pos.x + Config.wordSize / 2, w1.pos.y
				+ Config.wordSize / 2, w1.pos.x + Config.wordSize / 2, w1.pos.y
				- Config.wordSize, w2.pos.x + Config.wordSize / 2, w2.pos.y
				- Config.wordSize, w2.pos.x + Config.wordSize / 2, w2.pos.y
				+ Config.wordSize / 2);
	}

	void onMouseEvent(MouseEvent e) {
		board.onMouseEvent(e);
	}
}
