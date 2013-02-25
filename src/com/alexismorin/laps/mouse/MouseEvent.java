package com.alexismorin.laps.mouse;

import processing.core.PVector;

public class MouseEvent{
	public PVector mousePos;
	public int type;

	public MouseEvent(int type, int posX, int posY) {
		this.type = type;
		mousePos = new PVector(posX, posY);
	}
}
