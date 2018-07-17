package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Objective {
    private ArrayList<String> objective = new ArrayList<>();

    public Objective(ArrayList<String> objective) {
        this.objective = objective;
    }

    void show() {
        System.out.println(SectionType.OBJECTIVE.getTitle());
        for (String s : objective) {
            System.out.println(s);
        }
    }
}
