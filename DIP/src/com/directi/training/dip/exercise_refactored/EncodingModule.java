package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.util.Base64;

public class EncodingModule {
    private final Reader reader;
    private final Writer writer;

    // Injection des dépendances via constructeur
    public EncodingModule(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void encode() throws IOException {
        String data = reader.read();
        String encodedData = Base64.getEncoder().encodeToString(data.getBytes());
        writer.write(encodedData);
    }

    // Méthode utilitaire statique pour l'encodage
    public static String encodeData(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}