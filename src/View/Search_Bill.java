package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Bill;
import Model.Model_Bill;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Search_Bill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id_bill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Bill frame = new Search_Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void showData(List<Model_Bill> b) {
		List<Model_Bill>billList=new ArrayList<>();
		billList=b;
		
		DefaultTableModel tableModel;
		table.getModel();
	    tableModel=(DefaultTableModel)table.getModel();
	    tableModel.setRowCount(0);
	    billList.forEach((bill) -> { 
	    	tableModel.addRow(new Object [] {
	    		bill.getId_bill(), bill.getDate(), bill.getId_product(), bill.getId_employee(), bill.getId_customer(),
	    		bill.getQuantity(), bill.getDiscount(), bill.getTotal()
	    	});
//	    sum+=bill.getTotal();
	    System.out.println(bill);
	    });
	    
	    }

	/**
	 * Create the frame.
	 */
	public Search_Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH_BILL");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_48px.png"));
		lblNewLabel.setBounds(316, 10, 314, 54);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 74, 604, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id_bill", "date", "id_product", "id_employee", "id_customer", "quantity", "discount", "total"
				}
			));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("id_bill");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 102, 115, 21);
		contentPane.add(lblNewLabel_1);
		
		id_bill = new JTextField();
		id_bill.setBounds(138, 102, 195, 21);
		contentPane.add(id_bill);
		id_bill.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model_Bill bill = new Model_Bill();
				bill.setId_bill(id_bill.getText());	
				Controller_Bill.Insert(bill);
				showData(Controller_Bill.FindByID(bill));
				JOptionPane.showMessageDialog(btnSearch, "Bill Searched Successfully");	
			}
		});
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_16px.png"));
		btnSearch.setBackground(new Color(233, 150, 122));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(27, 176, 106, 30);
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
		btnBack.setBounds(194, 176, 106, 30);
		contentPane.add(btnBack);
	}

}
