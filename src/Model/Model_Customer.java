package Model;

public class Model_Customer {
String id_customer, phone_customer, address_customer;
	
	public Model_Customer (String id_customer, String phone_customer, String address_customer) {
		this.id_customer = id_customer;
		this.phone_customer = phone_customer;
		this.address_customer = address_customer;
	}

	public Model_Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getId_customer() {
		return id_customer;
	}

	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}

	public String getPhone_customer() {
		return phone_customer;
	}

	public void setPhone_customer(String phone_customer) {
		this.phone_customer = phone_customer;
	}

	public String getAddress_customer() {
		return address_customer;
	}

	public void setAddress_customer(String address_customer) {
		this.address_customer = address_customer;
	}
	
	@Override
	public String toString() {
		return "Customer [" + id_customer + ", " + phone_customer + ", " +  address_customer + "]";
	}


}
