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

public class OrderItemDAO implements Dao<OrderItem> {

  public static final Logger LOGGER = LogManager.getLogger();

  @Override
  public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {

    Long orderItemsId = resultSet.getLong("order_items_id");
    Long orderId = resultSet.getLong("order_id");
    Long customerId = resultSet.getLong("customer_id");
    Long itemId = resultSet.getLong("item_id");
    return new OrderItem(orderItemsId, orderId, customerId, itemId);

  }

  @Override
  public List<OrderItem> readAll() {
    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
      List<OrderItem> orderItems = new ArrayList<>();
      while (resultSet.next()) {
        orderItems.add(modelFromResultSet(resultSet));
      }
      return orderItems;
    } catch (SQLException e) {

      LOGGER.debug(e);
      LOGGER.error(e.getMessage());

    }
    return new ArrayList<>();
  }

  @Override
  public OrderItem read(Long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement =
            connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
      statement.setLong(1, id);
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


  public List<OrderItem> readFromOrder(Long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement =
            connection.prepareStatement("SELECT * FROM order_items WHERE order_id = ?");) {
      statement.setLong(1, id);
      try (ResultSet resultSet = statement.executeQuery();) {
        List<OrderItem> orderItems = new ArrayList<>();
        while (resultSet.next()) {
          orderItems.add(modelFromResultSet(resultSet));
        }
        return orderItems;
      } catch (SQLException e) {

        LOGGER.debug(e);
        LOGGER.error(e.getMessage());

      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return new ArrayList<>();
  }


  @Override
  public OrderItem create(OrderItem t) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO order_items(order_id, customer_id, item_id) VALUES (?, ?, ?)");) {
      statement.setLong(1, t.getOrderId());
      statement.setLong(2, t.getCustomerId());
      statement.setLong(3, t.getItemId());
      statement.executeUpdate();
      return readLatest();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;

  }



  // READ LATEST

  public OrderItem readLatest() {

    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
            .executeQuery("SELECT * FROM order_items ORDER BY order_items_id DESC LIMIT 1");) {
      resultSet.next();
      return modelFromResultSet(resultSet);
    } catch (Exception e) {
      if (e.getMessage().equals("Illegal operation on empty result set.")) {

        LOGGER.info("This is the first order in the store!");

      } else {
        LOGGER.debug(e);
        LOGGER.error(e.getMessage());
      }
    }
    return null;

  }


  @Override
  public OrderItem update(OrderItem t) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE order_items SET order_id = ?, customer_id = ?, item_id = ? WHERE order_items_id = ?");) {
      statement.setLong(1, t.getCustomerId());
      statement.setLong(2, t.getCustomerId());
      statement.setLong(3, t.getItemId());
      statement.setLong(4, t.getOrderItemsId());
      statement.executeUpdate();
      return read(t.getOrderItemsId());
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;
  }



  public int deleteOneEntry(Long order_id, Long item_id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "DELETE FROM order_items WHERE order_id = ? AND item_id = ? LIMIT 1");) {
      statement.setLong(1, order_id);
      statement.setLong(2, item_id);
      return statement.executeUpdate();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return 0;
  }

  @Override
  public int delete(long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement =
            connection.prepareStatement("DELETE FROM order_items WHERE order_id = ?");) {
      statement.setLong(1, id);
      return statement.executeUpdate();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return 0;
  }



}
