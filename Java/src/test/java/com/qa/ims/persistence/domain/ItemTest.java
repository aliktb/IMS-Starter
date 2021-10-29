package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemTest {

  @Test
  public void testSetId() {

    // Assign
    Long id = 2L;
    String itemName = "Pear";
    Double itemValue = 3.0;

    // Act
    Item newItem = new Item(itemName, itemValue);
    newItem.setId(id);

    // Assert
    assertEquals(id, newItem.getId());

  }

  @Test
  public void testSetItemName() {

    // Assign

    String itemName = "Pear";
    String newItemName = "Kiwi";
    Double itemValue = 3.0;

    // Act
    Item newItem = new Item(itemName, itemValue);
    newItem.setItemName(newItemName);

    // Assert
    assertEquals(newItemName, newItem.getItemName());


  }

  @Test
  public void testSetItemValue() {

    // Assign

    String itemName = "Pear";
    Double itemValue = 3.0;
    Double newItemValue = 2.0;

    // Act
    Item newItem = new Item(itemName, itemValue);
    newItem.setItemValue(newItemValue);

    // Assert
    assertEquals(newItemValue, newItem.getItemValue());


  }



}

