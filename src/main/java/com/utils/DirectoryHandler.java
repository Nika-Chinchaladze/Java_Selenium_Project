package com.utils;

import java.io.File;

public class DirectoryHandler {
    public static boolean deleteDirectory(File directory) {
        File[] allContents = directory.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directory.delete();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java com.utils.DirectoryHandler <directory_path>");
            return;
        }

        String dirPath = args[0];
        File dir = new File(dirPath);
        String absolutePath = dir.getAbsolutePath();

        if (!dir.exists()) {
            System.out.println("Directory not found: " + absolutePath);
            return;
        }

        boolean deleted = deleteDirectory(dir);
        if (deleted) {
            System.out.println("Directory Deleted: " + absolutePath);
        } else {
            System.out.println("Failed to delete directory: " + absolutePath);
        }
    }
}

// Usage: Docs
/*
    1. mvn clean compile
    2. java -cp target/classes com.utils.DirectoryHandler <allure-results>
*/
