package com.star.softdev.object;

import java.awt.Graphics;

import com.star.softdev.My2DPoint;
import com.star.softdev.ObjectMediator;

public abstract class GameObject {
	protected ObjectMediator _objMed;

	private My2DPoint _p;

	private int _size;

	public GameObject(int x, int y, int size) {
		_p = new My2DPoint(x, y);
		_size = size;
	}

	public void setObjectMediator(ObjectMediator objMed) {
		_objMed = objMed;
	}

	public My2DPoint getPosition() {
		return _p.copyPosition();
	}

	public void setPosition(My2DPoint p) {
		_p = p.copyPosition();
	}

	public void setPosition(int x, int y) {
		_p.setX(x);
		_p.setY(y);
	}

	public void setX(int x) {
		_p.setX(x);
	}

	public void setY(int y) {
		_p.setY(y);
	}

	public int getX() {
		return _p.getX();
	}

	public int getY() {
		return _p.getY();
	}

	public int getSize() {
		return _size;
	}

	public void changeSize(int size) {
		_size = size;
	}

	public boolean isHit(GameObject gameObj) {
		if (this == gameObj)
			return false;
		return _p.equals(gameObj.getPosition());
	}

	public boolean hitProcess(GameObject collision) {
		boolean isHit = isHit(collision);
		if (isHit) {
			hitProcessComponent(collision);
		}
		return isHit;
	}

	abstract protected void hitProcessComponent(GameObject collision);

	abstract public void draw(Graphics g);
}
