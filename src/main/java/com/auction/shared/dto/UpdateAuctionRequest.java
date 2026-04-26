package com.auction.shared.dto;

import com.auction.shared.model.ItemCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdateAuctionRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long auctionId;
    private String itemName;
    private String description;
    private ItemCategory itemCategory;
    private BigDecimal startPrice;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public UpdateAuctionRequest() {}

    public UpdateAuctionRequest(Long auctionId, String itemName, String description,
                                ItemCategory itemCategory, BigDecimal startPrice,
                                LocalDateTime startTime, LocalDateTime endTime) {
        this.auctionId = auctionId;
        this.itemName = itemName;
        this.description = description;
        this.itemCategory = itemCategory;
        this.startPrice = startPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}