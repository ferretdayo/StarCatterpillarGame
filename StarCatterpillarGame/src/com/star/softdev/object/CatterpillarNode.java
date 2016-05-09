package com.star.softdev.object;

import java.awt.Color;
import java.awt.Graphics;

import com.star.softdev.direction.IDirection;
import com.star.softdev.direction.UpDirection;

public class CatterpillarNode extends GameObject {
	private CatterpillarNode _next;
	private IDirection _direction = new UpDirection();

	public CatterpillarNode(int x, int y, int size) {
		super(x, y, size);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(getX(), getY(), getSize(), getSize());
	}

	@Override
	public void hitProcessComponent(GameObject collision) {
		System.exit(1);
	}

	public void setNextNode(CatterpillarNode next) {
		_next = next;
	}

	public CatterpillarNode getNextNode() {
		return _next;
	}

	public void setDirection(IDirection direction) {
		_direction = direction;
	}

	public IDirection getDirection() {
		return _direction;
	}

	public void rotateRight() {
		_direction = _direction.rotateRight();
	}

	public void rotateLeft() {
		_direction = _direction.rotateLeft();
	}

	public void move(IDirection nextDirection) {
		if (_next != null) {
			_next.move(_direction);
		}
		_direction.move(this);
		_direction = nextDirection;
	}

	public CatterpillarNode createNewNode() {
		if(_next != null) {
			return _next.createNewNode();
		} else {
			CatterpillarNode newNode = new CatterpillarNode(getX(), getY(), getSize());
			newNode.setDirection(_direction);
			newNode.move(_direction.againstDirection());
			_next = newNode;
			return newNode;
		}
	}

}
