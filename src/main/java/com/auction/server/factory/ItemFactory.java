package com.auction.server.factory;

import com.auction.shared.model.*;

import java.math.BigDecimal;
import java.util.Map;

public class ItemFactory {
    // Thêm Map<String, String> extraInfo vào cuối
    public static Item createItem(String name, String description, BigDecimal startingPrice, ItemCategory category, Map<String, String> extraInfo) {
        switch (category) {
            case ART:
                String artist = extraInfo.getOrDefault("artist", "Chưa cập nhật");
                String medium = extraInfo.getOrDefault("medium", "Chưa cập nhật");

                return new Art(name, description, startingPrice, artist, medium);

            case VEHICLE:
                String manufacturer = extraInfo.getOrDefault("manufacturer", "Chưa cập nhật");
                String year = extraInfo.getOrDefault("year", "0");
                return new Vehicle(name, description, startingPrice, manufacturer, year);

            case ELECTRONICS:
                String brand = extraInfo.getOrDefault("brand", "Chưa cập nhật");
                String condition = extraInfo.getOrDefault("condition", "Chưa cập nhật");
                return new Electronics(name, description, startingPrice, brand, condition);

            default:
                throw new IllegalArgumentException("Danh mục sản phẩm không hợp lệ: " + category);
        }
    }
}
