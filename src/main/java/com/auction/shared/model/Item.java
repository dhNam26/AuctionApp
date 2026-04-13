package com.auction.shared.model;

import java.math.BigDecimal;

public class Item extends Entity {
    private String name;
    private String description;
    private BigDecimal startingPrice;
    private ItemCategory category;

    public Item(String name, String description, BigDecimal startingPrice, ItemCategory category) {
        super();
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
