package com.star.softdev.object;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject {

	public Block(int x, int y, int size) {
		super(x, y, size);
	}

	@Override
	public void hitProcessComponent(GameObject collision) {
		System.exit(1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), getSize(), getSize());
	}
}
