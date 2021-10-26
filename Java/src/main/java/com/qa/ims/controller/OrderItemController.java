package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {



  public static final Logger LOGGER = LogManager.getLogger();

  private OrderItemDAO orderItemDAO;
  private Utils utils;


  public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {

    super();
    this.orderItemDAO = orderItemDAO;
    this.utils = utils;

  }

  public List<OrderItem> readAll() {
    List<OrderItem> orderItems = orderItemDAO.readAll();
    for (OrderItem orderItem : orderItems) {
      LOGGER.info(orderItem);
    }
    return orderItems;
  }

  public OrderItem create() {


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

    OrderItem orderItem = orderItemDAO.create(new OrderItem(orderId, customerId, itemId));
    LOGGER.info("Item added. Would you like to add another item?  [yes][no]");
    String response = utils.getString().toLowerCase();

    if (response.equals("yes") || response.equals("y")) {
      addToOrder(orderId, customerId);
    } else if (response.equals("no") || response.equals("n")) {
      LOGGER.info("All items added.");
      return orderItem;
    } else {
      LOGGER.info("No more items have been added");
    }

    return orderItem;
  }

  public OrderItem addToOrder(Long orderId, Long customerId) {

    LOGGER.info("Please enter an item id");
    Long itemId = utils.getLong();
    OrderItem orderItem = orderItemDAO.create(new OrderItem(orderId, customerId, itemId));

    LOGGER.info("Item added. Would you like to add another item?  [yes][no]");
    String response = utils.getString().toLowerCase();

    if (response.equals("yes") || response.equals("y")) {
      addToOrder(orderId, customerId);
    } else if (response.equals("no") || response.equals("n")) {
      LOGGER.info("All items added.");
      return orderItem;
    } else {
      LOGGER.info("No more items have been added");
    }

    return orderItem;

  }

  public OrderItem update(Long orderId) {
    Long customerId = 1L;
    Long orderItemsId = 1L;
    Long itemId = 1L;
    OrderItem orderItem =
        orderItemDAO.update(new OrderItem(orderItemsId, customerId, orderId, itemId));
    LOGGER.info("Item Updated");
    return orderItem;

  }

  public int delete() {
    LOGGER.info("Please enter the id of the order_item you would like to delete");
    Long id = utils.getLong();
    return orderItemDAO.delete(id);
  }

  @Override
  public OrderItem update() {
    // TODO Auto-generated method stub
    return null;
  }
}
