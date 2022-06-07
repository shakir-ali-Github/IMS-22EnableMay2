package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long items_id;
	private String itemsName;
	private double price;
	
	public Item(String itemsName, double price) {
		this.setItemsName(itemsName);
		this.setPrice(price);
	}
	
	public Item(Long items_id, String itemsName, double price) {
		this.setItems_id(items_id);
		this.setItemsName(itemsName);
		this.setPrice(price);
	}
	
	public Long getItems_id() {
		return items_id;
	}
	public void setItems_id(Long items_id) {
		this.items_id = items_id;
	}
	public String getItemsName() {
		return itemsName;
	}
	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item ID:" + items_id + " item name =" + itemsName + " price =" + price ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemsName, items_id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemsName, other.itemsName) && Objects.equals(items_id, other.items_id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
	

}
