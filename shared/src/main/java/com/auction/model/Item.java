package main.java.com.auction.model;

public class Item extends Entity {
    private String name;
    private String description;
    private double startingPrice;
    private ItemCategory category;

    public Item(String name, String description, double startingPrice, ItemCategory category) {
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

    public double getStartingPrice() {
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

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
