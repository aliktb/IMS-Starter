package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

  @Test
  public void testEquals() {
    EqualsVerifier.simple().forClass(Customer.class).verify();
  }



  @Test
  public void testGetId() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(firstName, lastName);

    // Assert
    assertEquals(id, Jordan.getId());

  }

  @Test
  public void testsetId() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(id, firstName, lastName);
    Jordan.setId(2L);

    // Assert
    assertEquals((Long) 2L, Jordan.getId());

  }


  @Test
  public void testGetFirstName() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(id, firstName, lastName);

    // Assign
    assertEquals("Jordan", Jordan.getFirstName());

  }


  @Test
  public void testSetFirstName() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(id, firstName, lastName);
    Jordan.setFirstName("newName");

    // Assign
    assertEquals("newName", Jordan.getFirstName());
  }

  @Test
  public void testgetSurname() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(id, firstName, lastName);


    // Assign
    assertEquals("Harrison", Jordan.getSurname());
  }

  @Test
  public void testSetSurname() {

    // Assign
    Long id = 1L;
    String firstName = "Jordan";
    String lastName = "Harrison";

    // Act
    Customer Jordan = new Customer(id, firstName, lastName);
    Jordan.setSurname("newName");

    // Assign
    assertEquals("newName", Jordan.getSurname());
  }

}
