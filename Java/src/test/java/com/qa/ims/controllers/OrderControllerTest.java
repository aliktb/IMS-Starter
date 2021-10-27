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
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

  @Mock
  private Utils utils;

  @Mock
  OrderDAO orderDAO;

  @Mock
  OrderItemDAO orderItemDAO;

  @InjectMocks
  private OrderController controller;

  @Test
  public void testCreate() {

    final Long CUSTOMER_ID = 1L;
    final Long ITEM_ID = 1L;
    final Double TOTAL_ORDER_COST = 1D;
    final Long ORDER_ID = 1L;
    final Order created = new Order(ORDER_ID, CUSTOMER_ID, TOTAL_ORDER_COST);


    Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, ITEM_ID);
    Mockito.when(orderDAO.create(created)).thenReturn(created);
    Mockito.when(utils.getString()).thenReturn("no");

    assertEquals(created, controller.create());

    Mockito.verify(utils, Mockito.times(2)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();


  }


  @Test
  public void testAddToOrder() {

    final Long CUSTOMER_ID = 1L;
    final Long ITEM_ID = 1L;
    final Double TOTAL_ORDER_COST = 1D;
    final Long ORDER_ID = 2L;
    final Order updated = new Order(ORDER_ID, CUSTOMER_ID, TOTAL_ORDER_COST);

    Mockito.when(utils.getLong()).thenReturn(ITEM_ID);
    Mockito.when(utils.getString()).thenReturn("no");


    assertEquals(updated, controller.addToOrder(ORDER_ID, CUSTOMER_ID));

    Mockito.verify(utils, Mockito.times(1)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();

  }


  @Test
  public void testRemoveFromOrder() {

    final Long ITEM_ID = 1L;
    final Long ORDER_ID = 2L;
    final Long CUSTOMER_ID = 1L;
    final Double TOTAL_ORDER_COST = 1D;
    final Order updated = new Order(ORDER_ID, CUSTOMER_ID, TOTAL_ORDER_COST);

    Mockito.when(utils.getLong()).thenReturn(ITEM_ID);
    Mockito.when(utils.getString()).thenReturn("no");
    Mockito.when(orderDAO.create(updated)).thenReturn(updated);

    assertEquals(updated, this.controller.removeFromOrder(ORDER_ID, CUSTOMER_ID));

    Mockito.verify(utils, Mockito.times(1)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();

  }

  @Test
  public void testReadAll() {

    List<Order> orders = new ArrayList<>();
    orders.add(new Order(1L, 1L, 2D));

    Mockito.when(orderDAO.readAll()).thenReturn(orders);

    assertEquals(orders, controller.readAll());

    Mockito.verify(orderDAO, Mockito.times(1)).readAll();

  }

  @Test
  public void testDelete() {

    final Long ORDER_ID = 1L;

    Mockito.when(utils.getLong()).thenReturn(ORDER_ID);
    Mockito.when(orderItemDAO.delete(ORDER_ID)).thenReturn(1);

    assertEquals(1, this.controller.delete());

    Mockito.verify(utils, Mockito.times(1)).getLong();


  }

  @Test
  public void testUpdateAdd() {

    final Long ORDER_ID = 1L;
    final Long CUSTOMER_ID = 1L;


    Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, ORDER_ID);
    Mockito.when(utils.getString()).thenReturn("add");

    assertEquals(null, this.controller.update());

    Mockito.verify(utils, Mockito.times(2)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();


  }

  @Test
  public void testUpdateA() {

    final Long ORDER_ID = 1L;
    final Long CUSTOMER_ID = 1L;


    Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, ORDER_ID);
    Mockito.when(utils.getString()).thenReturn("a");

    assertEquals(null, this.controller.update());

    Mockito.verify(utils, Mockito.times(2)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();


  }

  @Test
  public void testUpdateRemove() {

    final Long ORDER_ID = 1L;
    final Long CUSTOMER_ID = 1L;


    Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, ORDER_ID);
    Mockito.when(utils.getString()).thenReturn("remove");

    assertEquals(null, this.controller.update());

    Mockito.verify(utils, Mockito.times(2)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();


  }

  @Test
  public void testUpdateRemoveR() {

    final Long ORDER_ID = 1L;
    final Long CUSTOMER_ID = 1L;


    Mockito.when(utils.getLong()).thenReturn(CUSTOMER_ID, ORDER_ID);
    Mockito.when(utils.getString()).thenReturn("r");

    assertEquals(null, this.controller.update());

    Mockito.verify(utils, Mockito.times(2)).getLong();
    Mockito.verify(utils, Mockito.times(1)).getString();


  }

}
