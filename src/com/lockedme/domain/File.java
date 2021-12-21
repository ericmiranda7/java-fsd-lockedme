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

    public File(String fileName) {
        this(fileName, "", 0);
    }

    public String getName() {
        return this.fileName;
    }

    @Override
    public String toString() {
        return this.fileName;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof File) || obj == null) return false;

        if (obj == this) return true;

        File comp = (File) obj;

        if (this.fileName.equals(comp.fileName)) return true;

        return false;
    }
}
