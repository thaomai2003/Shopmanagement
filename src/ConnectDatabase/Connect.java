package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection getConnection() {
		Connection conn = null;
		try{ 
			   String userName = "root";
			   String password = "";
			   String url = "jdbc:mysql://localhost/meimeishopmanagement";
			   Class.forName ("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "";
			   String url = "jdbc:mysql://localhost/meimeishopmanagement";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   
			   conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Ok");
		} catch(Exception e){
			   e.printStackTrace();
		}
		
	}
}	

