package Model;

public class Model_Employee {
	private String id_employee, name_employee, phone_employee, address_employee;
	private int gender;
	
	public Model_Employee (String id_employee, String name_employee, int gender, String phone_employee, String address_employee) {
		this.id_employee = id_employee;
		this.name_employee = name_employee;
		this.gender = gender;
		this.phone_employee = phone_employee;
		this.address_employee = address_employee;
	}

	public Model_Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getId_employee() {
		return id_employee;
	}

	public void setId_employee(String id_employee) {
		this.id_employee = id_employee;
	}

	public String getName_employee() {
		return name_employee;
	}

	public void setName_employee(String name_employee) {
		this.name_employee = name_employee;
	}
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone_employee() {
		return phone_employee;
	}

	public void setPhone_employee(String phone_employee) {
		this.phone_employee = phone_employee;
	}

	public String getAddress_employee() {
		return address_employee;
	}

	public void setAddress_employee(String address_employee) {
		this.address_employee = address_employee;
	}
	
	@Override
	public String toString() {
		return "Employee [" + id_employee + ", " + name_employee  + ", " + gender + ", " + phone_employee + ", " + address_employee + "]";
	}

}

