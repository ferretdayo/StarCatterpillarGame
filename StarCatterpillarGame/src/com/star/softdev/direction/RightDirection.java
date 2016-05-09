package com.star.softdev.direction;

import com.star.softdev.object.GameObject;

public class RightDirection implements IDirection {

	public void move(GameObject obj) {
		obj.setPosition(obj.getX() + obj.getSize(), obj.getY());
	}

	@Override
	public IDirection rotateRight() {
		return new DownDirection();
	}

	@Override
	public IDirection againstDirection() {
		return new LeftDirection();
	}

	@Override
	public IDirection rotateLeft() {
		return new UpDirection();
	}

}
