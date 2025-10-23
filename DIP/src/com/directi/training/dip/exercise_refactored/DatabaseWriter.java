package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseWriter implements Writer {
    private static Map<Integer, String> data = new HashMap<>();
    private static int count = 0;

    @Override
    public void write(String inputString) throws IOException {
        data.put(++count, inputString);
        System.out.println("Written to database - ID: " + count + ", Data: " + inputString);
    }

    // Méthode utilitaire pour les tests
    public static String readFromDatabase(int id) {
        return data.get(id);
    }

    public static int getRecordCount() {
        return data.size();
    }
}