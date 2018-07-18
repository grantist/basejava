package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringList {

    private ArrayList<String> stringList = new ArrayList<>();

    void show() {
        for (String s : stringList) {
            System.out.println(s);
        }

    }
}
