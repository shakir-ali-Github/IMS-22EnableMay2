package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long order_id;
	private Long fk_id;
	
	public Order(Long fk_id) {
		this.setFk_id(fk_id);
	}
	
	public Order(Long order_id, Long fk_id) {
		this.setOrder_Id(order_id);
		this.setFk_id(fk_id);
	}
	
	public Long getOrder_Id() {
		return order_id;
	}
	public void setOrder_Id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getFk_id() {
		return fk_id;
	}
	public void setFk_id(Long fk_id) {
		this.fk_id = fk_id;
	}

	@Override
	public String toString() {
		return "order_id=" + order_id + " fk_id=" + fk_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fk_id, order_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(fk_id, other.fk_id) && Objects.equals(order_id, other.order_id);
	}
	
	

}
