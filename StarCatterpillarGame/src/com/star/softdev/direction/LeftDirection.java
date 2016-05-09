package com.star.softdev.direction;

import com.star.softdev.object.GameObject;

public class LeftDirection implements IDirection {

	public void move(GameObject obj) {
		obj.setPosition(obj.getX()-obj.getSize(), obj.getY());
	}

	@Override
	public IDirection rotateRight() {
		return new UpDirection();
	}

	@Override
	public IDirection againstDirection() {
		return new RightDirection();
	}

	@Override
	public IDirection rotateLeft() {
		return new DownDirection();
	}

}
