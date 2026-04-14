package com.auction.shared.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Art extends Item {

    private String artist;
    private String medium;

    public Art(String title, String description, double startingPrice, String artist, String medium) {
        super(title, description, startingPrice, ItemCategory.ART);
        this.artist = artist;
        this.medium = medium;
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
        attributes.put("artist", artist);
        attributes.put("medium", medium);
        return attributes;
    }
}
