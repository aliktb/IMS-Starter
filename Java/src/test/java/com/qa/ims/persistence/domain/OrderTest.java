package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OrderTest {

  @Test
  public void testGetOrderId() {

    // Assign
    Long orderId = 1L;
    Long customerId = 1L;
    Double totalOrderCost = 1D;

    // Act
    Order newOrder = new Order(orderId, customerId, totalOrderCost);

    // Assert
    assertEquals(orderId, newOrder.getOrderId());

  }

  @Test
  public void testSetOrderId() {

    // Assign
    Long orderId = 1L;
    Long newOrderId = 2L;
    Long customerId = 1L;
    Double totalOrderCost = 1D;

    // Act
    Order newOrder = new Order(orderId, customerId, totalOrderCost);
    newOrder.setOrderId(newOrderId);

    // Assert
    assertEquals(newOrderId, newOrder.getOrderId());

  }


  @Test
  public void testGetCustomerId() {


    // Assign
    Long orderId = 1L;
    Long customerId = 1L;
    Double totalOrderCost = 1D;

    // Act
    Order newOrder = new Order(orderId, customerId, totalOrderCost);

    // Assert
    assertEquals(customerId, newOrder.getCustomerId());

  }


  @Test
  public void testSetCustomerId() {


    // Assign
    Long orderId = 1L;
    Long customerId = 1L;
    Long newCustomerId = 2L;
    Double totalOrderCost = 1D;

    // Act
    Order newOrder = new Order(orderId, customerId, totalOrderCost);
    newOrder.setCustomerId(newCustomerId);

    // Assert
    assertEquals(orderId, newOrder.getOrderId());
  }

  @Test
  public void testGetTotalOrderCost() {

    // Assign
    Long orderId = 1L;
    Long customerId = 1L;
    Double totalOrderCost = 1D;

    // Act
    Order newOrder = new Order(orderId, customerId, totalOrderCost);

    // Assert
    assertEquals(totalOrderCost, newOrder.getTotalOrderCost());

  }

  @Test
  public void testSetTotalOrderCost() {


    // Assign
    Long orderId = 1L;
    Long customerId = 1L;
    Double totalOrderCost = 1D;
    Double newTotalOrderCost = 1.1D;

    // Act
    Order newOrder = new Order(customerId, totalOrderCost);
    newOrder.setTotalOrderCost(newTotalOrderCost);


    // Assert
    assertEquals(newTotalOrderCost, newOrder.getTotalOrderCost());
  }

}
