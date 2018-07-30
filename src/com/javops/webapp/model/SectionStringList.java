package com.javops.webapp.model;

import java.util.List;
/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionStringList extends Title {

    private List<String> stringList;

    public List<String> getStringList() {
        return stringList;
    }

    @Override
    public String toString() {
        return stringList.toString();
    }

    public SectionStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionStringList that = (SectionStringList) o;
        return stringList != null ? stringList.equals(that.stringList) : that.stringList == null;

    }

    @Override
    public int hashCode() {
        return stringList != null ? stringList.hashCode() : 0;
    }
}
