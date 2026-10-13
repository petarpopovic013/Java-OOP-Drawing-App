package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
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

public class FrmSort extends JFrame {

    private DefaultListModel<Donut> listModel = new DefaultListModel<Donut>();
    private JList<Donut> listDonuts = new JList<Donut>(listModel);


    private ArrayList<Donut> donuts = new ArrayList<Donut>();
    private JButton btnAdd;
    private JButton btnSort;
    public FrmSort() {
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
        		dlg.setFieldsEditable(true);
        		dlg.setVisible(true);
        		if (dlg.isConfirmed()) {
        		    Donut donut = new Donut(
        		        new Point(dlg.getXValue(), dlg.getYValue()), dlg.getRadiusValue(), dlg.getInnerRadiusValue());
        		    listModel.addElement(donut);
        		    donuts.add(donut);
        		}
        	}
        });
        pnlButtons.add(btnAdd);
        btnSort = new JButton("Sort");
        btnSort.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(listModel.isEmpty()) {
        			JOptionPane.showMessageDialog(FrmSort.this, "List is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        		donuts.sort((d1, d2) -> Double.compare(d2.area(), d1.area()));
                listModel.clear();
                for (Donut donut : donuts) {
                    listModel.addElement(donut);
                }
        		}
        	}
        );
        pnlButtons.add(btnSort);
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(listDonuts);
    }

}