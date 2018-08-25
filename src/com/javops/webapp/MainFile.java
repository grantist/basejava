package com.javops.webapp;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        String dir = "./src";
        File path = new File(dir);
        printDirectoryDeeply(path);
    }

    public static void printDirectoryDeeply(File dir) {
        File files[] = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}


