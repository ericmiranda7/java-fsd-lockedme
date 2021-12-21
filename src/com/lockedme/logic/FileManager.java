package com.lockedme.logic;

import com.lockedme.domain.File;

import java.io.FileNotFoundException;
import java.util.*;

public class FileManager {
    private HashMap<String, File> files;

    public FileManager(File... files) {
        this.files = new HashMap<>();
        for (File f : files) {
            this.files.put(f.getName(), f);
        }
    }

    public String listAll() {
        TreeMap<String, File> sortedKeys = new TreeMap<>(this.files);
        StringBuilder sb = new StringBuilder();

        for (String f : sortedKeys.keySet()) {
            sb.append(f);
            sb.append("\n");
        }

        return sb.toString();
    }

    public void addFile(String fileName, String filePath, int size) {
        // TODO(): Regex for file name validation
        this.files.put(fileName, new File(fileName, filePath, size));
    }

    public void deleteFile(String fileName) throws FileNotFoundException {
        if (!this.files.containsKey(fileName)) throw new FileNotFoundException();

        this.files.remove(fileName);
    }

    public List<String> searchFile(String searchFileName) throws FileNotFoundException {
        List<String> results = new ArrayList<>();

        for (String f : this.files.keySet()) {
            if (f.contains(searchFileName)) results.add(f);
        }

        if (results.size() == 0) throw new FileNotFoundException();

        return results;
    }
}
