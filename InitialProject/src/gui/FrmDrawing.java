package gui;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import geometry.Point;
import geometry.Line;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

    private PnlDrawing pnlDrawing;

    private JToggleButton tglPoint;
    private JToggleButton tglLine;
    private JToggleButton tglRectangle;
    private JToggleButton tglCircle;
    private JToggleButton tglDonut;
    private JToggleButton tglSelect;

    private JButton btnModify;
    private JButton btnDelete;
    
    private Point startPoint = null;

    public FrmDrawing() {
        setTitle("Popovic Petar IT-10/2025"); 
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tglPoint = new JToggleButton("Point");
        panel.add(tglPoint);

        tglLine = new JToggleButton("Line");
        panel.add(tglLine);

        tglRectangle = new JToggleButton("Rectangle");
        panel.add(tglRectangle);

        tglCircle = new JToggleButton("Circle");
        panel.add(tglCircle);

        tglDonut = new JToggleButton("Donut");
        panel.add(tglDonut);

        tglSelect = new JToggleButton("Select");
        panel.add(tglSelect);

        btnModify = new JButton("Modify");
        btnModify.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(pnlDrawing.getSelectedShape() == null) {
        			JOptionPane.showMessageDialog(FrmDrawing.this, "Please select shape first.", "Warning", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		
        		int option = JOptionPane.showConfirmDialog(FrmDrawing.this, "Are you sure you want to modify selected shape?", "Delete conformation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        		if (option == JOptionPane.YES_OPTION) {
        			if(pnlDrawing.getSelectedShape() instanceof Point) {
        				DlgPoint dlg = new DlgPoint();
        				Point point = (Point) pnlDrawing.getSelectedShape();
                    	dlg.setXValue(((Point) pnlDrawing.getSelectedShape()).getX());
                    	dlg.setYValue(((Point) pnlDrawing.getSelectedShape()).getY());
                    	dlg.setCoordinatesEditable(true);

                    	dlg.setVisible(true);
                    	if (dlg.isConfirmed()) {
                    		point.setX(dlg.getXValue());
                    		point.setY(dlg.getYValue());
                    		point.setColor(dlg.getBorderColor());
                    	}
                    	point.setSelected(false);
                        pnlDrawing.setSelectedShape(null);
                        pnlDrawing.repaint();
        			}
        			else if(pnlDrawing.getSelectedShape() instanceof Line) {
        				DlgLine dlg = new DlgLine();
        				Line line = (Line) pnlDrawing.getSelectedShape();
                    	dlg.setX1Value(line.getStartPoint().getX());
                    	dlg.setY1Value(line.getStartPoint().getY());
                    	dlg.setX2Value(line.getEndPoint().getX());
                    	dlg.setY2Value(line.getEndPoint().getY());
                    	dlg.setCoordinatesEditable(true);

                    	dlg.setVisible(true);
                    	if (dlg.isConfirmed()) {
                    		line.setStartPoint(new Point(dlg.getX1Value(), dlg.getY1Value()));
                    		line.setEndPoint(new Point(dlg.getX2Value(), dlg.getY2Value()));
                    		line.setColor(dlg.getBorderColor());
                    	}
                    	line.setSelected(false);
                        pnlDrawing.setSelectedShape(null);
                        pnlDrawing.repaint();
        			}
        			else if(pnlDrawing.getSelectedShape() instanceof Rectangle) {
        				DlgRectangle dlg = new DlgRectangle();
        				Rectangle rect = (Rectangle) pnlDrawing.getSelectedShape();
        				
        				dlg.setXValue(rect.getUpperLeftPoint().getX());
        				dlg.setYValue(rect.getUpperLeftPoint().getY());
        				dlg.setWidthValue(rect.getWidth());
        				dlg.setHeightValue(rect.getHeight());
        				dlg.setBorderColor(rect.getColor());
        				dlg.setInnerColor(rect.getInnerColor());
        				dlg.setCoordinatesEditable(true);
        				
        				dlg.setVisible(true);
        				if(dlg.isConfirmed()) {
        					rect.setUpperLeftPoint(new Point(dlg.getXValue(), dlg.getYValue()));
        					rect.setHeight(dlg.getHeightValue());
        					rect.setWidth(dlg.getWidthValue());
        					rect.setColor(dlg.getBorderColor());
        					rect.setInnerColor(dlg.getInnerColor()); 
        				}
        				rect.setSelected(false);
        				pnlDrawing.setSelectedShape(null);
                        pnlDrawing.repaint();
        			}
        			else if(pnlDrawing.getSelectedShape() instanceof Donut) {
        				
        				DlgDonut dlg = new DlgDonut();
        				Donut donut = (Donut) pnlDrawing.getSelectedShape();
        				
        				dlg.setXValue(donut.getCenter().getX());
        				dlg.setYValue(donut.getCenter().getY());
        				dlg.setRadiusValue(donut.getRadius());
        				dlg.setInnerRadiusValue(donut.getInnerRadius());
        				dlg.setBorderColor(donut.getColor());
        				dlg.setInnerColor(donut.getInnerColor());
        				dlg.setCoordinatesEditable(true);
        				
        				dlg.setVisible(true);
        				if(dlg.isConfirmed()) {
        					donut.setCenter(new Point(dlg.getXValue(), dlg.getYValue()));
        					donut.setRadius(dlg.getRadiusValue());
        					donut.setInnerRadius(dlg.getInnerRadiusValue());
        					donut.setColor(dlg.getBorderColor());
        					donut.setInnerColor(dlg.getInnerColor()); 
        				}
        				donut.setSelected(false);
        				pnlDrawing.setSelectedShape(null);
                        pnlDrawing.repaint();
        			}
        			else if(pnlDrawing.getSelectedShape() instanceof Circle) {
        				DlgCircle dlg = new DlgCircle();
        				Circle circle = (Circle) pnlDrawing.getSelectedShape();
        				
        				dlg.setXValue(circle.getCenter().getX());
        				dlg.setYValue(circle.getCenter().getY());
        				dlg.setRadiusValue(circle.getRadius());
        				
        				dlg.setBorderColor(circle.getColor());
        				dlg.setInnerColor(circle.getInnerColor());
        				dlg.setCoordinatesEditable(true);
        				
        				dlg.setVisible(true);
        				if(dlg.isConfirmed()) {
        					circle.setCenter(new Point(dlg.getXValue(), dlg.getYValue()));
        					circle.setRadius(dlg.getRadiusValue());
        					circle.setColor(dlg.getBorderColor());
        					circle.setInnerColor(dlg.getInnerColor()); 
        				}
        				circle.setSelected(false);
        				pnlDrawing.setSelectedShape(null);
                        pnlDrawing.repaint();
        			}
        		}
        	}
        });
        panel.add(btnModify);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(pnlDrawing.getSelectedShape() == null) {
        			JOptionPane.showMessageDialog(FrmDrawing.this, "Please select shape first.", "Warning", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		
        		int option = JOptionPane.showConfirmDialog(FrmDrawing.this, "Are you sure you want to delete selected shape?", "Delete conformation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        		if (option == JOptionPane.YES_OPTION) {
        			pnlDrawing.getShapes().remove(pnlDrawing.getSelectedShape());
        			pnlDrawing.setSelectedShape(null);
        			pnlDrawing.repaint();
        		}
        	}
        });
        panel.add(btnDelete);

        pnlDrawing = new PnlDrawing();
        getContentPane().add(pnlDrawing, BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(tglPoint);
        buttonGroup.add(tglLine);
        buttonGroup.add(tglRectangle);
        buttonGroup.add(tglCircle);
        buttonGroup.add(tglDonut);
        buttonGroup.add(tglSelect);
        
        
        pnlDrawing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {   // event listener za kliktanje po panelu
            	
            	
                if (tglPoint.isSelected()) {    // ako je tacka
                	DlgPoint dlg = new DlgPoint();
                	dlg.setXValue(e.getX());
                	dlg.setYValue(e.getY());
                	dlg.setCoordinatesEditable(false);

                	dlg.setVisible(true);
                	if (dlg.isConfirmed()) {
                	    Point point = new Point(dlg.getXValue(), dlg.getYValue());
                	    point.setColor(dlg.getBorderColor());
                	    pnlDrawing.getShapes().add(point);
                	    pnlDrawing.repaint();
                	}
                }
                
                
                else if (tglLine.isSelected()) {             // ako je linija 
                	if (startPoint == null) {

                        startPoint = new Point(e.getX(), e.getY());

                    } else {
                        Point endPoint = new Point(e.getX(), e.getY());
                        DlgLine dlg = new DlgLine();
                        dlg.setX1Value(startPoint.getX());
                        dlg.setY1Value(startPoint.getY());
                        dlg.setX2Value(endPoint.getX());
                        dlg.setY2Value(endPoint.getY());
                        dlg.setCoordinatesEditable(false);
                        dlg.setVisible(true);
                        if (dlg.isConfirmed()) {
                            Line line = new Line(new Point(dlg.getX1Value(), dlg.getY1Value()),new Point(dlg.getX2Value(), dlg.getY2Value()));
                            line.setColor(dlg.getBorderColor());
                            pnlDrawing.getShapes().add(line);
                            pnlDrawing.repaint();
                        }
                        startPoint = null;
                    }
                }
                
                else if(tglRectangle.isSelected()) {       //ako je pravougaonik
                	DlgRectangle dlg = new DlgRectangle();
                	dlg.setXValue(e.getX());
                	dlg.setYValue(e.getY());
                	dlg.setCoordinatesEditable(false);
                	
                	dlg.setVisible(true);
                	if(dlg.isConfirmed()) {
                		Rectangle rect = new Rectangle (new Point (dlg.getXValue(), dlg.getYValue()), dlg.getWidthValue(), dlg.getHeightValue());
                		rect.setColor(dlg.getBorderColor());
                		rect.setInnerColor(dlg.getInnerColor());
                		
                		pnlDrawing.getShapes().add(rect);
                		pnlDrawing.repaint();
                	}
                }
                else if(tglCircle.isSelected()) {   //ako je krug
                	DlgCircle dlg = new DlgCircle();
                	dlg.setXValue(e.getX());
                	dlg.setYValue(e.getY());
                	dlg.setCoordinatesEditable(false);
                	
                	dlg.setVisible(true);
                	if(dlg.isConfirmed()) {
                		Circle circle = new Circle (new Point (dlg.getXValue(), dlg.getYValue()), dlg.getRadiusValue());
                		circle.setColor(dlg.getBorderColor());
                		circle.setInnerColor(dlg.getInnerColor());
                		
                		pnlDrawing.getShapes().add(circle);
                		pnlDrawing.repaint();
                		
                	}
                }
                else if(tglDonut.isSelected()) {  //ako je donut
                	DlgDonut dlg = new DlgDonut();
                	dlg.setXValue(e.getX());
                	dlg.setYValue(e.getY());
                	dlg.setCoordinatesEditable(false);
                	
                	dlg.setVisible(true);
                	
                	if(dlg.isConfirmed()) {
                		Donut donut = new Donut (new Point(dlg.getXValue(), dlg.getYValue()), dlg.getRadiusValue(), dlg.getInnerRadiusValue());
                		donut.setColor(dlg.getBorderColor());
                		donut.setInnerColor(dlg.getInnerColor());
                		pnlDrawing.getShapes().add(donut);
                		pnlDrawing.repaint();
                	}
                }
                else if(tglSelect.isSelected()) {    //ako se selektuje
                	Shape clickedShape = null;
                    for(int i = pnlDrawing.getShapes().size() - 1; i >= 0; i--) {
                        Shape shape = pnlDrawing.getShapes().get(i);
                        if(shape.contains(e.getX(), e.getY())) {
                            clickedShape = shape;
                            break;
                        }
                    }
                    if(pnlDrawing.getSelectedShape() != null) {
                        pnlDrawing.getSelectedShape().setSelected(false);
                    }
                    if(clickedShape != null) {
                        if(clickedShape == pnlDrawing.getSelectedShape()) {
                            clickedShape.setSelected(false);
                            pnlDrawing.setSelectedShape(null);
                        } 
                        else {
                            clickedShape.setSelected(true);
                            pnlDrawing.setSelectedShape(clickedShape);
                        }
                    } 
                    else {
                        pnlDrawing.setSelectedShape(null);
                    }
                    pnlDrawing.repaint();
                }
            }
        });
    }
}