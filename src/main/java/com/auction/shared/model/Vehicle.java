package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.Map;

public class Vehicle extends Item {

    private String manufacturer;
    private int year;

    public Vehicle(String name, String description, BigDecimal startingPrice, String manufacturer, int year) {
        super(name, description, startingPrice, ItemCategory.VEHICLE);
        this.manufacturer = requireNotBlank(manufacturer, "manufacturer");
        this.year = year;
    }

    public Vehicle(String name, String description, BigDecimal startingPrice, String manufacturer, String year) {
        this(name, description, startingPrice, manufacturer, parseYear(year));
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = requireNotBlank(manufacturer, "manufacturer");
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setYear(String year) {
        this.year = parseYear(year);
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = super.getAttributes();
        attributes.put("manufacturer", getManufacturer());
        attributes.put("year", Integer.toString(getYear()));
        return attributes;
    }

    private static int parseYear(String year) {
        String normalizedYear = requireNotBlank(year, "year");
        try {
            return Integer.parseInt(normalizedYear);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("year must be a valid integer", exception);
        }
    }
}
