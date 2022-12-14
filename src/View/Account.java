package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import Controller.Controller_Customer;
import Controller.Controller_Employee;
import Controller.Controller_Login;
import Model.Model_Login;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;

public class Account extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField username;
	private JTextField password;
	private JTextField id_emp;
	private List<Model_Login> ListAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showData(List<Model_Login>log) {
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		log.forEach((login) -> { 
	    	tableModel.addRow(new Object [] {
	    		login.getUser_name(), login.getPassword(), login.getId_employee()
	    	});
	    });
	}
	
	

	/**
	 * Create the frame.
	 */
	public Account() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\account_30px.png"));
		setTitle("ACCOUNT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\account_50px.png"));
		lblNewLabel.setFont(new Font("VnTimes", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(287, 10, 217, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 87, 445, 275);
		contentPane.add(scrollPane);
		ListAccount = new Controller_Login().findAll();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"user_name", "password", "id_employee"
			}
		));
		showData(ListAccount);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 103, 134, 26);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(168, 100, 143, 29);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(24, 142, 134, 26);
		contentPane.add(lblNewLabel_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(168, 139, 143, 29);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_2 = new JLabel("id_employee");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(24, 181, 134, 26);
		contentPane.add(lblNewLabel_1_2);
		
		id_emp = new JTextField();
		id_emp.setColumns(10);
		id_emp.setBounds(168, 178, 143, 29);
		contentPane.add(id_emp);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(233, 150, 122));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Login log = new Model_Login();
				log.setUser_name(username.getText());
				log.setPassword(password.getText());
				log.setId_employee(id_emp.getText());
				Controller_Login.Insert(log);
				showData(ListAccount);
				Account frame = new Account();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
				
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\add_16px.png"));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(24, 258, 110, 34);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Login log = new Model_Login();
				log.setUser_name(username.getText());
				Controller_Login.Delete(log);
				showData(ListAccount);
				Account frame = new Account();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\Delete_16px.png"));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(201, 258, 110, 34);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(233, 150, 122));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Login log = new Model_Login();
				log.setUser_name(username.getText());
				log.setPassword(password.getText());
				log.setId_employee(id_emp.getText());
				Controller_Login.Update(log);
				showData(ListAccount);
				JOptionPane.showMessageDialog(btnUpdate, "Account Updated Successfully");
				Account frame = new Account();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\update_16px.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(24, 317, 110, 34);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(233, 150, 122));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeScreen home = new HomeScreen();
				home.setVisible(true);
				home.setLocationRelativeTo(null);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\back_to_16px.png"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(201, 317, 110, 34);
		contentPane.add(btnBack);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel md = table.getModel();			
				username.setText(md.getValueAt(table.getSelectedRow(), 0).toString());								
				password.setText(md.getValueAt(table.getSelectedRow(), 1).toString());
				id_emp.setText(md.getValueAt(table.getSelectedRow(), 2).toString());					
			}
		});
	}
}
