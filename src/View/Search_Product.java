package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Product;
import Model.Model_Product;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search_Product extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ID_pro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Product frame = new Search_Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showData1(List<Model_Product>productl) {
		List<Model_Product>listproduct=new ArrayList<>();
		listproduct=productl;
		DefaultTableModel tableModel;
	    table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    listproduct.forEach((product) -> { 
	    	tableModel.addRow(new Object [] {
	    		product.getId_product(),product.getName_product(),product.getCategory(),
	    		product.getPrice(),product.getDiscount()
	    	});
	    });
	    }

	/**
	 * Create the frame.
	 */
	public Search_Product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 326);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH_PRODUCT");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_48px.png"));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(199, 10, 370, 48);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 68, 416, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_product", "name_product", "category", "price", "discount"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel_1 = new JLabel("id_product");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 121, 119, 24);
		contentPane.add(lblNewLabel_1);
		
		ID_pro = new JTextField();
		ID_pro.setBounds(139, 121, 154, 24);
		contentPane.add(ID_pro);
		ID_pro.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Product pro = new Model_Product();
				pro.setId_product(ID_pro.getText());				
				Controller_Product.Insert(pro);
				showData1(Controller_Product.FindByID(pro));
				JOptionPane.showMessageDialog(btnSearch, "Product Searched Successfully");
			}
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_16px.png"));
		btnSearch.setBackground(new Color(233, 150, 122));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(23, 188, 106, 30);
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
		btnBack.setBackground(new Color(233, 150, 122));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(165, 188, 106, 30);
		contentPane.add(btnBack);
	}

}
