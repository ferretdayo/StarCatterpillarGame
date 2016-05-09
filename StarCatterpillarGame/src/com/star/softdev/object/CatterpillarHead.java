package com.star.softdev.object;

import java.awt.Color;
import java.awt.Graphics;

public class CatterpillarHead extends CatterpillarNode {
	public CatterpillarHead(int x, int y, int size) {
		super(x, y, size);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(getX(), getY(), getSize(), getSize());
	}

	@Override
	public void hitProcessComponent(GameObject collision) {
		System.exit(1);
	}

	public void move() {
		move(getDirection());
	}
	
}
