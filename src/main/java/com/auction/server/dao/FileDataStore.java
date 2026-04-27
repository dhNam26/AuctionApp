package com.auction.server.dao;

import java.io.*;

public class FileDataStore implements DataStore {
    private static final String FILE_PATH = "data/auction-system.ser";

    @Override
    public void save(SystemSnapshot snapshot) {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(FILE_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(snapshot);
            System.out.println("Đã lưu dữ liệu thành công vào file!");
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @Override
    public SystemSnapshot load() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("Không tìm thấy dữ liệu cũ, khởi tạo hệ thống mới.");
            return new SystemSnapshot();
        }

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            SystemSnapshot snapshot = (SystemSnapshot) ois.readObject();
            System.out.println("Đã tải dữ liệu cũ thành công!");
            return snapshot;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file dữ liệu: " + e.getMessage());
            return new SystemSnapshot();
        }
    }
}
