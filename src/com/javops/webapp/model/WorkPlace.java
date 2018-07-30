package com.javops.webapp.model;

import java.time.LocalDate;

/**
 * Created by TRACTEL_RND on 23.07.2018.
 */
public class WorkPlace extends Title {

    private final String nameJob;
    private final String title;
    private final LocalDate start;

    @Override
    public String toString() {
        return "WorkPlace{" +
                "nameJob='" + nameJob + '\'' +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkPlace workPlace = (WorkPlace) o;

        if (!nameJob.equals(workPlace.nameJob)) return false;
        if (!title.equals(workPlace.title)) return false;
        if (!start.equals(workPlace.start)) return false;
        if (!end.equals(workPlace.end)) return false;
        return description != null ? description.equals(workPlace.description) : workPlace.description == null;

    }

    @Override
    public int hashCode() {
        int result = nameJob.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

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
