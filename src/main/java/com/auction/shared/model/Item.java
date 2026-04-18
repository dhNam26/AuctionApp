package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Item extends Entity {
    private String name;
    private String description;
    private BigDecimal startingPrice;
    private ItemCategory category;

    public Item(String name, String description, BigDecimal startingPrice, ItemCategory category) {
        super();
        this.name = requireNotBlank(name, "name");
        this.description = requireNotBlank(description, "description");
        this.startingPrice = Objects.requireNonNull(startingPrice, "startingPrice");
        this.category = Objects.requireNonNull(category, "category");
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

    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        return attributes;
    }
    public String requireNotBlank(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " cannot be blank");
        }
        return value.trim();
    }
}
