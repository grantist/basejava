package com.javops.webapp.model;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public class SectionString extends Title {
    private final String string;

    public SectionString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionString string1 = (SectionString) o;
        return string != null ? string.equals(string1.string) : string1.string == null;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }
}

