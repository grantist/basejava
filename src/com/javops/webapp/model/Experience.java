package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Experience {
    private ArrayList<String> experience = new ArrayList<>();

    public Experience(ArrayList<String> experience) {
        this.experience = experience;
    }

    void show() {
        System.out.println(SectionType.EXPERIENCE.getTitle());
        for (String s : experience) {
            System.out.println("* " + experience);
        }
    }
}
