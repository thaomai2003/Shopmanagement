package Model;

public class Model_Product {
	String id_product, name_product, category;
	double discount;
	double price;
	public Model_Product() {};
	public Model_Product (String id_product, String name_product, String category, double price, double discount ) {
		this.id_product = id_product;
		this.name_product = name_product;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return "Product [" + ", " + id_product + ", " + name_product + ", " + category + ", " + price + ", " + discount + "]";
	}

}
