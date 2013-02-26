package com.alexismorin.laps;

import com.alexismorin.laps.grammar.Grammar;
import com.alexismorin.laps.grammar.IsArticle;
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

		for (int i = 0; i < board.words.size(); i++) {
			Word w = board.words.get(i);

			parent.stroke(0);

			// check for pronouns associated to verbs
			/*if (w instanceof Pronoun && w instanceof Subjecting
					&& i < board.words.size() - 1) {// can't be the last word
				Word nextWord = board.words.get(i + 1);
				if (((Pronoun) w).is_subject(nextWord)) {
					parent.stroke(38, 133, 36);// paint it green
					// draw a line from the subject to the verb
					parent.line(w.pos.x + Config.wordSize / 2, w.pos.y
							+ Config.wordSize / 2, nextWord.pos.x
							+ Config.wordSize / 2, nextWord.pos.y
							+ Config.wordSize / 2);
				}
			}*/

			if (w instanceof Grammar) {//if the word has specific grammar to it
				Word prevWord = null;
				Word nextWord = null;
				if(i < board.words.size()-1)
					nextWord = board.words.get(i + 1);
				if(i > 0)
					prevWord = board.words.get(i-1);
				
				if ( w.do_grammar(prevWord, nextWord)){
					parent.stroke(38, 133, 36);// paint it green
					// draw a line from the subject to the verb
					parent.line(w.pos.x + Config.wordSize / 2, w.pos.y
							+ Config.wordSize / 2, nextWord.pos.x
							+ Config.wordSize / 2, nextWord.pos.y
							+ Config.wordSize / 2);
				}else{
					parent.stroke(205, 24, 24);// paint it red
				}
			}

			parent.fill(200);
			parent.rect(w.pos.x, w.pos.y, Config.wordSize, Config.wordSize);

			// draw the words from the tiles
			parent.fill(0);
			parent.text(w.word, w.pos.x + 10, w.pos.y + Config.wordSize / 2);
			// parent.text(String.valueOf(i), w.pos.x + 10, w.pos.y +
			// Config.wordSize / 3);

			// draw the Sentence
			parent.text(board.getSentence(), parent.width / 2,
					parent.height - 100);
		}
	}

	private boolean checkNextWordIs(int index, Class checkForClass) {
		Word w = board.words.get(index);

		return w.getClass().equals(checkForClass.getClass());
	}

	void onMouseEvent(MouseEvent e) {
		board.onMouseEvent(e);
	}
}
