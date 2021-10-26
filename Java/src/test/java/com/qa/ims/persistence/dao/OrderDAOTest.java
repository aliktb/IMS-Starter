package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

  private final OrderItemDAO orderItemDAO = new OrderItemDAO();
  private final OrderDAO orderDAO = new OrderDAO();

  @Before
  public void setup() {
    DBUtils.connect();
    DBUtils.getInstance().init("src/test/resources/sql-schema.sql",
        "src/test/resources/sql-data.sql");
  }

  @Test
  public void testCreate() {

    Order newOrder = new Order(1L, 1L, 10.0);
    assertEquals(newOrder, orderDAO.create(newOrder));
  }

  @Test
  public void testReadLatest() {

    assertEquals(new Order(2L, 1L, 1d), orderDAO.readLatest());

  }

  @Test
  public void testRead() {

    final Long ID = 1L;
    assertEquals(new Order(ID, 1L, 1.5d), orderDAO.read(ID));

  }

  @Test
  public void TestReadAll() {

    List<Order> expected = new ArrayList<>();
    expected.add(new Order(2L, 1L, 1D));
    assertEquals(expected, orderDAO.readAll());

  }

  @Test
  public void testUpdate() {

    final Order updated = new Order(2L, 1L, 2D);
    assertEquals(updated, orderDAO.update(updated));
  }

  @Test
  public void testUpdateCatch() {

    final Order updated = new Order(1L, 1L, 2D);
    assertEquals(updated, orderDAO.update(updated));
  }

  @Test
  public void testDelete() {

    final int ID = 1;
    assertEquals(ID, orderDAO.delete(ID));

  }

  @Test
  public void testDeleteCatch() {

    final int ID = -1;
    assertEquals(0, orderDAO.delete(ID));

  }

}
