package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

  private final ItemDAO DAO = new ItemDAO();

  @Before
  public void setup() {
    DBUtils.connect();
    DBUtils.getInstance().init("src/test/resources/sql-schema.sql",
        "src/test/resources/sql-data.sql");
  }

  @Test
  public void testCreate() {
    final Item created = new Item(2L, "orange", 3d);
    assertEquals(created, DAO.create(created));
  }

  @Test
  public void testReadAll() {
    List<Item> expected = new ArrayList<>();
    expected.add(new Item(1L, "apple", 8.4d));
    assertEquals(expected, DAO.readAll());
  }

  @Test
  public void testReadLatest() {
    Item newItem = new Item(1L, "apple", 8.4D);
    assertEquals(newItem, DAO.readLatest());
  }

  @Test
  public void testRead() {
    final long ID = 1L;
    assertEquals(new Item(ID, "apple", 8.4D), DAO.read(ID));
  }

  @Test
  public void testUpdate() {
    final Item updated = new Item(1L, "Banana", 4d);
    assertEquals(updated, DAO.update(updated));

  }

  @Test
  public void testDelete() {
    assertEquals(1, DAO.delete(1));
  }
}
