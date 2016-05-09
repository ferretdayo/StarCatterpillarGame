package com.star.softdev.direction;

import com.star.softdev.object.GameObject;

public class DownDirection implements IDirection {
	@Override
	public void move(GameObject obj) {
		obj.setPosition(obj.getX(), obj.getY()+obj.getSize());
	}

	@Override
	public IDirection rotateRight() {
		return new LeftDirection();
	}

	@Override
	public IDirection againstDirection() {
		return new UpDirection();
	}

	@Override
	public IDirection rotateLeft() {
		return new RightDirection();
	}



}
