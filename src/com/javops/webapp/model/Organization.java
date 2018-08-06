package com.javops.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by TRACTEL_RND on 23.07.2018.
 */
public class Organization {
    private final String title;
    private final LocalDate start;
    private final LocalDate end;
    private final String description;
    private final Link linkCompany;

    public Organization(String nameJob, String url, LocalDate start, LocalDate end, String title, String description) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.description = description;
        this.linkCompany = new Link(nameJob, url);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                ", linkCompany=" + linkCompany +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization workPlace = (Organization) o;
        return Objects.equals(title, workPlace.title) &&
                Objects.equals(start, workPlace.start) &&
                Objects.equals(end, workPlace.end) &&
                Objects.equals(description, workPlace.description) &&
                Objects.equals(linkCompany, workPlace.linkCompany);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, start, end, description, linkCompany);
    }


}
