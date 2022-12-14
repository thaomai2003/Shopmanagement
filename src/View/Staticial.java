package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import Controller.Controller_Bill;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staticial extends JFrame {

	private JPanel contentPane;
	private Connection connection;
	private ChartPanel chartPanel;
	private final JButton btnNewButton = new JButton("Back");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Staticial frame = new Staticial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Staticial() {
		connection = Controller_Bill.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		chartPanel = new ChartPanel(null);
		chartPanel.setPreferredSize(new Dimension(544, 397));
		contentPane.add(chartPanel);		
		loadChart();		
	}
	public void loadChart() {
		JDBCCategoryDataset cd;
		try {
			cd = new JDBCCategoryDataset(connection,  "SELECT id_employee 'thang', sum(quantity_product) 'num of products sold'  FROM detail_bills GROUP BY id_employee");
			System.out.println(cd.getRowKeys());
			JFreeChart chart = ChartFactory.createBarChart("Statistics on the number of products sold by each employee", "id_employee", "number of products sold", cd);
			new BarRenderer();
			chartPanel = new ChartPanel(chart);
			chartPanel.setBackground(Color.red);
			chartPanel.setPreferredSize(new java.awt.Dimension(544, 397));
			chartPanel.setVisible(true);
			chartPanel.setSize(544, 397);
			chartPanel.repaint();
			contentPane.removeAll();
			contentPane.add(chartPanel);
			chartPanel.setLayout(null);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomeScreen home = new HomeScreen();
					home.setVisible(true);
					home.setLocationRelativeTo(null);
					setVisible(false);
				}
			});
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\DELL\\OneDrive\\Hình ảnh\\back_to_16px.png"));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(561, 409, 118, 31);
			chartPanel.add(btnNewButton);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
