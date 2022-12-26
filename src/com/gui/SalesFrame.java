package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.dbutil.DBConnection;
import com.model.Sales;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class SalesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustomerID;
	private JTextField txtOrderDate;
	private JTextField txtProductID;

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	Sales salesObj;
	String query;
	private static int sequential_ID=1000;
	int count=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,218,185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setBounds(100,100,874,505);

		
		JLabel lblNewLabel = new JLabel("Customer_ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(307, 74, 131, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order_Date");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(307, 170, 122, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product_ID");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(307, 266, 131, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=DBConnection.getConnection();
				//Query for setting Auto-
			}
		});
		btnAdd.setBounds(70, 380, 90, 30);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSave.setBounds(230, 380, 90, 30);
		contentPane.add(btnSave);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnView.setBounds(390, 380, 90, 30);
		contentPane.add(btnView);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Button Clicked");
				if(!txtCustomerID.getText().equals("")) {
					int confirmation=JOptionPane.showConfirmDialog(null,"Customer Confirm Delete...?","Delete Customer",JOptionPane.YES_NO_OPTION);
					
					if(confirmation==0) {
						query="DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";
						try {
							ps=con.prepareStatement(query);
							ps.setString(1, txtCustomerID.getText());
							count=ps.executeUpdate();
							if(count!=0) {
								JOptionPane.showConfirmDialog(null,"Customer Delete..","Delete Customer",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnDelete.setMnemonic('D');
		btnDelete.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/delete.png")));
		btnDelete.setBackground(SystemColor.window);
		btnDelete.setFont(new Font("Times New Roman",Font.BOLD,17));
		btnDelete.setBounds(550, 380, 90, 30);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Close Button Clicked");
				dispose();
			}
		});
		btnClose.setMnemonic('C');
		btnClose.setIcon(new ImageIcon(CustomerFrame.class.getResource("/icons/close.png")));
		btnClose.setBackground(SystemColor.window);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnClose.setBounds(710, 380, 90, 30);
		contentPane.add(btnClose);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCustomerID.setForeground(Color.RED);
		txtCustomerID.setEditable(false);		
		txtCustomerID.setBounds(460, 71, 270, 40);
		contentPane.add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtOrderDate = new JTextField();
		txtOrderDate.setBounds(460, 167, 270, 40);
		contentPane.add(txtOrderDate);
		txtOrderDate.setColumns(10);
		
		txtProductID = new JTextField();
		txtProductID.setBounds(460, 263, 270, 40);
		contentPane.add(txtProductID);
		txtProductID.setColumns(10);
		
	}
}
