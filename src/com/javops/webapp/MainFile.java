package com.javops.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        String dir = "./src";
        File path = new File(dir);
        showFileAndDirectory(path, 0);
    }

    private static void showFileAndDirectory(File dirPath, int intend) {
        String dirIntend = getTextIntend(intend);
        /*Print Directory Name*/
        System.out.println(dirIntend + dirPath.getName() + "/");
        File[] files = dirPath.listFiles();
        /*Recursion for Directories*/
        for (File file : files) {
            if (file.isDirectory()) {
                showFileAndDirectory(file, intend + 1);
            }
        }
        /*Print File Name*/
        for (File file : files) {
            if (file.isFile()) {
                String fileIntend = getTextIntend(intend + 2);
                System.out.println(fileIntend + file.getName());
            }
        }
    }

    private static String getTextIntend(int intend) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intend; i++) {
            builder.append(" |--");
        }
        return builder.toString();
    }
}





