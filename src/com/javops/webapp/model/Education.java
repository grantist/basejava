package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Education {

    private ArrayList<String> education = new ArrayList();

    public Education(ArrayList<String> education) {
        this.education = education;
    }

    void show() {
        System.out.println(SectionType.EDUCATION.getTitle());
        for (String s : education) {
            System.out.println(s);
        }
    }
}
