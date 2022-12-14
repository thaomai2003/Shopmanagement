package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("LOGIN FORM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\login_32px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\login_32px.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("VnTimes", Font.BOLD, 25));
		lblNewLabel.setBounds(539, 10, 150, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\contacts_32px.png"));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(526, 80, 39, 29);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setText("username");
		username.setBorder(null);
		username.setBackground(new Color(255, 228, 196));
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		username.setBounds(575, 80, 150, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\lock_32px.png"));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(530, 141, 40, 29);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setBackground(new Color(255, 228, 196));
		password.setText("Password");
		password.setBounds(575, 141, 150, 30);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\login_16px.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/meimeishopmanagement");
					String sql = "SELECT * FROM login WHERE user_name =? AND password =?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username.getText() );
					ps.setString(2, password.getText());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						HomeScreen home = new HomeScreen();
						home.setVisible(true);
						home.setLocationRelativeTo(null);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(btnLogin, "Wrong Username or Password");
						username.setText("");
						password.setText("");
					}
					conn.close();
				}catch (Exception e1) { 
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBackground(new Color(233, 150, 122));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(493, 210, 100, 29);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\close_window_16px.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Selected", JOptionPane.YES_NO_OPTION);
				if (a==0) {
					setVisible(false);
				}
			}
		});
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBackground(new Color(233, 150, 122));
		btnExit.setBounds(637, 210, 100, 29);
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 398, 311);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hi\u0300nh a\u0309nh\\shop_200px.png"));
		lblNewLabel_1.setBounds(73, 27, 246, 194);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to MeiMeiShop");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(32, 231, 332, 28);
		panel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(575, 110, 150, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(575, 170, 150, 2);
		contentPane.add(separator_1);
		
		JLabel Message = new JLabel("Forgot password");
		Message.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(Message, "Call 119 for help");
			}
		});
		Message.setFont(new Font("Tahoma", Font.BOLD, 15));
		Message.setBounds(555, 270, 140, 20);
		contentPane.add(Message);
		
		
	}
}
