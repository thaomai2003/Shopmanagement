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

import Controller.Controller_Customer;
import Controller.Controller_Product;
import Model.Model_Customer;
import Model.Model_Product;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Customer extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField ID;
	private JTextField Phone;
	private JTextField Address;
	private List<Model_Customer> listcus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void showData(List<Model_Customer>customerl) {
		DefaultTableModel tableModel;  
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    customerl.forEach((customer) -> { 
	    	tableModel.addRow(new Object [] {
	    		customer.getId_customer(), customer.getPhone_customer(), customer.getAddress_customer()
	    	});
	    });
	    }

	/**
	 * Create the frame.
	 */
	public Customer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\customer_30px.png"));
		setTitle("CUSTOMER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 58, 332, 233);
		contentPane.add(scrollPane);
		listcus = new Controller_Customer().findAll();
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_customer", "phone_customer", "address_customer"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		System.out.print(listcus);
		showData(listcus);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\customer_48px.png"));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setBounds(90, 10, 200, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\add_16px.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Customer cus = new Model_Customer();
				cus.setId_customer(ID.getText());
				cus.setPhone_customer(Phone.getText());
				cus.setAddress_customer(Address.getText());
				System.out.println(ID.getText());
				Controller_Customer.Insert(cus);
				showData(listcus);
				Customer frame = new Customer();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(233, 150, 122));
		btnAdd.setBounds(28, 272, 106, 30);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Delete_16px.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Customer cus = new Model_Customer();
				cus.setId_customer(ID.getText());
				Controller_Customer.Delete(cus);
				showData(listcus);
				Customer frame = new Customer();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.setBounds(209, 272, 106, 30);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\update_16px.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Customer cus = null; 
				Model_Customer c = new Model_Customer();
				for(Model_Customer mc : listcus) {
					if(ID.getText().equals(mc.getId_customer())) {
						cus = mc;break;
					}
				}
				if(cus == null) return;
				cus.setId_customer(ID.getText());
				cus.setPhone_customer(Phone.getText());
				cus.setAddress_customer(Address.getText());
				System.out.println(ID.getText());
				Controller_Customer.Update(cus);
				showData(listcus);
				Customer frame = new Customer();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(233, 150, 122));
		btnUpdate.setBounds(28, 318, 108, 30);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\back_to_16px.png"));
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
		btnBack.setBounds(209, 318, 106, 30);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("id_customer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(5, 92, 140, 28);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(156, 92, 163, 28);
		contentPane.add(ID);
		
		JLabel lblNewLabel_1_3 = new JLabel("phone_customer");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(5, 150, 146, 28);
		contentPane.add(lblNewLabel_1_3);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBounds(156, 150, 163, 28);
		contentPane.add(Phone);
		
		JLabel lblNewLabel_1_4 = new JLabel("address_customer");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(5, 203, 146, 28);
		contentPane.add(lblNewLabel_1_4);
		
		Address = new JTextField();
		Address.setColumns(10);
		Address.setBounds(156, 203, 163, 28);
		contentPane.add(Address);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel md = table.getModel();			
				ID.setText(md.getValueAt(table.getSelectedRow(), 0).toString());								
				Phone.setText(md.getValueAt(table.getSelectedRow(), 1).toString());
				Address.setText(md.getValueAt(table.getSelectedRow(), 2).toString());					
			}
		});
	}
}
