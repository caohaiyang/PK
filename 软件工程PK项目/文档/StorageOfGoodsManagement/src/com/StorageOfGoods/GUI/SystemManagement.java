package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import com.StorageOfGoods.Function.Box;
import com.StorageOfGoods.Function.DataOperating;
import com.StorageOfGoods.Function.ManageBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class SystemManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private StringBuffer s;
	private String selectedItem;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public SystemManagement() {
		setTitle("\u7CFB\u7EDF\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 500, 451);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("寄存柜设置", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 300, 400);
		panel.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if((table.getValueAt(table.getSelectedRow(), 0)) != null){
				     s = new StringBuffer(String.valueOf((Integer)table.getValueAt(table.getSelectedRow(), 0)));
				     selectedItem = s.toString();
			     }
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BC4\u5B58\u67DC\u7F16\u53F7", "\u5BC4\u5B58\u67DC\u7C7B\u578B"
			}
		));
		Vector<Box> vt = new Vector<Box>();
		DataOperating dop = new DataOperating();
		vt = dop.getAllBox();
		Vector vtt;
		for(int i = 0; i < vt.size(); i++){
			vtt = new Vector(); 
			vtt.add(vt.get(i).getBoxNum());
			vtt.add(vt.get(i).getType());
		    ((DefaultTableModel)table.getModel()).addRow(vtt);
		}
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Select(0).setVisible(true);;
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton.setBounds(363, 65, 73, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 ManageBox mb = new ManageBox();
			     mb.deleteBox(new Box(Integer.valueOf(selectedItem),""));
			     JOptionPane.showMessageDialog(null, "成功删除!","提示",JOptionPane.INFORMATION_MESSAGE);
			     table.repaint();
			}
		});
		btnNewButton_2.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_2.setBounds(363, 183, 73, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
		btnNewButton_3.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(363, 295, 73, 23);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("类型设置", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 300, 400);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BC4\u5B58\u67DC\u7C7B\u578B", "\u5355\u4EF7"
			}
		));
		Vector<com.StorageOfGoods.Function.Type> vt0 = new Vector<com.StorageOfGoods.Function.Type>();
		//DataOperating dop = new DataOperating();
		//vt = dop.getAllBox();
		vt0 = dop.getCabinetType();
		for(int i = 0; i < vt0.size(); i++){
			vtt = new Vector(); 
			vtt.add(vt0.get(i).getType());
			vtt.add(vt0.get(i).getPrice());
		    ((DefaultTableModel)table_1.getModel()).addRow(vtt);
		}
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_4 = new JButton("\u6DFB\u52A0");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Select(1).setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_4.setBounds(363, 65, 73, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("\u5220\u9664");
		btnNewButton_6.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_6.setBounds(363, 183, 73, 23);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u53D6\u6D88");
		btnNewButton_7.setFont(new Font("SimSun", Font.PLAIN, 12));
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_7.setBounds(363, 295, 73, 23);
		panel_1.add(btnNewButton_7);
	}
}
