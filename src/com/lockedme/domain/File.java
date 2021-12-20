package com.lockedme.domain;

public class File {
    private String fileName;
    private String filePath;
    private int size;

    public File(String fileName, String filePath, int size) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.size = size;
    }

    public String toString() {
        return this.fileName;
    }
}
