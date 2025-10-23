package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class NetworkReader implements Reader {
    private final String urlString;

    // Constructeur avec URL complète
    public NetworkReader(String urlString) {
        this.urlString = urlString;
    }

    // Constructeur avec parties séparées (alternative sans déprication)
    public NetworkReader(String protocol, String host, String path) {
        this.urlString = protocol + "://" + host + path;
    }

    @Override
    public String read() throws IOException {
        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            StringBuilder inputString = new StringBuilder();

            try (InputStream in = url.openStream();
                    java.io.InputStreamReader reader = new java.io.InputStreamReader(in)) {
                int c;
                while ((c = reader.read()) != -1) {
                    inputString.append((char) c);
                }
            }
            return inputString.toString();

        } catch (URISyntaxException e) {
            throw new IOException("URL invalide: " + urlString, e);
        }
    }
}