package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderItemDAO dao;

	@InjectMocks
	private OrderItemController controller;

	@Test
	public void testCreate() {
		final Long FO = (long) 2, FI = (long) 2, Q = (long) 5;
		final OrderItem created = new OrderItem(FO, FI, Q);

		Mockito.when(utils.getLong()).thenReturn(FO, FI, Q);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderItem> orderitems = new ArrayList<>();
		orderitems.add(new OrderItem(1L, 1L, 1L, 5L));

		Mockito.when(dao.readAll()).thenReturn(orderitems);

		assertEquals(orderitems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItem updated = new OrderItem(1L, 1L, 1L, 1L);

		assertEquals(null, this.controller.update());

	}

	@Test
	public void testDelete() {
		final long order_itemsID = 1L;

		Mockito.when(utils.getLong()).thenReturn(order_itemsID);
		Mockito.when(dao.delete(order_itemsID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(order_itemsID);
	}


}
