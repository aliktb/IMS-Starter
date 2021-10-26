package com.qa.ims.controllers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

  @Mock
  private Utils utils;

  @Mock
  OrderDAO dao;

  @InjectMocks
  private OrderController controller;

  // @Test
  // public void testCreate() {
  //
  // final Long CUSTOMER_ID = 1L;
  // final Long ITEM_ID = 1L;
  // final Order created = new Order(CUSTOMER_ID, ITEM_ID.);
  //
  // }
}
