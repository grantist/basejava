package com.javops.webapp.model;

import java.util.List;

/**
 * Created by TRACTEL_RND on 24.07.2018.
 */
public class OrganizationSection extends Section {
    private final List<Organization> workPlaceList;

    public OrganizationSection(List<Organization> workPlaceList) {
        this.workPlaceList = workPlaceList;
    }

    public List<Organization> getWorkPlaceList() {
        return workPlaceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return workPlaceList.equals(that.workPlaceList);
    }

    @Override
    public int hashCode() {
        return workPlaceList.hashCode();
    }

    @Override
    public String toString() {
        return workPlaceList.toString();
    }

}
