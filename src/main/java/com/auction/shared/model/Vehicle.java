package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vehicle extends Item {

    private String manufacturer;
    private String year;

    public Vehicle(String name, String description, BigDecimal startingPrice, String manufacturer, String year) {
        super(name, description, startingPrice, ItemCategory.VEHICLE);
        this.manufacturer = requireNotBlank(manufacturer, "manufacturer");
        this.year = requireNotBlank(year, "year");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("id", getId());
        attributes.put("timeCreate", getCreatedAt().toString());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("startingPrice", getStartingPrice().toString());
        attributes.put("manufacturer", getManufacturer());
        attributes.put("year", getYear());
        return attributes;
    }
}
