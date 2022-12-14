package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Seach_Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seach_Home frame = new Seach_Home();
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
	public Seach_Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_24px.png"));
		setTitle("SEARCH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEARCH ");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\search_48px.png"));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setBounds(209, 10, 179, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Employee");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\employee_24px.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Employee SE = new Search_Employee();
				SE.setVisible(true);
				SE.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setBounds(24, 132, 145, 48);
		contentPane.add(btnNewButton);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\product_16px.png"));
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Product SP = new Search_Product();
				SP.setVisible(true);
				SP.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProduct.setBackground(new Color(233, 150, 122));
		btnProduct.setBounds(214, 132, 145, 48);
		contentPane.add(btnProduct);
		
		JButton btnBill = new JButton("Bill");
		btnBill.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\bill_16px.png"));
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Bill SB = new Search_Bill();
				SB.setVisible(true);
				SB.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBill.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBill.setBackground(new Color(233, 150, 122));
		btnBill.setBounds(412, 132, 145, 48);
		contentPane.add(btnBill);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen home = new HomeScreen();
				home.setVisible(true);
				home.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(233, 150, 122));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\back_to_16px.png"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(453, 299, 121, 27);
		contentPane.add(btnBack);
	}
}
