package com.javops.webapp.model;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionString extends Title {

    private String string;

    public SectionString(SectionType type, String string) {
        this.string = string;
        this.type = type;
    }

    @Override
    void show() {
        super.show();
        System.out.println(string);
    }
}

