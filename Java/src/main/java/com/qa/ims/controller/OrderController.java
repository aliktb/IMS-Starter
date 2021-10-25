package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

  public static final Logger LOGGER = LogManager.getLogger();

  private OrderDAO orderDAO;
  private OrderItemDAO orderItemDAO;
  private Utils utils;


  public OrderController(OrderDAO orderDAO, OrderItemDAO orderItemDAO, Utils utils) {
    super();
    this.orderDAO = orderDAO;
    this.utils = utils;
    this.orderItemDAO = orderItemDAO;
  }


  @Override
  public Order create() {

    LOGGER.info("Please enter the customer id");
    Long customerId = utils.getLong();
    LOGGER.info("Please enter an item id");
    Long itemId = utils.getLong();
    Long orderId;

    try {
      orderId = orderItemDAO.readLatest().getOrderId() + 1;
    } catch (NullPointerException e) {
      orderId = 1L;
    }

    orderItemDAO.create(new OrderItem(orderId, customerId, itemId));
    Order newOrder = orderDAO.create(new Order(orderId, customerId, null));
    LOGGER.info("Item added. Would you like to add another item?  (yes)(no)");
    String response = utils.getString().toLowerCase();



    if (response.equals("yes") || response.equals("y")) {
      addToOrder(orderId, customerId);
    } else if (response.equals("no") || response.equals("n")) {
      LOGGER.info("All items added.");
      return newOrder;
    } else {
      LOGGER.info("No more items have been added");
    }

    return newOrder;

  }



  public Order addToOrder(Long orderId, Long customerId) {

    LOGGER.info("Please enter an item id");
    Long itemId = utils.getLong();
    orderItemDAO.create(new OrderItem(orderId, customerId, itemId));

    // update order entry
    orderDAO.delete(orderId);
    Order newOrder = new Order(orderId, customerId, null);
    orderDAO.create(newOrder);
    LOGGER.info("Item added. Would you like to add another item?  (yes)(no)");
    String response = utils.getString().toLowerCase();

    if (response.equals("yes") || response.equals("y")) {
      addToOrder(orderId, customerId);
    } else if (response.equals("no") || response.equals("n")) {
      LOGGER.info("All items added.");
      return newOrder;
    } else {
      LOGGER.info("No more items have been added");
    }

    return newOrder;

  }


  @Override
  public List<Order> readAll() {
    List<Order> orders = orderDAO.readAll();
    for (Order order : orders) {
      LOGGER.info(order);
    }
    return orders;
  }

  @Override
  public Order update() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete() {
    // TODO Auto-generated method stub
    return 0;
  }



}
