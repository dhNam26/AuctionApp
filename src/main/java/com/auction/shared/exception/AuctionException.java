package com.auction.shared.exception;

public class AuctionException extends RuntimeException {
    public AuctionException(String message) {
        super(message);
    }
    public AuctionException(String message, Throwable cause) {
        super(message, cause);
    }
}
