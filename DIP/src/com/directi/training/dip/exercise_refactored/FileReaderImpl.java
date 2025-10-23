package com.directi.training.dip.exercise_refactored;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderImpl implements Reader {
    private final String filePath;

    public FileReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}