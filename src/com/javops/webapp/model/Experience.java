package com.javops.webapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Experience extends SectionStringMap {

    public Experience(Map<Date, String> experience) {
        super(experience);
    }

    @Override
    void show() {
        System.out.println(SectionType.EXPERIENCE.getTitle());
        super.show();
    }
}
