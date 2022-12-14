package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller_Employee;
import Model.Model_Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ID;
	private JTextField Name;
	private JTextField Phone;
	private JTextField Address;
	private List<Model_Employee> listemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void showData(List<Model_Employee>employeel) {
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    employeel.forEach((employee) -> { 
	    	String gender;
	    	if (employee.getGender()==0) gender = "Male";
	    	else {gender = "Female";}
	    	tableModel.addRow(new Object [] {
	    		employee.getId_employee(), employee.getName_employee(), gender, 
	    		employee.getPhone_employee(),employee.getAddress_employee()
	    	});
	    });
	    }

	/**
	 * Create the frame.
	 */
	public Employee() {
		setTitle("EMPLOYEE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\employee_50px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 78, 460, 267);
		contentPane.add(scrollPane);
		listemp = new Controller_Employee().findAll();
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"id_employee", "name_employee", "gender", "phone_employee", "address_employee"
			}
			
		));
		System.out.print(listemp);
		showData(listemp);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setMinWidth(75);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(76);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\employee_48px.png"));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setBounds(110, 10, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id_employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 75, 146, 28);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setBounds(166, 75, 198, 28);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("name_employee");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 123, 146, 28);
		contentPane.add(lblNewLabel_1_1);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(166, 123, 198, 28);
		contentPane.add(Name);
		
		JLabel lblNewLabel_1_2 = new JLabel("gender");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 172, 146, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox cbGender = new JComboBox();
		cbGender.setBackground(Color.WHITE);
		cbGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(166, 172, 198, 27);
		contentPane.add(cbGender);
		
		JLabel lblNewLabel_1_3 = new JLabel("phone_employee");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 225, 146, 28);
		contentPane.add(lblNewLabel_1_3);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(166, 225, 198, 28);
		contentPane.add(Phone);
		
		JLabel lblNewLabel_1_4 = new JLabel("address_employee");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 278, 146, 28);
		contentPane.add(lblNewLabel_1_4);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(166, 278, 198, 28);
		contentPane.add(Address);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\add_16px.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Employee emp = new Model_Employee();
				emp.setId_employee(ID.getText());
				emp.setName_employee(Name.getText());
				emp.setGender(Integer.valueOf(cbGender.getSelectedIndex()));
				emp.setPhone_employee(Phone.getText());
				emp.setAddress_employee(Address.getText());
				
				Controller_Employee.Insert(emp);
				showData(listemp);
				System.out.println(emp);

				Employee frame = new Employee();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnAdd.setBackground(new Color(233, 150, 122));
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(35, 342, 100, 30);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\Delete_16px.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Employee emp = new Model_Employee();
				emp.setId_employee(ID.getText());
				Controller_Employee.Delete(emp);
				showData(listemp);
				Employee frame = new Employee();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.setBounds(229, 342, 106, 30);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\update_16px.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Employee emp = new Model_Employee();
				emp.setId_employee(ID.getText());
				emp.setName_employee(Name.getText());
				emp.setGender(cbGender.getSelectedIndex());
				emp.setPhone_employee(Phone.getText());
				emp.setAddress_employee(Address.getText());
				System.out.println(ID.getText());
				Controller_Employee.Update(emp);
				showData(listemp);
				JOptionPane.showMessageDialog(btnUpdate, "Employee Updated Successfully");
				Employee frame = new Employee();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(233, 150, 122));
		btnUpdate.setBounds(35, 404, 108, 30);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\back_to_16px.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomeScreen home = new HomeScreen();
				home.setVisible(true);
				home.setLocationRelativeTo(null);
			}
		});
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(new Color(233, 150, 122));
		btnBack.setBounds(229, 404, 100, 30);
		contentPane.add(btnBack);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel md = table.getModel();			
				ID.setText(md.getValueAt(table.getSelectedRow(), 0).toString());								
				Name.setText((String) md.getValueAt(table.getSelectedRow(), 1));
				cbGender.setSelectedItem(md.getValueAt(table.getSelectedRow(), 2));
				Phone.setText(md.getValueAt(table.getSelectedRow(), 3).toString());
				Address.setText(md.getValueAt(table.getSelectedRow(), 4).toString());					
			}
		});
		
		
	}
}
