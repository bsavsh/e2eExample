package com.savsh.entity;

import java.math.BigDecimal;

public class Item {
    private long id;
    private String sku;
    private String itemName;
    private String upc;
    private String itemNumber;
    private String brand;
    private String description;
    private int qty;
    private BigDecimal cost;
    private BigDecimal shippingCost;

    public long getId() {
        return id;
    }

    public Item setId(long id) {
        this.id = id;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public Item setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getUpc() {
        return upc;
    }

    public Item setUpc(String upc) {
        this.upc = upc;
        return this;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public Item setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Item setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getQty() {
        return qty;
    }

    public Item setQty(int qty) {
        this.qty = qty;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Item setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public Item setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
        return this;
    }
}
