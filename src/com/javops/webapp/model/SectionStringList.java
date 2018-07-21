package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringList extends Title {

    private ArrayList<String> stringList = new ArrayList<>();
    SectionType type;

    public SectionStringList(SectionType type, ArrayList<String> stringList) {
        this.stringList = stringList;
        this.type = type;
    }

    void show() {
        System.out.println(type.getTitle());
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
