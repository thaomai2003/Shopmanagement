package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Model_Product;

public class Controller_Product {
	private Connection conn;
	private PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement stm = null;
	
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
	public List<Model_Product> findAll() {
		String sql = "SELECT * FROM products";
		List<Model_Product> ProList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model_Product pro = new Model_Product(rs.getString("id_product"),
						                  rs.getString("name_product"),
						                  rs.getString("id_category"),
						                  rs.getDouble("price_product"),
						                  rs.getDouble("discount_product"));
				ProList.add(pro);
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return ProList;
		
	}
	
	public static int Check(Model_Product pro)	{
		String sql= "SELECT * FROM products WHERE id_product = "+pro.getId_product()+"";
		System.out.println(sql);
		
		int sum=0;
		String id = null,
				checked=pro.getId_product();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getString("id_product");
			};
			if(id.equals(checked)){
				sum = 1;
			};
		} catch (Exception e) {
		};
		return sum;
	}
	public static int Insert(Model_Product pro) {
		int number = Check(pro);
		if(number == 1){
			JOptionPane.showMessageDialog(null, "ID_Product already exists");
			 return 0;
		}else{
			String sql = "INSERT INTO products(id_product, name_product, id_category, price_product, discount_product) "
					+ "VALUES (?, ?, ?, ?, ?)";
				 try {
					Connection conn = getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, pro.getId_product());
					ps.setString(2, pro.getName_product());
					ps.setString(3, pro.getCategory());
					ps.setDouble(4, pro.getPrice());
					ps.setDouble(5, pro.getDiscount());
					ps.execute();
					JOptionPane.showMessageDialog(null, "Product Added Successfully");
				}catch (Exception e) {	
				} 
			} 
		 return 0;
	}
		
	public static void Delete(Model_Product pro)	{
		String sql = "DELETE FROM products WHERE id_product = "+pro.getId_product()+"";
		System.out.println(sql);
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();			
		} catch (Exception e) {
			
		}
	}
	
	public static void Update(Model_Product pro) {
		String sql = "UPDATE products SET id_product=?,name_product=?,id_category=?,price_product=?,discount_product=?"
				+ "   WHERE id_product = '"+pro.getId_product()+"'";
		System.out.println(sql);
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getId_product());
			ps.setString(2, pro.getName_product());
			ps.setString(3, pro.getCategory());
			ps.setDouble(4, pro.getPrice());
			ps.setDouble(5, pro.getDiscount());
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public static  List<Model_Product>FindByID(Model_Product product) {
		String sql = "SELECT * FROM products WHERE products.id_product = '"+product.getId_product()+"' ";
		System.out.println(sql);
		List<Model_Product> ProductList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Model_Product pro = new Model_Product(rs.getString("id_product"),
						                rs.getString("name_product"),
		                                rs.getString("id_category"),
		                                rs.getDouble("price_product"),
		                                rs.getDouble("discount_product"));
				ProductList.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProductList;
		
	}
	

}
