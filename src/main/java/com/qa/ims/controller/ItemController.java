package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter Item name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter a price");
		Double price = utils.getDouble();
		Item item = itemDAO.create(new Item(itemsName, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long items_id = utils.getLong();
		LOGGER.info("Please enter item name");
		String itemsName = utils.getString();
		LOGGER.info("Please enter a price");
		Double price = utils.getDouble();
		Item item = itemDAO.update(new Item(items_id, itemsName, price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long items_id = utils.getLong();
		return itemDAO.delete(items_id);
	}


}
