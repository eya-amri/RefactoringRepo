package com.directi.training.dip.exercise_refactored;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    private final String filePath;
    
    public FileWriterImpl(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public void write(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }
}
