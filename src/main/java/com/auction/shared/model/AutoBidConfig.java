package com.auction.shared.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class AutoBidConfig {

    private final String bidderId;
    private final String bidderName;
    private final double maxBid;
    private final double increment;
    private final LocalDateTime registeredAt;

    public AutoBidConfig(String bidderId, String bidderName, double maxBid, double increment, LocalDateTime registeredAt) {
        this.bidderId = Objects.requireNonNull(bidderId, "bidderId");
        this.bidderName = Objects.requireNonNull(bidderName, "bidderName");
        this.maxBid = maxBid;
        this.increment = increment;
        this.registeredAt = Objects.requireNonNull(registeredAt, "registeredAt");
    }

    public String getBidderId() {
        return bidderId;
    }

    public String getBidderName() {
        return bidderName;
    }

    public double getMaxBid() {
        return maxBid;
    }

    public double getIncrement() {
        return increment;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }
}
