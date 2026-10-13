package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Point extends Shape {

	private int x;
	private int y;


	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}

	public String toString() {
		return "(" + x + "," + y + ")";

	}

	public boolean equals(Object obj) {

		if (obj instanceof Point) {
			Point secondPoint = (Point) obj;
			if (secondPoint.x == this.x && secondPoint.y == this.y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if(this.distance(new Point(x, y)) <= 2) {
			return true;
		}
		return false;
	}
	

	public double distance(Point point2) {
		double a = this.x - point2.x;
		double b = this.y - point2.y;
		double c = Math.sqrt(a * a + b * b);
		return c;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		
		if (isSelected()) {
	        g.setColor(Color.BLUE);
	        g.drawRect(x - 4, y - 4, 8, 8);
	    }
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	

}