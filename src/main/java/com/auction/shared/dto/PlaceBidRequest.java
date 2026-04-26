package com.auction.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlaceBidRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long auctionId;
    private BigDecimal amount;

    public PlaceBidRequest() {}

    public PlaceBidRequest(Long auctionId, BigDecimal amount) {
        this.auctionId = auctionId;
        this.amount = amount;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}