package com.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonHandler {
    public static <T> T readJsonFile(String filePath, Class<T> myClass) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("JSON file not found: " + filePath);
            }
            return objectMapper.readValue(file, myClass);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file: " + filePath, e);
        }
    }
}
