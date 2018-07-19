package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringList extends Title {

    private ArrayList<String> stringList = new ArrayList<>();

    public SectionStringList(SectionType type, ArrayList<String> stringList) {
        this.type = type;
        this.stringList = stringList;
    }

    void show() {
        super.show();
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
