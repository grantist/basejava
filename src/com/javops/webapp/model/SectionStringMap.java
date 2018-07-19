package com.javops.webapp.model;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringMap extends Title {
    Map<Date, String> map = new HashMap<>();

    public SectionStringMap(SectionType type, Map<Date, String> map) {
        this.type = type;
        this.map = map;
    }

    void show() {
        super.show();
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }
}
