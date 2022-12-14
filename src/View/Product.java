package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Employee;
import Controller.Controller_Product;
import Model.Model_Employee;
import Model.Model_Product;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ID;
	private JTextField Name;
	private JTextField Price;

	private JTextField Discount;
	private List<Model_Product> listpro;
	private JTextField Category;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	public void showData(List<Model_Product>productl) {
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    productl.forEach((product) -> { 
	    	tableModel.addRow(new Object [] {
	    		product.getId_product(),product.getName_product(),product.getCategory(),
	    		product.getPrice(),product.getDiscount()
	    	});
	    });
	    }

	/**
	 * Create the frame.
	 */
	public Product() {
		setTitle("PRODUCT");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\product_16px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 51, 406, 291);
		contentPane.add(scrollPane);
		listpro = new Controller_Product().findAll();
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"id_product", "name_product", "category", "price", "discount"
			}
		));

		System.out.print(listpro);
		showData(listpro);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("PRODUCT");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\product_30px.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setBounds(70, 1, 250, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id_product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 90, 131, 23);
		contentPane.add(lblNewLabel_1);
		
		ID = new JTextField();
		ID.setBounds(151, 90, 175, 23);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("name_product");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 134, 131, 23);
		contentPane.add(lblNewLabel_1_1);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(151, 134, 175, 23);
		contentPane.add(Name);
		
		JLabel lblNewLabel_1_2 = new JLabel("category");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 180, 131, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("price");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 221, 131, 23);
		contentPane.add(lblNewLabel_1_3);
		
		Price = new JTextField();
		Price.setColumns(10);
		Price.setBounds(151, 221, 175, 23);
		contentPane.add(Price);
		
		JLabel lblNewLabel_1_4 = new JLabel("discount");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 263, 131, 23);
		contentPane.add(lblNewLabel_1_4);
		
		Discount = new JTextField();
		Discount.setColumns(10);
		Discount.setBounds(151, 263, 175, 23);
		contentPane.add(Discount);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setBackground(new Color(255, 255, 255));
		cbCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"cat01", "cat02", "cat03"}));
		cbCategory.setBounds(151, 183, 75, 21);
		contentPane.add(cbCategory);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\add_16px.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Product pro = new Model_Product();
				pro.setId_product(ID.getText());
				pro.setName_product(Name.getText());
				pro.setCategory(cbCategory.getSelectedItem().toString());
				pro.setPrice(Double.parseDouble(Price.getText()));
				pro.setDiscount(Double.parseDouble(Discount.getText()));
				System.out.println(ID.getText());
				Controller_Product.Insert(pro);
				showData(listpro);
				Product frame = new Product();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(233, 150, 122));
		btnAdd.setBounds(35, 312, 106, 30);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\Delete_16px.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Product pro = new Model_Product();
				pro.setId_product(ID.getText());
				Controller_Product.Delete(pro);
				showData(listpro);
				Product frame = new Product();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.setBounds(216, 312, 106, 30);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\update_16px.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Product pro = new Model_Product();
				pro.setId_product(ID.getText());
				pro.setName_product(Name.getText());
				pro.setCategory(cbCategory.getSelectedItem().toString());
				pro.setPrice(Double.parseDouble(Price.getText()));
				pro.setDiscount(Double.parseDouble(Discount.getText()));
				System.out.println(ID.getText());
				Controller_Product.Update(pro);
				showData(listpro);
				JOptionPane.showMessageDialog(btnUpdate, "Product Updated Successfully");
				Product frame = new Product();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(233, 150, 122));
		btnUpdate.setBounds(35, 358, 108, 30);
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
		btnBack.setBounds(216, 358, 106, 30);
		contentPane.add(btnBack);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel md = table.getModel();			
				ID.setText(md.getValueAt(table.getSelectedRow(), 0).toString());								
				Name.setText((String) md.getValueAt(table.getSelectedRow(), 1));
				cbCategory.setSelectedItem(md.getValueAt(table.getSelectedRow(), 2));
				Price.setText(md.getValueAt(table.getSelectedRow(), 3).toString());
				Discount.setText(md.getValueAt(table.getSelectedRow(), 4).toString());					
			}
		});
		
		
	}
}
