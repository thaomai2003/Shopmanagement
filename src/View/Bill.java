package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.Controller_Bill;
import Controller.Controller_Employee;
import Model.Model_Bill;
import Model.Model_Employee;
import Model.Model_Product;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id_bill;
	private JTextField date;
	private JTextField quantity;
	private JTextField discount;
	private JTextField total;
	private List<Model_Bill> listBill;
	public int sum=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void showData(List<Model_Bill> b) { 
		DefaultTableModel tableModel;
	    tableModel=(DefaultTableModel)table.getModel(); 
	    tableModel.setRowCount(0); // khúc này cũng ko rõ :v 
	    b.forEach((bill) -> { 
	    	tableModel.addRow(new Object [] {
	    		bill.getId_bill(), bill.getDate(), bill.getId_product(), bill.getId_employee(), bill.getId_customer(),
	    		bill.getQuantity(), bill.getDiscount(), bill.getTotal()
	    	});
	    	
	    sum+=bill.getTotal(); 
	    System.out.println(bill);
	    });
	    
	    } 

	/**
	 * Create the frame.
	 */
	public Bill() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\bill_16px.png"));
		setTitle("BILL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 766);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 400, 794, 229);
		contentPane.add(scrollPane);
		listBill = new Controller_Bill().findAll();// đây haha
		
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};
		table.setBackground(new Color(255, 250, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"id_bill", "date", "id_product", "id_employee", "id_customer", "quantity", "discount", "total"
			}
		));
		
		System.out.println(listBill);
		showData(listBill);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("BILL MANAGEMENT");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\bill_50px.png"));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 5, 323, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id_bill");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 92, 141, 25);
		contentPane.add(lblNewLabel_1);
		
		id_bill = new JTextField();
		id_bill.setBounds(160, 92, 200, 25);
		contentPane.add(id_bill);
		id_bill.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(418, 92, 141, 25);
		contentPane.add(lblNewLabel_1_1);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(568, 92, 200, 25);
		contentPane.add(date);
		
		JLabel lblNewLabel_1_2 = new JLabel("id_product");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 143, 141, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox cbProduct = new JComboBox();
		cbProduct.setBackground(new Color(255, 255, 255));
		cbProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbProduct.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07"}));
		cbProduct.setBounds(160, 147, 101, 25);
		contentPane.add(cbProduct);

		
		JComboBox cbEmployee = new JComboBox();
		cbEmployee.setBackground(new Color(255, 255, 255));
		cbEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbEmployee.setModel(new DefaultComboBoxModel(new String[] {"emp01", "emp02", "emp03", "emp04", "emp05", "emp06", "emp07"}));
		cbEmployee.setBounds(568, 147, 101, 25);
		contentPane.add(cbEmployee);
		
		JLabel lblNewLabel_1_3 = new JLabel("id_employee");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(418, 143, 122, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("id_customer");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 191, 141, 25);
		contentPane.add(lblNewLabel_1_4);
				
		JComboBox cbCustomer = new JComboBox();
		cbCustomer.setBackground(new Color(255, 255, 255));
		cbCustomer.setModel(new DefaultComboBoxModel(new String[] {"cus01", "cus02", "cus03", "cus04", "cus05", "cus06", "cus07", "cus08", "cus09", "cus10"}));
		cbCustomer.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbCustomer.setBounds(160, 195, 101, 25);
		contentPane.add(cbCustomer);
		
		JLabel lblNewLabel_1_5 = new JLabel("quantity");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(418, 191, 141, 25);
		contentPane.add(lblNewLabel_1_5);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(568, 191, 200, 25);
		contentPane.add(quantity);
		
		JLabel lblNewLabel_1_6 = new JLabel("discount");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(10, 236, 141, 25);
		contentPane.add(lblNewLabel_1_6);
		
		discount = new JTextField();
		discount.setColumns(10);
		discount.setBounds(160, 236, 200, 25);
		contentPane.add(discount);
		
		JLabel lblNewLabel_1_7 = new JLabel("total");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(418, 236, 141, 25);
		contentPane.add(lblNewLabel_1_7);
		
		total = new JTextField();
		total.setColumns(10);
		total.setBounds(568, 236, 200, 25);
		contentPane.add(total);
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\add_16px.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Bill bill = new Model_Bill();
				bill.setId_bill(id_bill.getText());
				String date_now = date.getText();
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_now);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				java.sql.Date d = new java.sql.Date(date1.getTime());
				
				bill.setDate(d); 
				bill.setId_product(cbProduct.getSelectedItem().toString());
				bill.setId_employee(cbEmployee.getSelectedItem().toString());
				bill.setId_customer(cbCustomer.getSelectedItem().toString());
				bill.setQuantity(Integer.parseInt(quantity.getText()));
				bill.setDiscount(Double.parseDouble(discount.getText()));
	
				
				if(Controller_Bill.Insert(bill) == 1) {
					showData(listBill);
					System.out.println(bill);
					
					Bill frame = new Bill();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					setVisible(false);
				}
				
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setBounds(117, 330, 90, 30);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\Delete_16px.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Bill bill = new Model_Bill();
				bill.setId_bill(id_bill.getText());
				Controller_Bill.Delete(bill);
				showData(listBill);
				Bill frame = new Bill();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.setBounds(268, 330, 120, 30);
		contentPane.add(btnDelete);
		
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
		btnBack.setBounds(613, 330, 96, 30);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\update_16px.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Bill bill = null;
				for(Model_Bill bll : listBill) {
					if(id_bill.getText().equals(bll.getId_bill())) {
						bill = bll;
					}
				}
				if(bill == null) {
					return;
				}
				bill.setId_bill(id_bill.getText());
				String date_now = date.getText();
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date_now);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				java.sql.Date d = new java.sql.Date(date1.getTime());
				bill.setDate(d); 
				bill.setId_product(cbProduct.getSelectedItem().toString());
				bill.setId_employee(cbEmployee.getSelectedItem().toString());
				bill.setId_customer(cbCustomer.getSelectedItem().toString());
				bill.setQuantity(Integer.parseInt(quantity.getText()));
				bill.setDiscount(Double.parseDouble(discount.getText()));
				bill.setTotal(Double.parseDouble(total.getText()));
				
				Controller_Bill.Update(bill);
				showData(listBill);
				System.out.println(bill);
				JOptionPane.showMessageDialog(btnUpdate, "Bill Updated Successfully");
				Bill frame = new Bill();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(233, 150, 122));
		btnUpdate.setBounds(438, 330, 120, 30);
		contentPane.add(btnUpdate);
		
		JLabel Total = new JLabel("TOTAL REVENUE");
		Total.setFont(new Font("Tahoma", Font.BOLD, 20));
		Total.setBounds(400, 650, 177, 33);
		contentPane.add(Total);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTotal.setBounds(600, 650, 177, 33);
		contentPane.add(lblTotal);
		lblTotal.setText(Integer.toString(sum));
	
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {			
			TableModel md = table.getModel();
			id_bill.setText(md.getValueAt(table.getSelectedRow(), 0).toString());	
			date.setText(test((java.sql.Date) md.getValueAt(table.getSelectedRow(), 1)));	
			cbProduct.setSelectedItem(md.getValueAt(table.getSelectedRow(), 2));
			cbEmployee.setSelectedItem(md.getValueAt(table.getSelectedRow(), 3));
			cbCustomer.setSelectedItem(md.getValueAt(table.getSelectedRow(), 4));
			quantity.setText(md.getValueAt(table.getSelectedRow(), 5).toString());
			discount.setText(md.getValueAt(table.getSelectedRow(), 6).toString());
			String tot = ((Double) md.getValueAt(table.getSelectedRow(), 7)).toString();
			total.setText(tot);
		}
	});	
	
	
}
	public String test(java.sql.Date d) {
		return String.format("%s/%s/%s", d.getDay(), d.getMonth(), d.getYear() + 1900);
		
	}
}
