package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminActivity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActivity frame = new AdminActivity();
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
	
	public AdminActivity() {
		setFont(new Font("Arial",Font.BOLD,18));
	//	setBackground(new Color(255,218,185));
		//setForeground(Color.GRAY);
		setTitle("Admin Activity");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,218,185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);	
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Customers");
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(225, 30, 156, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sales");
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(225, 75, 156, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Members");
		btnNewButton_2.setForeground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(225, 120, 156, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Menu");
		btnNewButton_3.setBounds(225, 165, 156, 23);
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log 0ut");
		btnNewButton_4.setBounds(225, 210, 156, 23);
		btnNewButton_4.setForeground(Color.GREEN);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(btnNewButton_4);
		
		}
}
