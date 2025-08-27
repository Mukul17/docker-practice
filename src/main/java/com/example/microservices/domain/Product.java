package com.example.microservices.domain;

public class Product {

    public Product(){

    }

    private Long id;
    private String nameOfProduct;
    private double priceOfProduct;
    private String manufacterName;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public String getManufacterName() {
        return manufacterName;
    }

    public void setManufacterName(String manufacterName) {
        this.manufacterName = manufacterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
