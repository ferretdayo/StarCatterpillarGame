package com.star.softdev;

/**
 * 二次座標の位置を表すクラス *
 *
 * @author Sakamoto
 *
 */

public class My2DPoint {
	// メモ 位置を配列にすれば、3次元にも対応可？
	private int _x;
	private int _y;

	public My2DPoint(int x, int y) {
		this._x = x;
		this._y = y;
	}

	public int getX() {
		return _x;
	}
	public void setX(int x) {
		_x = x;
	}

	public int getY() {
		return _y;
	}
	public void setY(int y) {
		_y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		My2DPoint other = (My2DPoint) obj;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}

	public My2DPoint copyPosition() {
		return new My2DPoint(_x, _y);
	}
}
