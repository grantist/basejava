package com.javops.webapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringList extends Title {

    private List<String> stringList;

    public List<String> getStringList() {
        return stringList;
    }

    public SectionStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
