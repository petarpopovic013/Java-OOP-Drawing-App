package gui;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog{
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;

	
	private Color borderColor = Color.BLACK;
	private Color innerColor = Color.WHITE;
	private boolean confirmed = false;
	
	
	public DlgCircle() {
		setModal(true);
		setTitle("Circle");
		JPanel pnlCenter = new JPanel();
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(6, 2, 5, 5));
		setBounds(100, 100, 500, 320);
		
		JLabel LabelX = new JLabel("   X:");
		pnlCenter.add(LabelX);
		
		txtX = new JTextField();
		pnlCenter.add(txtX);
		txtX.setColumns(10);
		
		JLabel LabelY = new JLabel("   Y:");
		pnlCenter.add(LabelY);
		
		txtY = new JTextField();
		pnlCenter.add(txtY);
		txtY.setColumns(10);
		
		JLabel LabelRadius = new JLabel("   Radius:");
		pnlCenter.add(LabelRadius);
		
		txtRadius = new JTextField();
		pnlCenter.add(txtRadius);
		txtRadius.setColumns(10);
		
	
		
		JButton btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(DlgCircle.this, "Choose border color: ", borderColor);
				if (chosenColor != null) {
				    borderColor = chosenColor;
				}
			}
		});
		pnlCenter.add(btnBorderColor);
		
		JButton btnInnerColor = new JButton("Inner color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(DlgCircle.this, "Choose border color: ", innerColor);
				if (chosenColor != null) {
				    innerColor = chosenColor;
				}
			}
		});
		pnlCenter.add(btnInnerColor);
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int radius = Integer.parseInt(txtRadius.getText().trim());
					
					if(radius<=0) {
						JOptionPane.showMessageDialog(DlgCircle.this, "Radius must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					confirmed = true;
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(DlgCircle.this, "Please enter valid number.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnlButtons.add(btnOK);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmed = false;
				dispose();
			}
		});
		pnlButtons.add(btnCancel);
	}
	
	
	public boolean isConfirmed() {
	    return confirmed;
	}

	public int getXValue() {
	    return Integer.parseInt(txtX.getText().trim());
	}

	public int getYValue() {
	    return Integer.parseInt(txtY.getText().trim());
	}

	public int getRadiusValue() {
	    return Integer.parseInt(txtRadius.getText().trim());
	}

	public Color getBorderColor() {
	    return borderColor;
	}

	public Color getInnerColor() {
	    return innerColor;
	}

	public void setXValue(int x) {
	    txtX.setText(String.valueOf(x));
	}

	public void setYValue(int y) {
	    txtY.setText(String.valueOf(y));
	}

	public void setRadiusValue(int radius) {
	    txtRadius.setText(String.valueOf(radius));
	}


	public void setCoordinatesEditable(boolean editable) {
	    txtX.setEditable(editable);
	    txtY.setEditable(editable);
	}


	public void setBorderColor(Color color) {
		this.borderColor = color;
		
	}
	public void setInnerColor(Color color) {
		this.innerColor = color;
		
	}
}
