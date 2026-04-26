package com.auction.shared.exception;

public class InvalidBidException extends RuntimeException {
    public InvalidBidException(String message) {
        super(message);
    }
}
