package Model;

public class Model_Login {
String user_name, password, id_employee;
	
	public Model_Login (String user_name, String password, String id_employee) {
		this.user_name = user_name;
		this.password = password;
		this.id_employee = id_employee;

	}

	public Model_Login() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_employee() {
		return id_employee;
	}

	public void setId_employee(String id_employee) {
		this.id_employee = id_employee;
	}


	
	@Override 
	public String toString () {
		return "Account [" + user_name + ", " + password + "," + id_employee +"]";
	}


}
