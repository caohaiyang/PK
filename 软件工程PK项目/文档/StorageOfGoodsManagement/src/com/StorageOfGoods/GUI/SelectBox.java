package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectBox extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField formattedTextField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public SelectBox() {
		setTitle("\u9009\u62E9\u5BC4\u5B58\u67DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 182);
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
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u60F3\u8981\u7ED3\u8D26\u7684\u5BC4\u5B58\u67DC\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(48, 23, 189, 15);
		contentPane.add(lblNewLabel);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(48, 48, 148, 26);
		contentPane.add(formattedTextField);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CheckOut(Integer.valueOf(formattedTextField.getText())).setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(23, 110, 63, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(155, 110, 63, 23);
		contentPane.add(btnNewButton_1);
	}

}
