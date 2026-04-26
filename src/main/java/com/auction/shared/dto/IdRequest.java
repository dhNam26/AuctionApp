package com.auction.shared.dto;

import java.io.Serializable;

public class IdRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    public IdRequest() {}

    public IdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getAuctionId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuctionId(Long auctionId) {
        this.id = auctionId;
    }
}