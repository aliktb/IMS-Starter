package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

  private Long id;
  private String itemName;
  private Long itemValue;



  public Item(String itemName, Long itemValue) {
    super();
    this.itemName = itemName;
    this.itemValue = itemValue;
  }


  public Item(Long id, String itemName, Long itemValue) {
    super();
    this.id = id;
    this.itemName = itemName;
    this.itemValue = itemValue;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getItemName() {
    return itemName;
  }


  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public Long getItemValue() {
    return itemValue;
  }


  public void setItemValue(Long itemValue) {
    this.itemValue = itemValue;
  }


  @Override
  public String toString() {
    return "Item [id=" + id + ", itemName=" + itemName + ", itemValue=" + itemValue + "]";
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, itemName, itemValue);
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    return Objects.equals(id, other.id) && Objects.equals(itemName, other.itemName)
        && Objects.equals(itemValue, other.itemValue);
  }



}
