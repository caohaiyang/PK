package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.StorageOfGoods.Function.Customer;
import com.StorageOfGoods.Function.DataOperating;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private int boxNum;
	private com.StorageOfGoods.Function.CheckOut checkout = new com.StorageOfGoods.Function.CheckOut();
	private Document document;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JLabel label_1;
	private JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CheckOut(int num) {
		boxNum = num;
		setTitle("\u7ED3\u8D26\u9000\u67DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
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
		
		
		JButton btnNewButton = new JButton("\u7ED3\u8D26");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkout.checkOut(boxNum);
				JOptionPane.showMessageDialog(null, "结账成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(73, 193, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(313, 193, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 443, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u7ED3\u8D26\u5BC4\u5B58\u67DC\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 10, 79, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(89, 10, 79, 18);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(291, 8, 79, 18);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u59D3\u540D\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(202, 10, 79, 15);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 75, 443, 87);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u5DF2\u6536\u62BC\u91D1\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(214, 10, 65, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("\u5E94\u6536\u91D1\u989D\uFF1A");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(10, 10, 65, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel label = new JLabel("\u5BBE\u5BA2\u652F\u4ED8\uFF1A");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 51, 65, 15);
		panel_1.add(label);
		
		JLabel lblNewLabel_8 = new JLabel("\u627E\u96F6\uFF1A");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(214, 51, 65, 15);
		panel_1.add(lblNewLabel_8);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(289, 8, 63, 18);
		panel_1.add(lblNewLabel_10);
		
		formattedTextField = new JFormattedTextField();
		document = formattedTextField.getDocument();
		document.addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!formattedTextField.getText().equals("")){
					try {
						label_1.setText(String.valueOf(Double.valueOf(document.getText(0, document.getLength())) 
								- Double.valueOf(formattedTextField_1.getText()) 
								- Double.valueOf(lblNewLabel_10.getText())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					label_1.setText(String.valueOf(Double.valueOf(0) 
							- Double.valueOf(formattedTextField_1.getText()) 
							- Double.valueOf(lblNewLabel_10.getText())));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!formattedTextField.getText().equals("")){
					try {
						label_1.setText(String.valueOf(Double.valueOf(document.getText(0, document.getLength())) 
								- Double.valueOf(formattedTextField_1.getText()) 
								- Double.valueOf(lblNewLabel_10.getText())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					label_1.setText(String.valueOf(Double.valueOf(0)
									- Double.valueOf(formattedTextField_1.getText()) 
									- Double.valueOf(lblNewLabel_10.getText())));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(!formattedTextField.getText().equals("")){
					try {
						label_1.setText(String.valueOf(Double.valueOf(document.getText(0, document.getLength())) 
								- Double.valueOf(formattedTextField_1.getText()) 
								- Double.valueOf(lblNewLabel_10.getText())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					label_1.setText(String.valueOf(Double.valueOf(0) 
							- Double.valueOf(formattedTextField_1.getText()) 
							- Double.valueOf(lblNewLabel_10.getText())));
				}
			   }
			});
		formattedTextField.setBounds(85, 48, 63, 18);
		panel_1.add(formattedTextField);
		
		label_1 = new JLabel("");
		label_1.setBounds(289, 51, 63, 18);
		panel_1.add(label_1);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(85, 7, 63, 18);
		panel_1.add(formattedTextField_1);
		
		lblNewLabel_5.setText(String.valueOf(boxNum));
		DataOperating dop = new DataOperating();
		Customer customer = dop.getCustomerByBoxNum(boxNum);
		//System.out.println(dop.getCustomerByBoxNum(boxNum).size());
		lblNewLabel_6.setText(customer.getName());
		lblNewLabel_10.setText(String.valueOf(customer.getDeposit()));
	}
}
