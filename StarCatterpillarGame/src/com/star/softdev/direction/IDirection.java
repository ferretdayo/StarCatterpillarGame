package com.star.softdev.direction;

import com.star.softdev.object.GameObject;

public interface IDirection {
	public void move(GameObject obj);
	public IDirection rotateRight();
	public IDirection rotateLeft();
	public IDirection againstDirection();
}


