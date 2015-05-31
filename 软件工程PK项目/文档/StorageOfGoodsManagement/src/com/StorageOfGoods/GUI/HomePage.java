package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.StorageOfGoods.Function.Customer;
import com.StorageOfGoods.Function.DataOperating;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Font;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 157, 533, 394);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BC4\u5B58\u67DC\u7F16\u53F7", "\u5BC4\u5B58\u67DC\u578B\u53F7", "\u987E\u5BA2\u59D3\u540D", "\u8054\u7CFB\u7535\u8BDD", "已收押金（元）", "\u79DF\u7528\u65E5\u671F"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		DataOperating dop = new DataOperating();
		Vector<Integer> vt = new Vector<Integer>();
		vt = dop.getBoxNumByState(1);
		Customer customer;
		Vector vtt;
		for(int i = 0; i < vt.size(); i++){
			vtt = new Vector();
		    customer = dop.getCustomerByBoxNum(vt.get(i));
		    vtt.add(vt.get(i));
		    vtt.add(dop.getTypeByBoxNum(vt.get(i)));
		    vtt.add(customer.getName());
		    vtt.add(customer.getPhoneNum());
		    vtt.add(customer.getDeposit());
		    vtt.add(dop.getStartTimeByBoxNum(vt.get(i)));
		    ((DefaultTableModel)table.getModel()).addRow(vtt);
		}
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(10, 107, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("新宋体", Font.PLAIN, 12));
		comboBox.setBounds(185, 107, 137, 21);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u67DC\u5B50\u7F16\u53F7\u67E5\u8BE2", "\u6309\u987E\u5BA2\u59D3\u540D\u67E5\u8BE2", "\u6309\u8054\u7CFB\u7535\u8BDD\u67E5\u8BE2"}));
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(433, 107, 110, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7CFB\u7EDF\u7BA1\u7406");
		btnNewButton_2.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SystemManagement().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(247, 10, 95, 58);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u7ED3\u8D26\u9000\u67DC");
		btnNewButton_3.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SelectBox().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(129, 10, 95, 58);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("\u767B\u8BB0\u79DF\u67DC");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LeaseCabinet().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 95, 58);
		contentPane.add(btnNewButton);
	}
}
