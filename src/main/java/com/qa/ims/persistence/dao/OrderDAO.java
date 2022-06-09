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

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	public static final Logger LOGGER = LogManager.getLogger();



	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
	Long order_id = resultSet.getLong("order_id");
	Long fk_id = resultSet.getLong("fk_id");
	return new Order(order_id, fk_id);
	}

	/**
	* Reads all orders from the database
	*
	* @return A list of orders
	*/
	@Override
	public List<Order> readAll() {
	try (Connection connection = DBUtils.getInstance().getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
	List<Order> order = new ArrayList<>();
	while (resultSet.next()) {
	order.add(modelFromResultSet(resultSet));
	}
	return order;
	} catch (SQLException e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return new ArrayList<>();
	}

	public Order readLatest() {
	try (Connection connection = DBUtils.getInstance().getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
	resultSet.next();
	return modelFromResultSet(resultSet);
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	/**
	* Creates an order in the database
	*
	* @param order - takes in an order object. OrderId will be ignored
	*/
	@Override
	public Order create(Order order) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(fk_id) VALUE (?)");) {
	statement.setLong(1, order.getFk_id());
	statement.executeUpdate();
	return readLatest();
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	@Override
	public Order read(Long order_id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
	statement.setLong(1, order_id);
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
	* Updates an order in the database
	*
	* @param order - takes in an order object, the orderId field will be used to
	* update that order in the database
	* @return
	*/
	@Override
	public Order update(Order order) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection
	.prepareStatement("UPDATE orders SET fk_id = ? WHERE order_id = ?");) {
	statement.setLong(1, order.getFk_id());
	statement.setLong(2, order.getOrder_Id());
	statement.executeUpdate();
	return read(order.getOrder_Id());
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return null;
	}

	/**
	* Deletes an order in the database
	*
	* @param orderId - id of the order
	*/
	@Override
	public int delete(long order_id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
	PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
	statement.setLong(1, order_id);
	return statement.executeUpdate();
	} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
	}
	return 0;
	}

}