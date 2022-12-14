package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Model_Login;

public class Controller_Register {
	
	private Connection conn;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
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
	
	public List<Model_Login> findAll() {
		String sql = "SELECT * FROM login";
		List<Model_Login> LogList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model_Login log = new Model_Login(rs.getString("user_name"),
						                  rs.getString("password"),
						                  rs.getString("id_employee"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return LogList;
		
	}
	
	public static void Insert(Model_Login log) {
		String sql = "INSERT INTO login(user_name, password, id_employee) "
				+ "VALUES (?, ?, ?)";
		try {
			Connection conn = getConnection();
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, log.getUser_name());
			ps.setString(2, log.getPassword());
			ps.setString(3, log.getId_employee());
			ps.execute();
		}catch (Exception e) {
			
		}
	}

	public static void Delete(Model_Login log) {
		String sql = "DELETE FROM login WHERE user_name = '"+log.getUser_name()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	public static void Update(Model_Login log) {
		String sql = "UPDATE login SET user_name=?,password=?,id_employee=?"
				+ "   WHERE user_name = '"+log.getUser_name()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, log.getUser_name());
			ps.setString(2, log.getPassword());
			ps.setString(3, log.getId_employee());
			ps.executeUpdate();
		}catch (Exception e) {
			
		}
	}

}
