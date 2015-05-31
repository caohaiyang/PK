package com.StorageOfGoods.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 212);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(35, 35, 47, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(35, 85, 47, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				start(formattedTextField.getText(),formattedTextField_1.getText());
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(161, 128, 70, 30);
		contentPane.add(btnNewButton);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(92, 35, 139, 23);
		contentPane.add(formattedTextField);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(92, 85, 139, 23);
		contentPane.add(formattedTextField_1);
	}
	public void start(String name,String pass){
		com.StorageOfGoods.Function.Login log = new com.StorageOfGoods.Function.Login(name,pass);
		if(name.equals("") || pass.equals("")){
			JOptionPane.showMessageDialog(null, "用户名密码不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
		}else if(log.Check()){
			new HomePage().setVisible(true);
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(null, "用户名或密码错误!","提示",JOptionPane.YES_NO_OPTION);
		}
	}
}
