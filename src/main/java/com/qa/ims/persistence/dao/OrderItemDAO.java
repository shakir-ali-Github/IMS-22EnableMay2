package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_itemsID = resultSet.getLong("order_itemsID");
		Long fk_order_id = resultSet.getLong("fk_order_id");
		Long fk_itemsid = resultSet.getLong("fk_itemsid");
		Long quantity = resultSet.getLong("quantity");
		return new OrderItem(order_itemsID, fk_order_id, fk_itemsid, quantity);
	}

	/**
	 * Reads all order items from the database
	 * 
	 * @return A list of order items
	 */
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items");) {
			List<OrderItem> orders_items = new ArrayList<>();
			while (resultSet.next()) {
				orders_items.add(modelFromResultSet(resultSet));
			}
			return orders_items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a order item in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public OrderItem create(OrderItem orders_items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(fk_order_id, fk_itemsid, quantity) VALUE (?, ?, ?)");) {
			statement.setLong(1, orders_items.getFk_order_id());
			statement.setLong(2, orders_items.getFk_itemsid());
			statement.setLong(3, orders_items.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem read(Long order_itemsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders_items WHERE order_itemsID = ?");) {
			statement.setLong(1, order_itemsID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a order item in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public OrderItem update(OrderItem orders_items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders_items SET fk_order_id = ?, fk_itemsid = ?, quantity = ? WHERE order_itemsID = ?");) {
			statement.setLong(1, orders_items.getFk_order_id());
			statement.setLong(2, orders_items.getFk_itemsid());
			statement.setLong(2, orders_items.getQuantity());
			statement.executeUpdate();
			return read(orders_items.getOrder_itemsID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a order item in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long order_itemsID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE order_itemsID = ?");) {
			statement.setLong(1, order_itemsID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


}
