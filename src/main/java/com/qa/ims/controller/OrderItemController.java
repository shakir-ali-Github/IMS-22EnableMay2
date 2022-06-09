package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderitemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderitemDAO, Utils utils) {
		super();
		this.orderitemDAO = orderitemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all order items to the logger
	 */
	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orders_items = orderitemDAO.readAll();
		for (OrderItem orderitem : orders_items) {
			LOGGER.info(orderitem);
		}
		return orders_items;
	}

	/**
	 * Creates a order item by taking in user input
	 */
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter the order id");
		Long fk_order_id = utils.getLong();
		LOGGER.info("Please enter a item id");
		Long fk_itemsid = utils.getLong();
		LOGGER.info("Please enter the quantity you want");
		Long quantity = utils.getLong();
		OrderItem orderitem = orderitemDAO.create(new OrderItem(fk_order_id, fk_itemsid, quantity));
		LOGGER.info("Order Item created");
		return orderitem;
	}

	/**
	 * Updates an existing order item by taking in user input
	 */
	@Override
	public OrderItem update() {
		LOGGER.info("Order Item cannot be updated");
		return null;
	}

	/**
	 * Deletes an existing order item by the id of the order item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order item you would like to delete");
		Long order_itemsID = utils.getLong();
		return orderitemDAO.delete(order_itemsID);
	}

}
