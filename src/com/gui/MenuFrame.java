package com.gui;

import com.dbutil.DBConnection;
import java.awt.EventQueue;
import com.model.Menu;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtProductID;
	private JTextField txtProductName;
	private JTextField txtPrice;
	
	Connection con1;
	Statement stmt1;
	PreparedStatement ps1;
	ResultSet rs1;
	//Create Model Object
	Menu menuObj;
	String query;
	private static int sequential_ID;
	private JButton btnNewButton;
	private JButton btnDelete;
	private JButton btnClose;
	private JButton btnAdd;
	private JButton btnView;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setFont(new Font("Arial",Font.BOLD,18));
		setBackground(new Color(255,218,185));
		setForeground(Color.GRAY);
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100,100,874,505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,218,185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel=new JLabel("Product_ID");
		lblNewLabel.setForeground(new Color(25,25,112));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblNewLabel.setBounds(230,80,152,34);
		contentPane.add(lblNewLabel);

		txtProductID=new JTextField();
		txtProductID.setFont(new Font("Times New Roman",Font.PLAIN,18));
		txtProductID.setBounds(400,80,335,34);
		contentPane.add(txtProductID);
		txtProductID.setColumns(10);

		JLabel lblNewLabel_1=new JLabel("Product_Name");
		lblNewLabel_1.setForeground(new Color(25,25,112));
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblNewLabel_1.setBounds(230,160,152,34);
		contentPane.add(lblNewLabel_1);
		
		txtProductName=new JTextField();
		txtProductName.setFont(new Font("Times New Roman",Font.PLAIN,18));
		txtProductName.setBounds(400,160,335,34);
		contentPane.add(txtProductName);
		txtProductName.setColumns(10);		
		
		JLabel lblNewLabel_2=new JLabel("Price");
		lblNewLabel_2.setForeground(new Color(25,25,112));
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblNewLabel_2.setBounds(230,240,152,34);
		contentPane.add(lblNewLabel_2);
	
		txtPrice=new JTextField();
		txtPrice.setFont(new Font("Times New Roman",Font.PLAIN,18));
		txtPrice.setBounds(400,240,335,34);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(240, 367, 90, 30);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDelete.setBounds(560, 367, 90, 30);
		contentPane.add(btnDelete);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnClose.setBounds(720, 367, 90, 30);
		contentPane.add(btnClose);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAdd.setBounds(80, 367, 90, 30);
		contentPane.add(btnAdd);
		
		btnView = new JButton("View");
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnView.setBounds(400, 367, 90, 30);
		contentPane.add(btnView);
		
		JButton btnadd=new JButton("Add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1=DBConnection.getConnection();
				//Query for Setting Auto-Generated ID for the Product
				String query1="SELECT MAX(PRODUCT_ID) FROM PRODUCT";
				stmt1=null;
				menuObj=new Menu();
				try {
					stmt1=con1.createStatement();
					ResultSet rs1=stmt1.executeQuery(query1);
					rs1.next();
					if(rs1.getString(1)==null) {
						System.out.println("No Record");
						menuObj.setProduct_ID("J#"+sequential_ID);
						txtProductID.setText(menuObj.getProduct_ID());
					}
					else {
						sequential_ID=Integer.parseInt(rs1.getString(1).substring(2,rs1.getString(1).length()))+1;
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				resetControls();
			}
		});
	}

	private void resetControls() {
		txtProductName.setText("");
		txtProductID.setText("");
		txtPrice.setText("");
		txtProductName.requestFocus();	
	}
}