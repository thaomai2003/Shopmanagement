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

import Model.Model_Employee;

public class Controller_Employee {
	private Connection conn;
	private static Statement stm = null;
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

	public static List<Model_Employee> findAll() {
		String sql = "SELECT * FROM employees";
		List<Model_Employee> EmpList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Model_Employee emp = new Model_Employee(rs.getString("id_employee"),
						                  rs.getString("name_employee"),
						                  rs.getInt("gender"),
						                  rs.getString("phone_employee"),
						                  rs.getString("address_employee"));
				EmpList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmpList;
		
	}
	
	public static int Check(Model_Employee emp) {
		String sql = "SELECT * FROM employees WHERE id_employee = '" + emp.getId_employee()+"'";
		System.out.println(sql);
		
		int sum = 0;
		String id = null, checked = emp.getId_employee();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getString("id_employee");
			};
			if(id.equals(checked)){
				sum = 1;
			};
		} catch (Exception e) {
			
		};
		System.out.println(sum);
		return sum;
	}
	
	public static int Insert(Model_Employee emp) {
		System.out.println(emp);
		int number = Check(emp);
		if(number == 1){
			
			JOptionPane.showMessageDialog(null, "ID_Employee already exists");
			 return 0;
		}else{
		String sql = "INSERT INTO employees(id_employee, name_employee, gender, phone_employee, address_employee) "
				+ "   VALUES (?, ?, ?, ?, ?)";
		try {
			
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getId_employee());
			ps.setString(2, emp.getName_employee());
			ps.setInt(3, emp.getGender());
			ps.setString(4, emp.getPhone_employee());
			ps.setString(5, emp.getAddress_employee());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Employee Added Successfully");
		} catch (Exception e) {			
		}
	}
		return 0;
}
	
	public static void Delete(Model_Employee emp) {
		String sql = "DELETE FROM employees WHERE id_employee = '"+emp.getId_employee()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
		
	public static void Update (Model_Employee emp) {
			String sql = "UPDATE employees SET id_employee=?,name_employee=?,gender=?,phone_employee=?,address_employee=? "
					+ "   WHERE id_employee='"+emp.getId_employee()+"'";
			try {
				Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, emp.getId_employee());
				ps.setString(2, emp.getName_employee());
				ps.setInt(3, emp.getGender());
				ps.setString(4, emp.getPhone_employee());
				ps.setString(5, emp.getAddress_employee());
				ps.executeUpdate();
			}catch (Exception e) {
				
			}
		}

	
	
	public static List<Model_Employee>FindByAll(Model_Employee employee) {
		List<Model_Employee> EmployeeList =  new ArrayList<>();
		String sql = "SELECT * FROM employees WHERE id_employee = '"+employee.getId_employee()+"' OR name_employee LIKE '%"+employee.getName_employee()+"%'";
		try {
			Connection conn = getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Model_Employee emp = new Model_Employee(rs.getString("id_employee"),
						                  rs.getString("name_employee"),
						                  rs.getInt("gender"),
						                  rs.getString("phone_employee"),
						                  rs.getString("address_employee"));
				EmployeeList.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EmployeeList;
		
	}
}

