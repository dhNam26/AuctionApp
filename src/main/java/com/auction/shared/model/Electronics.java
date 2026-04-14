package com.auction.shared.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Electronics extends Item {

    private String brand;
    private String condition;

    public Electronics(String title, String description, double startingPrice, String brand, String condition) {
        super(title, description, startingPrice, ItemCategory.ELECTRONICS);
        this.brand = brand;
        this.condition = condition;
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
        attributes.put("brand", brand);
        attributes.put("condition", condition);
        return attributes;
    }
}
