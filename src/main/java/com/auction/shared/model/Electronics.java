package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Electronics extends Item {

    private String brand;
    private String condition;

    public Electronics(String name, String description, BigDecimal startingPrice, String brand, String condition) {
        super(name, description, startingPrice, ItemCategory.ELECTRONICS);
        this.brand = requireNotBlank(brand, "brand");
        this.condition = requireNotBlank(condition, "condition");
    }

    public String getBrand() {
        return brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("id", getId());
        attributes.put("timeCreate", getCreatedAt().toString());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("startingPrice", getStartingPrice().toString());
        attributes.put("brand", getBrand());
        attributes.put("condition", getCondition());
        return attributes;
    }
}
