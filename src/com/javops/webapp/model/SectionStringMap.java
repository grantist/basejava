package com.javops.webapp.model;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringMap {

    Map<Date, String> map = new HashMap<>();

    public SectionStringMap(Map<Date, String> map) {
        this.map = map;
    }

    void show() {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }
}
