package com.javops.webapp.model;

import java.util.*;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringMap extends Title {

    SectionType type;
    ArrayList list;
    //EnumMap<SectionType, ArrayList> maps = new EnumMap(SectionType.class);

    Map<ContactType, String> mapsContact = new HashMap<>();


    public SectionStringMap(SectionType type, ArrayList list) {
        this.type = type;
        this.list = list;
    }

    public SectionStringMap(HashMap mapsContact) {
        this.mapsContact = mapsContact;
    }


    void show() {
        for (Object s : list) {
            System.out.println(s);
        }
    }

    void showContact() {
        for (Map.Entry entry : mapsContact.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }
}
