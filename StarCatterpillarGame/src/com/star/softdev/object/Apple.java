package com.star.softdev.object;

import java.awt.Color;
import java.awt.Graphics;

import com.star.softdev.My2DPoint;

public class Apple extends GameObject {

	public Apple(int x, int y, int size) {
		super(x, y, size);
	}

	@Override
	public void hitProcessComponent(GameObject collision) {
		Class<? extends GameObject> collisionClass = collision.getClass();
		if(collisionClass == CatterpillarHead.class) {
			hitProcessComponent((CatterpillarHead)collision);
		}
	}

	public void hitProcessComponent(CatterpillarHead collision) {
			CatterpillarHead _head = (CatterpillarHead)collision;
			My2DPoint nextApplePoint = _objMed.getRandomPoint();
			setPosition(nextApplePoint.getX(), nextApplePoint.getY());
			_objMed.add(_head.createNewNode());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(getX(), getY(), getSize(), getSize());
	}
}
