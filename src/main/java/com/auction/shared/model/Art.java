package com.auction.shared.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Art extends Item {

    private String artist;
    private String medium;

    public Art(String name, String description, BigDecimal startingPrice, String artist, String medium) {
        super(name, description, startingPrice, ItemCategory.ART);
        this.artist = requireNotBlank(artist, "artist");
        this.medium = requireNotBlank(medium, "medium");
    }

    public String getArtist() {
        return artist;
    }

    public String getMedium() {
        return medium;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new LinkedHashMap<>();
        attributes.put("id", getId());
        attributes.put("timeCreate", getCreatedAt().toString());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("startingPrice", getStartingPrice().toString());
        attributes.put("artist", getArtist());
        attributes.put("medium", getMedium());
        return attributes;
    }
}
