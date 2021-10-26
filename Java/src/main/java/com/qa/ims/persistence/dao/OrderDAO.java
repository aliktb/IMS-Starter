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
  public List<Order> readAll() {
    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
      List<Order> orders = new ArrayList<>();
      while (resultSet.next()) {
        orders.add(modelFromResultSet(resultSet));
      }
      return orders;
    } catch (

    SQLException e) {
      return new ArrayList<>();
    }

  }

  @Override
  public Order read(Long id) {
    // TODO Auto-generated method stub
    return null;
  }


  public Order readLatest() {



    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet =
            statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
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
  public Order create(Order t) {


    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(

            "INSERT INTO orders SELECT order_id, customer_id, SUM(item_value) AS total_order_cost  FROM order_items AS oi INNER JOIN items AS it ON oi.item_id=it.id WHERE order_id = ? group by order_id;");) {

      statement.setLong(1, t.getOrderId());
      statement.executeUpdate();
      return readLatest();

    } catch (Exception e) {


    }



    return null;
  }

  @Override
  public Order update(Order t) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection
            .prepareStatement("UPDATE order SET order_total_cost = ? WHERE order_id = ?");) {
      statement.setLong(1, t.getCustomerId());
      statement.setLong(4, t.getOrderId());
      statement.executeUpdate();
      return read(t.getOrderId());
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;
  }

  @Override
  public int delete(long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement =
            connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
      statement.setLong(1, id);
      return statement.executeUpdate();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return 0;
  }

  @Override
  public Order modelFromResultSet(ResultSet resultSet) throws SQLException {

    Long orderId = resultSet.getLong("order_id");
    Long customerId = resultSet.getLong("customer_id");
    Double totalOrderCost = resultSet.getDouble("total_order_cost");

    return new Order(orderId, customerId, totalOrderCost);
  }


}
