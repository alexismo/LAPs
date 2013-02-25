package com.alexismorin.laps;

import processing.core.PApplet;
import com.alexismorin.laps.Config;
import com.alexismorin.laps.mouse.MouseEvent;

public class LAPs extends PApplet {

	int sceneNo;
	Scene scene;
	Board board;

	/*
	 public static void main(String args[]) { 
		 // PApplet.main(new String[] {"--present", "MyProcessingSketch" }); 
		 PApplet.main(new String[] { "","LAPs" });
	 }
	 */

	public void setup() {
		size(Config.MAPWIDTH, Config.MAPHEIGHT);
		smooth();
		setupVariables();
	}

	public void draw() {
		switch (sceneNo) {
		case 1:
			scene.update();
			scene.draw();
		}
	}

	public void setupVariables() {
		board = new Board();
		board.makeWords();

		scene = new Scene(this, board);
		sceneNo = 1;
	}

	public void mousePressed() {
		MouseEvent m = new MouseEvent(Config.MOUSE_PRESSED, mouseX, mouseY);
		scene.onMouseEvent(m);
	}

	public void mouseReleased() {
		MouseEvent m = new MouseEvent(Config.MOUSE_RELEASED, mouseX, mouseY);
		scene.onMouseEvent(m);
	}

	public void mouseDragged() {
		MouseEvent m = new MouseEvent(Config.MOUSE_DRAGGED, mouseX, mouseY);
		scene.onMouseEvent(m);
	}
}