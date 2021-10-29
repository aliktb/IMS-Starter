package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {

  private Long orderItemsId;
  private Long orderId;
  private Long customerId;
  private Long itemId;

  public OrderItem(Long orderId, Long customerId, Long itemId) {
    super();
    this.orderId = orderId;
    this.customerId = customerId;
    this.itemId = itemId;
  }

  public OrderItem(Long orderItemsId, Long orderId, Long customerId, Long itemId) {
    super();
    this.orderItemsId = orderItemsId;
    this.orderId = orderId;
    this.customerId = customerId;
    this.itemId = itemId;
  }

  public Long getOrderItemsId() {
    return orderItemsId;
  }

  public void setOrderItemsId(Long orderItemsId) {
    this.orderItemsId = orderItemsId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  @Override
  public String toString() {
    return "OrderItem [orderItemsId=" + orderItemsId + ", orderId=" + orderId + ", customerId="
        + customerId + ", itemId=" + itemId + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, itemId, orderId, orderItemsId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderItem other = (OrderItem) obj;
    return Objects.equals(customerId, other.customerId) && Objects.equals(itemId, other.itemId)
        && Objects.equals(orderId, other.orderId)
        && Objects.equals(orderItemsId, other.orderItemsId);
  }



}
