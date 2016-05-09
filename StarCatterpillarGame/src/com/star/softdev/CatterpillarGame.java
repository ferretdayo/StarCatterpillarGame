package com.star.softdev;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.star.softdev.object.Apple;
import com.star.softdev.object.Block;
import com.star.softdev.object.CatterpillarHead;
import com.star.softdev.object.CatterpillarNode;

public class CatterpillarGame extends Applet implements Runnable, KeyListener {
	private static final long serialVersionUID = 1000L;
	Thread thread = null;
	Dimension size;
	Image back;
	Graphics g;

	CatterpillarHead _head;

	ObjectMediator _objMed = new ObjectMediator();

	public CatterpillarGame() {
		setBlock();
		setCatterpillar();
		setApple();

		thread = new Thread(this);
		thread.start();
		addKeyListener(this);
	}

	private void setBlock() {
		int BLOCK_SIZE = GameSize.DEFAULT_OBJECT_SIZE;
		for (int y = 0; y < GameSize.WINDOW_Y; y += BLOCK_SIZE) {
			for (int x = 0; x < GameSize.WINDOW_X; x += BLOCK_SIZE) {
				if ((y == 0 | y == GameSize.WINDOW_Y - BLOCK_SIZE) | (x == 0 | x == GameSize.WINDOW_X - BLOCK_SIZE)) {
					Block b = new Block(x, y, BLOCK_SIZE);
					_objMed.add(b);
				}
			}
		}
	}

	private void setApple() {
		Apple apple = new Apple(300, 300, GameSize.DEFAULT_OBJECT_SIZE);
		apple.setObjectMediator(_objMed);
		_objMed.add(apple);
	}

	private void setCatterpillar() {
		_head = new CatterpillarHead(100, 400, GameSize.DEFAULT_OBJECT_SIZE);
		_objMed.add(_head);
		CatterpillarNode second = _head.createNewNode();
		_objMed.add(second);
	}

	public void paint(Graphics g) {
		super.paint(g);
		_objMed.draw(g);
	}

	public static void main(String args[]) {
		new CatterpillarGame();

	}

	@Override
	public void run() {
		while (true) {
			_head.move();
			_objMed.hitProcess(_head);
			repaint();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				_head.rotateRight();
				break;
			case KeyEvent.VK_LEFT:
				_head.rotateLeft();
				break;
			case KeyEvent.VK_DOWN:
				CatterpillarNode node = _head.createNewNode();
				_objMed.add(node);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
