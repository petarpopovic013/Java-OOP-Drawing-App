package gui;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import geometry.Shape;

public class PnlDrawing extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape selectedShape;
	public PnlDrawing() {
		setFocusable(true);
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}

	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

}