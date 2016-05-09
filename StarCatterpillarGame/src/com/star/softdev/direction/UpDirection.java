package com.star.softdev.direction;

import com.star.softdev.object.GameObject;

public class UpDirection implements IDirection {
	public void move(GameObject obj) {
		obj.setPosition(obj.getX(), obj.getY()-obj.getSize());
	}

	@Override
	public IDirection rotateRight() {
		return new RightDirection();
	}

	@Override
	public IDirection againstDirection() {
		return new DownDirection();
	}

	@Override
	public IDirection rotateLeft() {
		return new LeftDirection();
	}

}
