package com.javops.webapp;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        String dir = "./src";
        File path = new File(dir);
        displayAll(path);
    }

    static void displayAll(File path) {
        if (path.isFile()) {
            System.out.println(path.getName());
        } else {
            File files[] = path.listFiles();
            for (File dirOrFile : files) {
                displayAll(dirOrFile);
            }
        }
    }
}


