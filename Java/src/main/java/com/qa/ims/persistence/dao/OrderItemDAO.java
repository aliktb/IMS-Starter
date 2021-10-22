package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OrderItem read(Long id) {
    // TODO Auto-generated method stub
    return null;
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
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;

  }


  @Override
  public OrderItem update(OrderItem t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int delete(long id) {
    // TODO Auto-generated method stub
    return 0;
  }

}
