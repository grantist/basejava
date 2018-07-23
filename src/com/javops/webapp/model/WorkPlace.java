package com.javops.webapp.model;

import java.time.LocalDate;

/**
 * Created by TRACTEL_RND on 23.07.2018.
 */
public class WorkPlace extends Title {

    private final String nameJob;
    private final String title;
    private final LocalDate start;
    private final LocalDate end;
    private final String description;

    public WorkPlace(String nameJob, LocalDate start, LocalDate end, String title, String description) {
        this.nameJob = nameJob;
        this.title = title;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public String getNameJob() {
        return nameJob;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
