package com.example.example.studentprofile;

/*
DTO stands for Data Transfer Objects.
It is used to transfer data b/w layers especially b/w client and server or internal layers like Controller and Service
DTO does not contain business logic , they are POJO with fields , getters ,setters
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class orderdto {

    @JsonProperty("cname") // used for serialization and de-serialization process.
    private String customerName;
    @JsonProperty("oid")
    private String orderId;
    @JsonProperty("q")
    private int quantity;

    @Override
    public String toString() {
        return "orderdto{" +
                "customerName='" + customerName + '\'' +
                ", orderId='" + orderId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
