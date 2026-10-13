package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;
	private Color innerColor;

	public Donut() {
		super();
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;

	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	
	public double area(){
		return(super.area() - this.innerRadius*this.innerRadius*Math.PI);
	}
	
	

	public String toString() {
		return(super.toString() + ", Inner Radius " + this.innerRadius);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocni = (Donut) obj;
			if(super.equals(pomocni) && pomocni.getInnerRadius() == this.innerRadius) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return(super.contains(x, y) && this.getCenter().distance(new Point(x, y)) >= innerRadius);
	}
	
	
	public boolean contains(Point point) {
		return(super.contains(point) && this.getCenter().distance(point) >= innerRadius);
	}
	
	
	@Override
	public void draw(Graphics g) {
	    // spoljasnji krug unutrasnja boja donut-a
	    g.setColor(getInnerColor());
	    g.fillOval(getCenter().getX() - getRadius(), getCenter().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
	    // rupa boja pozadine panela
	    g.setColor(Color.WHITE);
	    g.fillOval(getCenter().getX() - innerRadius,getCenter().getY() - innerRadius,innerRadius * 2,innerRadius * 2);
	    // ivica spoljasnjeg kruga
	    g.setColor(getColor());
	    g.drawOval(getCenter().getX() - getRadius(),getCenter().getY() - getRadius(),getRadius() * 2,getRadius() * 2);
	    // ivica unutrasnjeg kruga
	    g.drawOval(getCenter().getX() - innerRadius,getCenter().getY() - innerRadius,innerRadius * 2,innerRadius * 2);
	    
	    if (isSelected()) {
	        g.setColor(Color.BLUE);
	        g.drawRect(center.getX() - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() - radius - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() + radius - 4, center.getY() - 4, 8, 8);
	        g.drawRect(center.getX() - 4, center.getY() - radius - 4, 8, 8);
	        g.drawRect(center.getX() - 4, center.getY() + radius - 4, 8, 8);
	    }
	}
	
	
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}
