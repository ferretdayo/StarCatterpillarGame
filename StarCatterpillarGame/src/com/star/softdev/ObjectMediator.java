package com.star.softdev;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.star.softdev.object.GameObject;

/**
 * 繝｡繝�繧｣繧ｨ繝ｼ繧ｿ繝ｼ縺ｨ縺励※縲∬｡晉ｪ∫黄縺ｨ髱櫁｡晉ｪ∫黄縺ｮ蜃ｦ逅�縺ｮ蠖ｱ髻ｿ繧堤ｮ｡逅�
 *
 * @author Sakamoto
 *
 */

public class ObjectMediator {
	List<GameObject> _objs = new ArrayList<>();

	public void add(GameObject obj) {
		_objs.add(obj);
	}

	public void deleteObject(GameObject obj) {
		_objs.remove(obj);
	}

	public Iterator<GameObject> getObjectListIterator() {
		return _objs.iterator();
	}

	public void draw(Graphics g) {
		for (GameObject obj : _objs) {
			obj.draw(g);
		}
	}


	public boolean hitProcess(GameObject obj) {
		for (GameObject other : _objs) {
			if (other.hitProcess(obj)) return true;
		}
		return false;
	}

	public My2DPoint getRandomPoint() {
		Random rnd = new Random();
		int x;
		int y;
		My2DPoint p;
		while (true) {
			x = rnd.nextInt( GameSize.WINDOW_X / GameSize.DEFAULT_OBJECT_SIZE) * GameSize.DEFAULT_OBJECT_SIZE;
			y = rnd.nextInt(GameSize.WINDOW_Y / GameSize.DEFAULT_OBJECT_SIZE) * GameSize.DEFAULT_OBJECT_SIZE;
			boolean isHit = false;
			p = new My2DPoint(x, y);
			for (GameObject obj : _objs) {
				if (isHit = p.equals(obj.getPosition())) break;
			}
			if(!isHit) return p;
		}
	}

}
