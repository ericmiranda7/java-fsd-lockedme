package com.lockedme.logic;

import com.lockedme.domain.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileManager {
    private ArrayList<File> files;

    public FileManager(File... files) {
        this.files = new ArrayList<>(Arrays.asList(files));
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();

        for (File f : this.files) {
            sb.append(f);
            sb.append("\n");
        }

        return sb.toString();
    }

    public void addFile(String fileName, String filePath, int size) {
        // TODO(): Regex for file name validation
        this.files.add(new File(fileName, filePath, size));
    }

    public void deleteFile(String fileName) throws FileNotFoundException {
        File tempFile = new File(fileName);
        if (!this.files.contains(tempFile)) throw new FileNotFoundException();

        this.files.remove(tempFile);
    }
}
