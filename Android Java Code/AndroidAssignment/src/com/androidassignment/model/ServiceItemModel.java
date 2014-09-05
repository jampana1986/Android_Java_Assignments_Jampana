package com.androidassignment.model;

public class ServiceItemModel {
	public int imageId;
		public String product;
		
		public ServiceItemModel(int imageId, String product) {
	        this.imageId = imageId;
	        this.product = product;
	    }
		private int getImageId() {
			return imageId;
		}
		private void setImageId(int imageId) {
			this.imageId = imageId;
		}
		
		
	    private String getProduct() {
			return product;
		}
		private void setProduct(String product) {
			this.product = product;
		}
	
}
