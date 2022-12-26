package com.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.model.Customer;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;


public class View_Customer extends JFrame {
	
	private static final long serialVersionUID=1L;
	private JPanel contentPane;
	private JTextField txtSearchCustomer;
	private JTable table;
	public JTable tblView_Customer;
	CustomerFrame customerFrameObj;
	DefaultTableModel model;
	/*
	 * Launch the Appliication
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Customer frame=new View_Customer();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	//create the frame
	public View_Customer() {
		// TODO Auto-generated constructor stub
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Customer.class.getResource("/icons/business-card.png")));
		setTitle("Custommer_Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1066,556);
		contentPane=new JPanel();
		contentPane.setBackground(new Color(255,218,185));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtSearchCustomer=new JTextField();
		txtSearchCustomer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filterTable();
			}
		});
		txtSearchCustomer.setFont(new Font("Times New Roman",Font.BOLD,18));
		txtSearchCustomer.setBounds(22,20,873,36);
		contentPane.add(txtSearchCustomer);
		txtSearchCustomer.setColumns(10);
		
		JButton btnSearch=new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterTable();
			}
		});
		btnSearch.setIcon(new ImageIcon(View_Customer.class.getResource("/icons/search.png")));
		btnSearch.setFont(new Font("Times New Romman",Font.BOLD,18));
		btnSearch.setBounds(905,16,120,43);
		contentPane.add(btnSearch);
		
		JPanel panel=new JPanel();
		panel.setBorder(new LineBorder(new Color(0,0,0),3));
		btnSearch.setBounds(49,344,828,-230);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table=new JTable();
		table.setBounds(6,15,816,-251);
		panel.add(table);
		table.setFont(new Font("Times New Roman",Font.BOLD,18));
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null,null,null,null,null,null,null},
					{null,null,null,null,null,null,null},	
				},
				new String[] {
						"Admin_ID","Admin_Name","Date of Birth","Gender","Address","Mobile_no","Email"
				}
		));
		JButton btnGetDetails=new JButton("Get Details");
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//System.out.println(tblViewAdmin.getValueAt(tblViewAdmin.getSelectedRow(),tblViewAdmin.getelectedColumn()));
					if(tblView_Customer.getSelectedRow()!=-1||tblView_Customer.getSelectedColumn()!=-1) 
					{
						String customerId=(String)tblView_Customer.getValueAt(tblView_Customer.getSelectedRow(),0);
						System.out.println(customerId);
						customerFrameObj=new CustomerFrame();
						customerFrameObj.getCustomerDetailByID(customerId);
						setVisible(false);
						customerFrameObj.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Please Select the Row...","Info",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(IndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
		});
		btnGetDetails.setIcon(new ImageIcon(View_Customer.class.getResource("/icons/details.png")));
		btnGetDetails.setFont(new Font("Times New Roman",Font.BOLD,18));
		btnGetDetails.setBounds(276,421,159,43);
		contentPane.add(btnGetDetails);
		
		JButton btnClose=new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		btnClose.setIcon(new ImageIcon(View_Customer.class.getResource("/icons/close.png")));
		btnClose.setBounds(22,66,873,326);
		contentPane.add(btnClose);
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(22,66,873,326);
		contentPane.add(scrollPane);
		
		tblView_Customer=new JTable();
		
		tblView_Customer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblView_Customer);
		tblView_Customer.setFont(new Font("Times New Romman",Font.BOLD,12));
		tblView_Customer.setModel(new DefaultTableModel(
				new Object[][] {
					{null,null,null,null,null,null}
				},
				new String[] {
						"Customer_ID","Customer_Name","Gender","Email","Address","Mobile_Number"
				}
				));
			tblView_Customer.getColumnModel().getColumn(1).setPreferredWidth(90);
			tblView_Customer.getColumnModel().getColumn(1).setPreferredWidth(120);
			tblView_Customer.getColumnModel().getColumn(4).setPreferredWidth(90);
			tblView_Customer.getColumnModel().getColumn(5).setPreferredWidth(90);
			populateTable();
	}
	
	/*Populate dbrecords into the Swing Table*/
	void populateTable() {
		customerFrameObj=new CustomerFrame();
		model=(DefaultTableModel)tblView_Customer.getModel();
		List<Customer> customerList=customerFrameObj.getCustomerDetails();
		Object rowData[]=new Object[tblView_Customer.getColumnCount()];
		System.out.println("rowData="+rowData.length);
		model.setRowCount(0);
		/*print ArrayList Size*/
		System.out.println("Array List Size="+customerList.size());
		for(int i=0;i<customerList.size();i++) {
			/*Display ArrayList data here 
			 * System.out.println(adminList.get(i).getAdmnn_ID()+""+adminList.get(i).getAdmin_Name()+""+adminList.get(i).getDob()+
			 * " "+adminList.get(i).getGender()+" ".....)*/
		
					rowData[0]=customerList.get(i).getCustomer_ID();
					rowData[1]=customerList.get(i).getCustomerName();
					rowData[2]=customerList.get(i).getGender();
					rowData[3]=customerList.get(i).getEmail();
					rowData[4]=customerList.get(i).getAddress();
					rowData[5]=customerList.get(i).getMobile_Number();

					System.out.println(rowData[0]+"\t"+rowData[1]+"\t"+rowData[2]+"\t"+rowData[3]+"\t"+rowData[4]+"\t"+rowData[5]);
					model.addRow(rowData);
		}
		
	}
	void filterTable() {
		model=(DefaultTableModel)tblView_Customer.getModel();
		TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<DefaultTableModel>(model);
		tblView_Customer.setRowSorter(sorter);
		String text=txtSearchCustomer.getText();
		try {
			sorter.setRowFilter(RowFilter.regexFilter(text));
		}catch(PatternSyntaxException pse) {
			System.err.println("Bad regex pattern");
		}
	}

}








