package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import geometry.Donut;
import geometry.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

    private DefaultListModel<Donut> listModel = new DefaultListModel<Donut>();
    private JList<Donut> listDonuts = new JList<Donut>(listModel);
    private Stack<Donut> stack = new Stack<Donut>();
    private JButton btnAdd;
    private JButton btnRemove;
    public FrmStack() {
        setTitle("Popovic Petar IT-10/2025");
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout());
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        getContentPane().add(pnlButtons, BorderLayout.NORTH);
        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DlgDonut1 dlg = new DlgDonut1();
        		dlg.setCoordinatesEditable(true);
        		dlg.setVisible(true);
        		if (dlg.isConfirmed()) {
        		    Donut donut = new Donut(
        		        new Point(dlg.getXValue(), dlg.getYValue()),
        		        dlg.getRadiusValue(),
        		        dlg.getInnerRadiusValue()
        		    );
        		    stack.push(donut);
        		    listModel.add(0, donut);
        		}
        	}
        });
        pnlButtons.add(btnAdd);
        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(stack.isEmpty()) {
        			JOptionPane.showMessageDialog(FrmStack.this, "Stack is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		Donut donut = stack.peek();
        		DlgDonut1 dlg = new DlgDonut1();
        		dlg.setXValue(donut.getCenter().getX());
        		dlg.setYValue(donut.getCenter().getY());
        		dlg.setInnerRadiusValue(donut.getInnerRadius());
        		dlg.setRadiusValue(donut.getRadius());
        		
        		dlg.setFieldsEditable(false);
        		dlg.setVisible(true);
        		if(dlg.isConfirmed()) {
        			stack.pop();
        			listModel.remove(0);
        		}
        	}
        });
        pnlButtons.add(btnRemove);
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(listDonuts);
    }

}