package com.model;

public class Menu {
	private String product_ID,productName;
	private long price;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setters Method 
	public String getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
