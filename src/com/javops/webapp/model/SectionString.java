package com.javops.webapp.model;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionString extends Title {
    private String string;
    private SectionType type;

    public SectionString(SectionType type, String string) {
        this.string = string;
        this.type = type;
    }

    @Override
    void show() {
        System.out.println(type.getTitle());
        System.out.println(string);
    }
}

