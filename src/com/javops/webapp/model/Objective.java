package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Objective extends SectionString {
    public Objective(String objective) {
        super(objective);
    }

    @Override
    void show() {
        System.out.println(SectionType.OBJECTIVE.getTitle());
        super.show();
    }
}
