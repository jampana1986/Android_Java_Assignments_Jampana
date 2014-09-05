package com.androidassignment.model;

public class ProductModel {
	private int _id;
	private String _productname;
	private int _rating;

	public ProductModel() {
		
	}
	
	public ProductModel(int id, String productname, int quantity) {
		this._id = id;
		this._productname = productname;
		this._rating = quantity;
	}
	
	public ProductModel(String productname, int quantity) {
		this._productname = productname;
		this._rating = quantity;
	}
	
	public void setID(int id) {
		this._id = id;
	}
	
	public int getID() {
		return this._id;
	}
	
	public void setProductName(String productname) {
		this._productname = productname;
	}
	
	public String getProductName() {
		return this._productname;
	}
	
	public void setQuantity(int quantity) {
		this._rating = quantity;
	}
	
	public int getQuantity() {
		return this._rating;
	}
}
