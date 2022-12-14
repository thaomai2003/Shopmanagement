package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Employee;
import Model.Model_Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Search_Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ID_emp;
	private JTextField Name_emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Employee frame = new Search_Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showData(List<Model_Employee>employeel) {
		List<Model_Employee>listemployee=new ArrayList<>();
		listemployee=employeel;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listemployee.forEach((employee) -> { 
	    	String gender;
	    	if (employee.getGender()==1) gender = "Female";
	    	else {gender = "Male";}
	    	tableModel.addRow(new Object [] {
	    		employee.getId_employee(), employee.getName_employee(), gender, 
	    		employee.getPhone_employee(),employee.getAddress_employee()
	    	});
	    });
	    }

	/**
	 * Create the frame.
	 */
	public Search_Employee() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_24px.png"));
		setTitle("SEARCH EMPLOYEE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchEmployee = new JLabel("SEARCH EMPLOYEE ");
		lblSearchEmployee.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_48px.png"));
		lblSearchEmployee.setForeground(new Color(25, 25, 112));
		lblSearchEmployee.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblSearchEmployee.setBounds(318, 10, 323, 48);
		contentPane.add(lblSearchEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 86, 544, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_employee", "name_employee", "gender", "phone_employee", "address_employee"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		ID_emp = new JTextField();
		ID_emp.setBounds(173, 90, 159, 21);
		contentPane.add(ID_emp);
		ID_emp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("id_employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 90, 113, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("name_employee");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(24, 134, 139, 21);
		contentPane.add(lblNewLabel_1_1);
		
		Name_emp = new JTextField();
		Name_emp.setColumns(10);
		Name_emp.setBounds(173, 134, 159, 21);
		contentPane.add(Name_emp);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Employee emp = new Model_Employee();				
				emp.setId_employee(ID_emp.getText());
				emp.setName_employee(Name_emp.getText());
				Controller_Employee.Insert(emp);
				showData(Controller_Employee.FindByAll(emp));
				JOptionPane.showMessageDialog(btnSearch, "Employee Searched Successfully");
			}
				
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_16px.png"));
		btnSearch.setBackground(new Color(233, 150, 122));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(58, 209, 106, 30);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seach_Home sear = new Seach_Home();
				sear.setVisible(true);
				sear.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\back_to_16px.png"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(new Color(233, 150, 122));
		btnBack.setBounds(206, 209, 106, 30);
		contentPane.add(btnBack);
	}
}
