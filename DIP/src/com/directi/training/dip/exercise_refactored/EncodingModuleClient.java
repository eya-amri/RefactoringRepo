package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

public class EncodingModuleClient {
    public static void main(String[] args) throws IOException {
        // Encodage avec fichiers
        Reader fileReader = new FileReaderImpl(
                "DIP/src/com/directi/training/dip/exercise_refactored/beforeEncryption.txt");
        Writer fileWriter = new FileWriterImpl(
                "DIP/src/com/directi/training/dip/exercise_refactored/afterEncryption.txt");
        EncodingModule fileEncodingModule = new EncodingModule(fileReader, fileWriter);
        fileEncodingModule.encode();

        // Encodage avec réseau et base de données
        Reader networkReader = new NetworkReader("http", "myfirstappwith.appspot.com", "/index.html");
        Writer databaseWriter = new DatabaseWriter();
        EncodingModule networkEncodingModule = new EncodingModule(networkReader, databaseWriter);
        networkEncodingModule.encode();

        // Démonstration de flexibilité
        System.out.println("=== DÉMONSTRATION DIP ===");

        // Même encodeur, différentes sources/destinations
        encodeFromFileToDatabase();
        encodeFromNetworkToFile();
    }

    private static void encodeFromFileToDatabase() throws IOException {
        Reader fileReader = new FileReaderImpl(
                "DIP/src/com/directi/training/dip/exercise_refactored/beforeEncryption.txt");
        Writer databaseWriter = new DatabaseWriter();
        EncodingModule module = new EncodingModule(fileReader, databaseWriter);
        module.encode();
        System.out.println("Encoded from file to database - Records: " + DatabaseWriter.getRecordCount());
    }

    private static void encodeFromNetworkToFile() throws IOException {
        Reader networkReader = new NetworkReader("http", "myfirstappwith.appspot.com", "/index.html");
        Writer fileWriter = new FileWriterImpl(
                "DIP/src/com/directi/training/dip/exercise_refactored/network_encoded.txt");
        EncodingModule module = new EncodingModule(networkReader, fileWriter);
        module.encode();
        System.out.println("Encoded from network to file");
    }
}
