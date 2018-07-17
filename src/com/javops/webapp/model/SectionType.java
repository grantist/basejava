package com.javops.webapp.model;

/**
 * Created by TRACTEL_RND on 10.07.2018.
 */
public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    SectionType(String title) {
        this.title = title;
    }

    private String title;


    public String getTitle() {
        return title;
    }

}

