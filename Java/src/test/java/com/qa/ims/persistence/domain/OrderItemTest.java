package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OrderItemTest {


  @Test
  public void testSetOrderItemsId() {

    // Assign
    Long orderItemsId = 2L;
    Long orderId = 1L;
    Long customerId = 1L;
    Long itemId = 1L;

    // Act
    OrderItem newOrderItem = new OrderItem(1L, orderId, customerId, itemId);
    newOrderItem.setOrderItemsId(orderItemsId);

    // Assert
    assertEquals(orderItemsId, newOrderItem.getOrderItemsId());

  }

  @Test
  public void testSetOrderId() {

    // Assign
    Long orderItemsId = 2L;
    Long customerId = 1L;
    Long itemId = 1L;

    // Act
    OrderItem newOrderItem = new OrderItem(orderItemsId, 2L, customerId, itemId);
    newOrderItem.setOrderId(orderItemsId);

    // Assert
    assertEquals(orderItemsId, newOrderItem.getOrderId());

  }

  @Test
  public void testSetCustomerId() {

    // Assign
    Long orderItemsId = 2L;
    Long orderId = 1L;
    Long customerId = 1L;
    Long itemId = 1L;

    // Act
    OrderItem newOrderItem = new OrderItem(1L, orderId, 2L, itemId);
    newOrderItem.setCustomerId(customerId);

    // Assert
    assertEquals(orderItemsId, newOrderItem.getCustomerId());

  }

  @Test
  public void testsetItemId() {

    // Assign
    Long orderItemsId = 2L;
    Long orderId = 1L;
    Long customerId = 1L;
    Long itemId = 1L;

    // Act
    OrderItem newOrderItem = new OrderItem(1L, orderId, customerId, 2L);
    newOrderItem.setItemId(itemId);
    // Assert
    assertEquals(orderItemsId, newOrderItem.getItemId());

  }

}
