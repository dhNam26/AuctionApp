package com.auction.model;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
public abstract class Entity {
    private final String id;
    private final LocalDateTime timeCreate;

    protected Entity() {
        this(UUID.randomUUID().toString(), LocalDateTime.now());
    }

    protected Entity(String id, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id");
        this.timeCreate  = Objects.requireNonNull(createdAt, "createdAt");
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return timeCreate ;
    }
}
