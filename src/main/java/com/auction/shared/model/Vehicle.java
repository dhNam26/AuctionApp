package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vehicle extends Item {

    private String manufacturer;
    private int year;

    public Vehicle(String title, String description, BigDecimal startingPrice, String manufacturer, int year) {
        super(title, description, startingPrice, ItemCategory.VEHICLE);
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("manufacturer", manufacturer);
        attributes.put("year", Integer.toString(year));
        return attributes;
    }
}
