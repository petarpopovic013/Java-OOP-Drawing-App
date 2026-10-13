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

public class DlgPoint extends JDialog{
	private JTextField txtX;
	private JTextField txtY;

	
	private Color borderColor = Color.BLACK;
	private boolean confirmed = false;
	
	
	public DlgPoint() {
		setModal(true);
		setTitle("Point");
		
		JPanel pnlCenter = new JPanel();
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(3, 2, 5, 5));
		setBounds(100, 100, 350, 320);
		
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
		
		
		JButton btnBorderColor = new JButton("Color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(DlgPoint.this, "Choose border color: ", borderColor);
				if (chosenColor != null) {
				    borderColor = chosenColor;
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		pnlCenter.add(lblNewLabel);
		pnlCenter.add(btnBorderColor);
		
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Integer.parseInt(txtX.getText().trim());
		            Integer.parseInt(txtY.getText().trim());
		            confirmed = true;
		            dispose();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(
		                DlgPoint.this,
		                "Please enter valid numbers for X and Y.",
		                "Error",
		                JOptionPane.ERROR_MESSAGE
		            );
		        };
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

	public Color getBorderColor() {
	    return borderColor;
	}

	public void setXValue(int x) {
	    txtX.setText(String.valueOf(x));
	}

	public void setYValue(int y) {
	    txtY.setText(String.valueOf(y));
	}
	
	public void setBorderColor(Color borderColor) {
	    this.borderColor = borderColor;
	}

	public void setCoordinatesEditable(boolean editable) {
	    txtX.setEditable(editable);
	    txtY.setEditable(editable);
	}
	
}
