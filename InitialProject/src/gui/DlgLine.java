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

public class DlgLine extends JDialog{
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;
	
	private Color borderColor = Color.BLACK;
	private boolean confirmed = false;
	
	
	
	public DlgLine() {
		setModal(true);
		setTitle("Line");
		
		JPanel pnlCenter = new JPanel();
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(5, 2, 5, 5));
		setBounds(100, 100, 350, 320);
		
		JLabel LabelX1 = new JLabel("   X1:");
		pnlCenter.add(LabelX1);
		
		txtX1 = new JTextField();
		pnlCenter.add(txtX1);
		txtX1.setColumns(10);
		
		JLabel LabelY1 = new JLabel("   Y1:");
		pnlCenter.add(LabelY1);
		
		txtY1 = new JTextField();
		pnlCenter.add(txtY1);
		txtY1.setColumns(10);
		
		
		JButton btnBorderColor = new JButton("Border color");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(DlgLine.this, "Choose border color: ", borderColor);
				if (chosenColor != null) {
				    borderColor = chosenColor;
				}
			}
		});
		
		JLabel LabelX2 = new JLabel("   X2:");
		pnlCenter.add(LabelX2);
		
		txtX2 = new JTextField();
		txtX2.setColumns(10);
		pnlCenter.add(txtX2);
		
		JLabel LabelY2 = new JLabel("   Y2:");
		pnlCenter.add(LabelY2);
		
		txtY2 = new JTextField();
		txtY2.setColumns(10);
		pnlCenter.add(txtY2);
		JLabel label = new JLabel("");
		pnlCenter.add(label);
		pnlCenter.add(btnBorderColor);
		
		pnlCenter.add(btnBorderColor);
		
		
		JPanel pnlButtons = new JPanel();
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Integer.parseInt(txtX1.getText().trim());
		            Integer.parseInt(txtY1.getText().trim());
		            Integer.parseInt(txtX2.getText().trim());
		            Integer.parseInt(txtY2.getText().trim());
		            confirmed = true;
		            dispose();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(
		                DlgLine.this,
		                "Please enter valid numbers for X1, Y1, X2 and Y2.",
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

	public int getX1Value() {
	    return Integer.parseInt(txtX1.getText().trim());
	}

	public int getY1Value() {
	    return Integer.parseInt(txtY1.getText().trim());
	}
	
	public int getX2Value() {
	    return Integer.parseInt(txtX2.getText().trim());
	}

	public int getY2Value() {
	    return Integer.parseInt(txtY2.getText().trim());
	}

	public Color getBorderColor() {
	    return borderColor;
	}

	public void setX1Value(int x) {
	    txtX1.setText(String.valueOf(x));
	}

	public void setY1Value(int y) {
	    txtY1.setText(String.valueOf(y));
	}
	
	public void setX2Value(int x) {
	    txtX2.setText(String.valueOf(x));
	}

	public void setY2Value(int y) {
	    txtY2.setText(String.valueOf(y));
	}
	
	public void setBorderColor(Color borderColor) {
	    this.borderColor = borderColor;
	}

	public void setCoordinatesEditable(boolean editable) {
	    txtX1.setEditable(editable);
	    txtY1.setEditable(editable);
	    txtX2.setEditable(editable);
	    txtY2.setEditable(editable);
	}
	
}
