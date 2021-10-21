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
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

  public static final Logger LOGGER = LogManager.getLogger();


  // RESULTSET METHOD

  @Override
  public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
    Long id = resultSet.getLong("id");
    String itemName = resultSet.getString("item_name");
    Long itemValue = resultSet.getLong("item_value");
    return new Item(id, itemName, itemValue);
  }

  // READALL

  @Override
  public List<Item> readAll() {

    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
      List<Item> items = new ArrayList<>();
      while (resultSet.next()) {
        items.add(modelFromResultSet(resultSet));
      }
      return items;
    } catch (SQLException e) {

      LOGGER.debug(e);
      LOGGER.error(e.getMessage());

    }
    return new ArrayList<>();
  }


  // READ

  @Override
  public Item read(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  // READ LATEST

  public Item readLatest() {
    try (Connection connection = DBUtils.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet =
            statement.executeQuery("SELECT * FROM customers ORDER BY id DESC LIMIT 1");) {
      resultSet.next();
      return modelFromResultSet(resultSet);
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;
  }


  // CREATE

  @Override
  public Item create(Item t) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection
            .prepareStatement("INSERT INTO items(item_name, item_value) VALUES (?, ?)");) {
      statement.setString(1, t.getItemName());
      statement.setLong(2, t.getItemValue());
      statement.executeUpdate();
      return readLatest();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;

  }

  // UPDATE

  @Override
  public Item update(Item t) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection
            .prepareStatement("UPDATE customers SET item_name = ?, item_value = ? WHERE id = ?");) {
      statement.setString(1, t.getItemName());
      statement.setLong(2, t.getItemValue());
      statement.setLong(3, t.getId());
      statement.executeUpdate();
      return read(t.getId());
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return null;
  }

  // DELETE

  @Override
  public int delete(long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement =
            connection.prepareStatement("DELETE FROM items WHERE id = ?");) {
      statement.setLong(1, id);
      return statement.executeUpdate();
    } catch (Exception e) {
      LOGGER.debug(e);
      LOGGER.error(e.getMessage());
    }
    return 0;
  }



}
