package com.auction.server.dao;

public interface DataStore {
    void save(SystemSnapshot snapshot);
    SystemSnapshot load();
}
