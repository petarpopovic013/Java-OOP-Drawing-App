package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;
	private Color innerColor = Color.WHITE;


	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;

	}

	// Povrsina pravougaonika P=w*h
	public int area() {
		return width * height;
	}

	// Obim pravougaonika O=2*(w+h)
	public int circumference() {
		return 2 * (width + height);
	}

	public String toString() {
		return upperLeftPoint.toString() + " W: " + width + " H: " + height;
	}

	public boolean equals(Object obj) {

		if (obj instanceof Rectangle) {
			Rectangle secondRect = (Rectangle) obj;
			if (secondRect.upperLeftPoint.equals(this.upperLeftPoint) && secondRect.width == this.width
					&& secondRect.height == this.height) {
				return true;
			}
		}
		return false;
	}

	
	public boolean contains(int x, int y) {
		return(x >= this.upperLeftPoint.getX() && x <= this.upperLeftPoint.getX() + width && y>= this.upperLeftPoint.getY() && y<= this.upperLeftPoint.getY()+height);
	}
	
	public boolean contains(Point point) {
		return(point.getX() >= this.upperLeftPoint.getX() && point.getX() <= this.upperLeftPoint.getX() + width && point.getY()>= this.upperLeftPoint.getY() && point.getY()<= this.upperLeftPoint.getY()+height);
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(innerColor);
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		
		if (isSelected()) {
	        g.setColor(Color.BLUE);
	        g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() - 3, 6, 6);
	        g.drawRect(upperLeftPoint.getX() + width - 3, upperLeftPoint.getY() - 3, 6, 6);
	        g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() + height - 3, 6, 6);
	        g.drawRect(upperLeftPoint.getX() + width - 3, upperLeftPoint.getY() + height - 3, 6, 6);
	    }
	}
	
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}
	
	


	public void setHeight(int height) {
		this.height = height;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	

	

}
