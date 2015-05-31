package com.StorageOfGoods.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.StorageOfGoods.Function.Box;
import com.StorageOfGoods.Function.Customer;
import com.StorageOfGoods.Function.DataOperating;
import com.StorageOfGoods.Function.RentBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeaseCabinet extends JFrame {

	private JPanel contentPane;
	private JComboBox<Integer> comboBox;
	private JComboBox<String> comboBox_1;
	private Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JEditorPane editorPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public LeaseCabinet() {
		setTitle("\u767B\u8BB0\u79DF\u67DC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 331);
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
		
		JLabel lblNewLabel = new JLabel("\u987E\u5BA2\u59D3\u540D\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
		lblNewLabel.setBounds(10, 32, 69, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(247, 32, 69, 15);
		contentPane.add(lblNewLabel_1);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(80, 29, 127, 21);
		contentPane.add(formattedTextField);
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(316, 29, 127, 21);
		contentPane.add(formattedTextField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9009\u62E9\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(247, 65, 69, 15);
		contentPane.add(lblNewLabel_2);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(316, 63, 127, 18);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("\u9009\u62E9\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 63, 69, 15);
		contentPane.add(lblNewLabel_3);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED){
					String type = null;
			        type = comboBox_1.getSelectedItem().toString();
			        DataOperating dpo = new DataOperating();
			        Vector<Integer> vt = new Vector<Integer>();
			        vt = dpo.getEmptyBoxNumByType(type);
			        map.put(0, vt);
					comboBox.setModel((ComboBoxModel<Integer>) new DefaultComboBoxModel(map.get(0)));
				}
			}
		});
		DataOperating dop = new DataOperating();
		Vector<com.StorageOfGoods.Function.Type> vt = new Vector<com.StorageOfGoods.Function.Type>();
		vt = dop.getCabinetType();
		for(int i = 0; i < vt.size(); i++){
		    comboBox_1.addItem(vt.get(i).getType());
		}
		comboBox_1.setBounds(80, 63, 127, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 129, 69, 15);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 129, 361, 51);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58\u5E76\u63A8\u51FA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer cust = new Customer(formattedTextField.getText(), formattedTextField_1.getText()
						, Double.valueOf(formattedTextField_2.getText()), Double.valueOf("0"),editorPane.getText());
				RentBox rt = new RentBox(cust,Integer.valueOf(comboBox.getSelectedItem().toString()));
				rt.rentBox();
				JOptionPane.showMessageDialog(null, "保存成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(338, 238, 105, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("\u5B9E\u6536\u62BC\u91D1\uFF1A");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(10, 94, 69, 15);
		contentPane.add(lblNewLabel_5);
		
		formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(80, 94, 127, 21);
		contentPane.add(formattedTextField_2);
	}
}
