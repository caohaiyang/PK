package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.StorageOfGoods.Function.Box;
import com.StorageOfGoods.Function.DataOperating;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class Select extends JFrame {

	private JPanel contentPane;
	private int flag;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Select(int fg) {
		flag = fg;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 225);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		if(flag == 0){
			lblNewLabel.setText("寄存柜编号：");
		}else{
			lblNewLabel.setText("寄存柜类型：");
		}
		lblNewLabel.setBounds(38, 30, 72, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		if(flag == 0){
			lblNewLabel_1.setText("寄存柜类型：");
		}else{
			lblNewLabel_1.setText("单价：");
		}
		lblNewLabel_1.setBounds(38, 84, 72, 15);
		contentPane.add(lblNewLabel_1);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(130, 27, 128, 21);
		contentPane.add(formattedTextField);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(130, 81, 128, 21);
		contentPane.add(formattedTextField_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DataOperating dop = new DataOperating();
				if(flag == 0){
					dop.addBox(new Box(Integer.valueOf(formattedTextField.getText())
							,formattedTextField_1.getText()));
					setVisible(false);
					JOptionPane.showMessageDialog(null, "寄存柜添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					
				}else{
					dop.addBoxType(new com.StorageOfGoods.Function.Type(formattedTextField.getText()
							,Double.valueOf(formattedTextField.getText())));
					setVisible(false);
					JOptionPane.showMessageDialog(null, "寄存柜类型添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(44, 137, 66, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(195, 137, 66, 23);
		contentPane.add(btnNewButton_1);
	}
}
