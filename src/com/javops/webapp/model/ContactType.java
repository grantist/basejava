package com.javops.webapp.model;

/**
 * Created by TRACTEL_RND on 18.07.2018.
 */
public enum ContactType {
    PHONE("ТЕЛЕФОН"),
    MAIL("ПОЧТА"),
    Skype("CКАЙП");

    ContactType(String typeContact) {
        this.typeContact = typeContact;
    }

    private String typeContact;

    public String getTitle() {
        return typeContact;
    }

}
