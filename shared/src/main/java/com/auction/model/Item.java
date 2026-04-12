package main.java.com.auction.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal startingPrice;
    private ItemCategory category;

    public Item() {
        this.id = UUID.randomUUID();
        this.startingPrice = BigDecimal.ZERO;
    }

    public Item(String name, String description, BigDecimal startingPrice, ItemCategory category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice == null ? BigDecimal.ZERO : startingPrice;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice == null ? BigDecimal.ZERO : startingPrice;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}