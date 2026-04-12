package main.java.com.auction.model;

public class Item {
    private String id;
    private String name;
    private String description;
    private double startingPrice;
    private ItemCategory category;

    public Item(String id, String name, String description, double startingPrice, ItemCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
