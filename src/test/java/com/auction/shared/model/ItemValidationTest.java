package com.auction.shared.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemValidationTest {

    @Test
    void itemSettersKeepCoreFieldsValid() {
        Item item = new Item("Laptop", "Gaming laptop", BigDecimal.TEN, ItemCategory.ELECTRONICS);

        item.setName("  Camera  ");
        item.setDescription("  Mirrorless body  ");

        assertEquals("Camera", item.getName());
        assertEquals("Mirrorless body", item.getDescription());
        assertThrows(IllegalArgumentException.class, () -> item.setName(" "));
        assertThrows(IllegalArgumentException.class, () -> item.setDescription(null));
        assertThrows(NullPointerException.class, () -> item.setStartingPrice(null));
        assertThrows(NullPointerException.class, () -> item.setCategory(null));
    }

    @Test
    void subclassSettersApplyTheSameValidation() {
        Art art = new Art("Painting", "Oil on canvas", BigDecimal.ONE, "Artist", "Oil");
        Electronics electronics = new Electronics("Console", "Home console", BigDecimal.ONE, "Brand", "Used");
        Vehicle vehicle = new Vehicle("Car", "Sedan", BigDecimal.ONE, "Maker", 2024);

        art.setArtist("  Van Gogh  ");
        art.setMedium("  Oil  ");
        electronics.setBrand("  Sony  ");
        electronics.setCondition("  Like new  ");
        vehicle.setManufacturer("  Ford  ");
        vehicle.setYear("2025");

        assertEquals("Van Gogh", art.getArtist());
        assertEquals("Oil", art.getMedium());
        assertEquals("Sony", electronics.getBrand());
        assertEquals("Like new", electronics.getCondition());
        assertEquals("Ford", vehicle.getManufacturer());
        assertEquals(2025, vehicle.getYear());
        assertThrows(IllegalArgumentException.class, () -> art.setArtist(" "));
        assertThrows(IllegalArgumentException.class, () -> electronics.setCondition(" "));
        assertThrows(IllegalArgumentException.class, () -> vehicle.setManufacturer(null));
    }

    @Test
    void vehicleStringYearMustBeNumeric() {
        Vehicle vehicle = new Vehicle("Truck", "Pickup", BigDecimal.ONE, "Toyota", "2023");

        assertEquals(2023, vehicle.getYear());
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("Truck", "Pickup", BigDecimal.ONE, "Toyota", "20A3"));
        assertThrows(IllegalArgumentException.class, () -> vehicle.setYear("year-2024"));
    }
}
