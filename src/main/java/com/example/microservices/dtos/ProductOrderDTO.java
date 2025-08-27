package com.example.microservices.dtos;

import com.example.microservices.domain.Product;
import com.example.microservices.entities.Orders;

public class ProductOrderDTO {

    public ProductOrderDTO(){

    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Orders orders;
    private Product product;

}
