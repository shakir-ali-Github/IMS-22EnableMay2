package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	
	private Long itemsid;
	private String itemsName;
	private double price;
	
	public Item(String itemsName, double price) {
		this.setItemsName(itemsName);
		this.setPrice(price);
	}
	
	public Item(Long itemsid, String itemsName, double price) {
		this.setItemsid(itemsid);
		this.setItemsName(itemsName);
		this.setPrice(price);
	}
	
	public Long getItemsid() {
		return itemsid;
	}
	public void setItemsid(Long itemsid) {
		this.itemsid = itemsid;
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
		return "item ID:" + itemsid + " item name =" + itemsName + " price =" + price ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemsName, itemsid, price);
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
		return Objects.equals(itemsName, other.itemsName) && Objects.equals(itemsid, other.itemsid)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
	

}
