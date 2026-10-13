package geometry;
import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape {
	protected boolean selected;
	protected Color color = Color.BLACK;
	
	public Shape() {
		
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean contains(int x, int y);
	public abstract String toString();
	public abstract boolean equals(Object obj);
	
	
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color1) {
		color = color1;
	}
}
