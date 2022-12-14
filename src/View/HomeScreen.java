package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setTitle("HOMESCREEN");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\home_50px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBill = new JButton("Bill");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill bill = new Bill();
				bill.setVisible(true);
				bill.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBill.setForeground(Color.WHITE);
		btnBill.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\bill_40px.png"));
		btnBill.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnBill.setBackground(new Color(233, 150, 122));
		btnBill.setBounds(45, 237, 217, 88);
		contentPane.add(btnBill);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cus = new Customer();
				cus.setVisible(true);
				cus.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnCustomer.setForeground(Color.WHITE);
		btnCustomer.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\customer_48px.png"));
		btnCustomer.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnCustomer.setBackground(new Color(233, 150, 122));
		btnCustomer.setBounds(45, 375, 217, 88);
		contentPane.add(btnCustomer);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
				emp.setVisible(true);
				emp.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnEmployee.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\employee_48px.png"));
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setHorizontalAlignment(SwingConstants.LEADING);
		btnEmployee.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnEmployee.setBackground(new Color(233, 150, 122));
		btnEmployee.setBounds(369, 110, 217, 88);
		contentPane.add(btnEmployee);
		
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = new Account();
				acc.setVisible(true);
				acc.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnAccount.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\account_50px.png"));
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnAccount.setBackground(new Color(233, 150, 122));
		btnAccount.setBounds(45, 110, 217, 87);
		contentPane.add(btnAccount);
		
		
		JButton btnProduct = new JButton("Product");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pro = new Product();
				pro.setVisible(true);
				pro.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		
		btnProduct.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\product_48px.png"));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnProduct.setBackground(new Color(233, 150, 122));
		btnProduct.setBounds(470, 237, 226, 88);
		contentPane.add(btnProduct);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Selected", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					setVisible(false);
					Login log = new Login();
					log.setVisible(true);
					log.setLocationRelativeTo(null);
				}
			}
		});
		
		btnLogout.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\Logout_50px.png"));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnLogout.setBackground(new Color(233, 150, 122));
		btnLogout.setBounds(369, 515, 217, 88);
		contentPane.add(btnLogout);
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Seach_Home sear = new Seach_Home();
				sear.setVisible(true);
				sear.setLocationRelativeTo(null);
			}
		});
		
		btnProduct.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\product_48px.png"));
		btnProduct.setForeground(Color.WHITE);
		btnProduct.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnProduct.setBackground(new Color(233, 150, 122));
		btnProduct.setBounds(369, 237, 217, 88);
		contentPane.add(btnProduct);
		
		
		
		
		btnSearch.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_50px.png"));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnSearch.setBackground(new Color(233, 150, 122));
		btnSearch.setBounds(369, 375, 217, 88);
		contentPane.add(btnSearch);
		
		JButton btnStaticial = new JButton("Staticial");
		btnStaticial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staticial sta = new Staticial();
				sta.setVisible(true);
				sta.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnStaticial.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\static_views_40px.png"));
		btnStaticial.setForeground(Color.WHITE);
		btnStaticial.setFont(new Font("VnTimes", Font.BOLD, 30));
		btnStaticial.setBackground(new Color(233, 150, 122));
		btnStaticial.setBounds(45, 515, 217, 88);
		contentPane.add(btnStaticial);
		
		JLabel lblShopManagementSystem = new JLabel("MEIMEISHOP MANAGEMENT SYSTEM");
		lblShopManagementSystem.setBounds(10, 10, 624, 50);
		contentPane.add(lblShopManagementSystem);
		lblShopManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblShopManagementSystem.setForeground(new Color(25, 25, 112));
		lblShopManagementSystem.setFont(new Font("VnTimes", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(624, 0, 468, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\online_shopping_design_elements_computer_goods_icons_35261.jpg"));
		lblNewLabel_1.setBounds(0, 0, 468, 696);
		panel.add(lblNewLabel_1);

	}
}
