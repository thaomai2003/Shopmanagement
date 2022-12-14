package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Model_Customer;

public class Controller_Customer {
	private Connection conn;
	private PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static Connection getConnection() {
		Connection conn = null;
		try{ 
			   String userName = "root";
			   String password = "";
			   String DatabaseName = "meimeishopmanagement";
			   String url = "jdbc:mysql://localhost/meimeishopmanagement";
			   Class.forName ("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<Model_Customer> findAll() {
		String sql = "SELECT * FROM customers";
		List<Model_Customer> CusList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model_Customer cus = new Model_Customer(rs.getString("id_customer"),
						                  rs.getString("phone_customer"),
						                  rs.getString("address_customer"));
				CusList.add(cus);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return CusList;
		
	}
	
	public static int Check(Model_Customer cus) {
		String sql = "SELECT * FROM customers WHERE id_customer = '"+cus.getId_customer()+"'";
		System.out.println(sql);
		
		int sum=0;
		String id = null,
				checked=cus.getId_customer();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getString("id_customer");
			};
			if(id.equals(checked)){
				sum = 1;
			};
		} catch (Exception e) {
		};
		return sum;
	}
    
	public static int Insert(Model_Customer cus) {
		int number = Check(cus);
		if(number == 1){
			JOptionPane.showMessageDialog(null, "ID_Product already exists");
			 return 0;
		}else{
		String sql = "INSERT INTO customers(id_customer, phone_customer, address_customer) "
				+ "   VALUES (?, ?, ?)";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getId_customer());
			ps.setString(2, cus.getPhone_customer());
			ps.setString(3, cus.getAddress_customer());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Customer Added Successfully");
		} catch (Exception e) {
			
		}
	}
		return 0;
}
	
	public static void Delete(Model_Customer cus) {
		String sql = "DELETE FROM customers WHERE id_customer = '"+cus.getId_customer()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public static void Update(Model_Customer cus) {
		String sql = "UPDATE customers SET id_customer=?,phone_customer=?,address_customer=?"
				+     "WHERE id_customer = '"+cus.getId_customer()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getId_customer());
			ps.setString(2, cus.getPhone_customer());
			ps.setString(3, cus.getAddress_customer());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
		} catch (Exception e) {
			
		}
	}
}
