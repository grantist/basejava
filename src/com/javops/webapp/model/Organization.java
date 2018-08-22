package com.javops.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by TRACTEL_RND on 23.07.2018.
 */
public class Organization {
    private final Link homePage;
    private List<Position> position = new ArrayList<>();

    public Organization(String name, String url, Position... position) {
        this(new Link(name, url), Arrays.asList(position));
    }

    public Organization(Link homePage, List<Position> positions) {
        this.homePage = homePage;
        this.position = positions;
    }

    public static class Position {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, position);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", position=" + position +
                '}';
    }

}