package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class Personal extends SectionString {

    public Personal(String personal) {
        super(personal);
    }

    @Override
    void show() {
        System.out.println(SectionType.PERSONAL.getTitle());
        super.show();
    }
}
