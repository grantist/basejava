package com.javops.webapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Education extends SectionStringMap {

    public Education(Map<Date, String> education) {
        super(education);
    }

    @Override
    void show() {
        System.out.println(SectionType.EDUCATION.getTitle());
        super.show();
    }
}