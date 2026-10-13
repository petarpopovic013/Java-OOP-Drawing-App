package geometry;

import java.awt.Graphics;
import java.awt.Color;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.selected = selected;
	}

	public String toString() {
		return startPoint.toString() + "-->" + endPoint.toString();
	}

	public boolean equals(Object obj) {

		if (obj instanceof Line) {
			Line secondLine = (Line) obj;
			if (this.startPoint.equals(secondLine.startPoint) && this.endPoint.equals(secondLine.endPoint)) {
				return true;
			}
		}
		return false;
	}

	public double lenght() {
		return startPoint.distance(endPoint);
	}
	
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		if(this.startPoint.distance(sadrziTacku) + this.endPoint.distance(sadrziTacku) - this.lenght() <= 2) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		
		if (isSelected()) {
	        g.setColor(Color.BLUE);
	        g.drawRect(startPoint.getX() - 4, startPoint.getY() - 4, 8, 8);
	        g.drawRect(endPoint.getX() - 4, endPoint.getY() - 4, 8, 8);
	    }
	}
	

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	

	

}
