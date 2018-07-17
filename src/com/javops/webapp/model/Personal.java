package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Personal {
    ArrayList<String> personal = new ArrayList<>();

    public Personal(ArrayList<String> personal) {
        this.personal = personal;
    }

    void show() {
        System.out.println(SectionType.PERSONAL.getTitle());
        for (String s : personal) {
            System.out.println(s);
        }
    }
}
