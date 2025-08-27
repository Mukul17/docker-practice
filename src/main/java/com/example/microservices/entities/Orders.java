package com.example.microservices.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orders {

    public Orders(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_number")
    private int orderNumber;
    @Column(name = "order_placed_on_date")
    LocalDate orderPlacedOn;
    @Column(name = "order_amount")
    private Double orderAmount;
    private Long productId;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderPlacedOn() {
        return orderPlacedOn;
    }

    public void setOrderPlacedOn(LocalDate orderPlacedOn) {
        this.orderPlacedOn = orderPlacedOn;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
