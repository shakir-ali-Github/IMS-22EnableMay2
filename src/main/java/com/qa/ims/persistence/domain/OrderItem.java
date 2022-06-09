package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	
	private Long order_itemsID;
	private Long fk_order_id;
	private Long fk_itemsid;
	private Long quantity;
	
	public OrderItem(Long order_itemsID, Long fk_order_id, Long fk_itemsid, Long quantity) {
		this.setOrder_itemsID(order_itemsID);
		this.setFk_order_id(fk_order_id);
		this.setFk_itemsid(fk_itemsid);
		this.setQuantity(quantity);
	}
	
	public Long getOrder_itemsID() {
		return order_itemsID;
	}
	public void setOrder_itemsID(Long order_itemsID) {
		this.order_itemsID = order_itemsID;
	}
	public Long getFk_order_id() {
		return fk_order_id;
	}
	public void setFk_order_id(Long fk_order_id) {
		this.fk_order_id = fk_order_id;
	}
	public Long getFk_itemsid() {
		return fk_itemsid;
	}
	public void setFk_itemsid(Long fk_itemsid) {
		this.fk_itemsid = fk_itemsid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "order_itemsID=" + order_itemsID + " fk_order_id=" + fk_order_id + " fk_itemsid="
				+ fk_itemsid + " quantity=" + quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_itemsid, fk_order_id, order_itemsID, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(fk_itemsid, other.fk_itemsid) && Objects.equals(fk_order_id, other.fk_order_id)
				&& Objects.equals(order_itemsID, other.order_itemsID) && Objects.equals(quantity, other.quantity);
	}
	
	

}
