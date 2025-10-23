package com.directi.training.dip.exercise_refactored;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetworkReader implements Reader {
    private final String protocol;
    private final String host;
    private final String path;
    
    public NetworkReader(String protocol, String host, String path) {
        this.protocol = protocol;
        this.host = host;
        this.path = path;
    }
    
    @Override
    public String read() throws IOException {
        URL url = new URL(protocol, host, path);
        StringBuilder inputString = new StringBuilder();
        try (InputStream in = url.openStream();
             java.io.InputStreamReader reader = new java.io.InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                inputString.append((char) c);
            }
        }
        return inputString.toString();
    }
}