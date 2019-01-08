package com.javops.webapp.model;

import com.javops.webapp.util.JsonParser;

/**
 * Created by TRACTEL_RND on 10.07.2018.
 */
public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения") {
        @Override
        protected String toHtml0(Section content) {
            return getTitle() + ": " + content.toString().replaceAll("[\\[\\]]", "");
        }
    },
    QUALIFICATIONS("Квалификация") {
        @Override
        protected String toHtml0(Section content) {
            return getTitle() + ": " + content.toString().replaceAll("[\\[\\]]", "");
        }
    },
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    protected String toHtml0(Section content) {
        return title + ": " + content;
    }

    public String toHtml(Section content) {
        return (content == null) ? "" : toHtml0(content);
    }


    public String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

