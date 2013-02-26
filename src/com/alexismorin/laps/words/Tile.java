package com.alexismorin.laps.words;

import processing.core.PVector;

public class Tile {
	public PVector pos;

	public boolean snapped = false;
	public int size;

	public Tile(){
		
	}
	
	public Tile(PVector pos) {
		this.pos = pos;
	}

	void update() {
	}
}
