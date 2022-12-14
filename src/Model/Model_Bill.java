package Model;

import java.text.SimpleDateFormat;
import java.sql.Date;

	public class Model_Bill {
		String id_bill, id_product, id_employee, id_customer;
		int quantity;
		double discount, total;
		Date date;
		double price;		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Model_Bill (String id_bill, Date date, String id_product, String id_employee, String id_customer, int quantity, double discount, double total) {
			this.id_bill = id_bill;
			this.date = date;
			this.id_product = id_product;
			this.id_employee = id_employee;
			this.id_customer = id_customer;
			this.quantity = quantity;
			this.discount = discount;
			this.total = total;
		}

		public Model_Bill() {
			// TODO Auto-generated constructor stub
		}

		public String getId_bill() {
			return id_bill;
		}

		public void setId_bill(String id_bill) {
			this.id_bill = id_bill;
		}

		public Date getDate() {
			return date;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getId_product() {
			return id_product;
		}

		public void setId_product(String id_product) {			
			this.id_product = id_product;
		}

		public String getId_employee() {
			return id_employee;
		}

		public void setId_employee(String id_employee) {
			this.id_employee = id_employee;
		}

		public String getId_customer() {
			return id_customer;
		}

		public void setId_customer(String id_customer) {
			this.id_customer = id_customer;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotal() {
			// số lượng * giá *( (100 - giamgr gia) / 100)
			//khúc ( (100 - giamgr gia) / 100) ni là kiểu 99 % 100% á //...
			//à hiểu roài
			//then kiuf
 			return getQuantity()*getPrice() * (100-getDiscount()) / 100d;
		}

		public void setTotal(double total) {
			this.total = total;
		}
		
		@Override
		public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			return "Bill [" + id_bill + ", " + sdf.format(date) + ", " + id_product + ", " + id_employee + ", "
		            + id_customer + ", " + quantity + ", " + ", " + discount + total + "]";
		}

	}



