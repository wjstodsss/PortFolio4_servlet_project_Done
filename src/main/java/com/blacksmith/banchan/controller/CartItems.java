package com.blacksmith.banchan.controller;

import java.util.Map;

public class CartItems {
    private Map<Integer, Item> items;

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }

    public static class Item {
        private int id;
        private String imageUrl;
        private String productName;
        private int quantity;
        private double price;
		public int getId() {
			return id;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public String getProductName() {
			return productName;
		}
		public int getQuantity() {
			return quantity;
		}
		public double getPrice() {
			return price;
		}
		
		@Override
		public String toString() {
			return "Item [id=" + id + ", imageUrl=" + imageUrl + ", productName=" + productName + ", quantity="
					+ quantity + ", price=" + price + "]";
		}

        // getter와 setter 메서드
    }
}
