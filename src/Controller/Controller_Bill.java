package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Model_Bill;
import Model.Model_Product;

public class Controller_Bill {
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
	
public List<Model_Bill> findAll() {
	String sql = "SELECT * FROM detail_bills inner join products on detail_bills.id_product = products.id_product";
	List<Model_Bill> BillList = new ArrayList<>();
	try {
		Connection conn = getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Model_Bill bill = new Model_Bill(rs.getString("id_bill"),
					               rs.getDate("date_bill"),
					               rs.getString("id_product"),
					               rs.getString("id_employee"),
					               rs.getString("id_customer"),
					               rs.getInt("quantity_product"),
					               rs.getDouble("discount_bill"),
					               rs.getDouble("total_bill"));
			bill.setPrice(rs.getDouble("price_product"));
			// đây thì mỗi lần lấy dữ liệu về thì lấy luôn cái price bên bảng product
			BillList.add(bill);
		   }
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return BillList;
}

public static int Check(Model_Bill bill)	{
	String sql= "SELECT * FROM detail_bills WHERE id_bill = '"+bill.getId_bill()+"'";
	System.out.println(sql);
	int sum=0;
	String id = null,
			checked=bill.getId_bill();
	try {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			return 1;
		};
	} catch (Exception e) {
	};
	return sum;
}

public static int Insert(Model_Bill bill) {
	int number = Check(bill);
	System.out.println(number);
	if(number == 1){
		JOptionPane.showMessageDialog(null, "ID_Bill already exists");
		 return 0;
	}else{
	String sql = "INSERT INTO detail_bills(id_bill, date_bill, id_product, id_employee, id_customer, quantity_product, discount_bill, total_bill) "
			     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	try {
		System.out.println(sql);
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bill.getId_bill());		
		ps.setString(3, bill.getId_product());
		ps.setString(4, bill.getId_employee());
		ps.setString(5, bill.getId_customer());
		ps.setInt(6, bill.getQuantity());
		ps.setDouble(7, bill.getDiscount());
		ps.setDouble(8, bill.getTotal());
		Date d = new Date(bill.getDate().getTime());// 2 cái date khác nhau ko cast đc cái này là chuyển từ java util Date thành sql date
		ps.setDate(2,  d);
		ps.execute();
		JOptionPane.showMessageDialog(null, "Bill Added Successfully");
		return 1;// đây :v thêm được là nó return 1
	} catch(Exception e) {
		System.out.println(e);
	}
	}
	return 0;

}

public static void Delete(Model_Bill bill) {
	String sql = "DELETE FROM detail_bills WHERE id_bill = '"+bill.getId_bill()+"'";
	System.out.println(sql);
	try {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public static void Update(Model_Bill bill) {
	String sql = "UPDATE detail_bills SET id_bill=?,date_bill=?,id_product=?,id_employee=?,id_customer=?,quantity_product=?,discount_bill=?,total_bill=? "
			+ "WHERE id_bill = '"+bill.getId_bill()+"'";
	try {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bill.getId_bill());
		ps.setDate(2, (Date) bill.getDate());
		ps.setString(3, bill.getId_product());
		ps.setString(4, bill.getId_employee());
		ps.setString(5, bill.getId_customer());
		ps.setInt(6, bill.getQuantity());
		ps.setDouble(7, bill.getDiscount());
		ps.setDouble(8, bill.getTotal());
		ps.executeUpdate();
	}catch (Exception e) {
		
	}
}
	
	public static List<Model_Bill>FindByID(Model_Bill b) {
		String sql = "SELECT * FROM detail_bills WHERE id_bill = '"+b.getId_bill()+"'";
		System.out.println(sql);
		List<Model_Bill> BillList = new ArrayList<>();
		try {
			Connection conn = getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Model_Bill bill = new Model_Bill(rs.getString("id_bill"), rs.getDate("date_bill"), rs.getString("id_product"), rs.getString("id_employee"),
						               rs.getString("id_customer"), rs.getInt("quantity_product"), rs.getDouble("discount_bill"), rs.getDouble("total_bill"));
				BillList.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BillList;
	
}

}
