package geometry;
import java.awt.Color;
import java.awt.Graphics;


public class Circle extends Shape {

	protected Point center;
	protected int radius;
	protected Color innerColor;
	
	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this.center = center;
		this.radius = radius;
		this.selected = selected;
	}
	
	
	public String toString() {
		return("Center: " + center.toString() + ", Radius: " + radius);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle secondcircle = (Circle) obj;
			if(this.center.equals(secondcircle.center) && this.radius == secondcircle.radius) {
				return true;
			}
		}
		return false;
	}

	
	
	public boolean contains(int x, int y) {
		return(this.center.distance(new Point(x, y)) <= this.radius);
	}
	
	public boolean contains(Point point) {
		return(this.center.distance(point)<=this.radius);
	}
	
	
	
	@Override
	public void draw(Graphics g) {
	    g.setColor(innerColor);
	    g.fillOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);

	    g.setColor(getColor());
	    g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
	    
	    
	    if (isSelected()) {

	        g.setColor(Color.BLUE);

	        g.drawRect(center.getX() - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() - radius - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() + radius - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() - 4, center.getY() - radius - 4, 8, 8);
	        g.drawRect(center.getX() - 4, center.getY() + radius - 4, 8, 8);
	    }
	}
	
	
	
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	

	

	

}
