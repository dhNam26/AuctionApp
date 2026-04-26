package com.auction.shared.dto;

import com.auction.shared.model.ItemCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateAuctionRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String itemName;
    private String description;
    private ItemCategory itemCategory;
    private BigDecimal startPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CreateAuctionRequest() {}

    public CreateAuctionRequest(String itemName, String description, ItemCategory itemCategory, BigDecimal startPrice, LocalDateTime startTime, LocalDateTime endTime) {
        this.itemName = itemName;
        this.description = description;
        this.itemCategory = itemCategory;
        this.startPrice = startPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
