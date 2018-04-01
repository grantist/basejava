package com.javops.webapp.model;

/**
 * com.urise.webapp.model.com.javops.webapp.model.Resume class
 */
public class Resume {
    // Unique identifier
    private String uuid;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return uuid;
    }
}