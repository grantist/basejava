package com.javops.webapp.model;

import com.sun.scenario.animation.shared.TimerReceiver;
import sun.swing.SwingUtilities2;

import java.util.*;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private final String fullName;

    private Map<ContactType, String> contact = new EnumMap(ContactType.class);
    private Map<SectionType, Title> section = new EnumMap(SectionType.class);

    public String getContact(ContactType type) {
        return contact.get(type);
    }

    public Title getSection(SectionType type) {
        return section.get(type);
    }

    public Map<ContactType, String> getContacts() {
        return contact;
    }

    public Map<SectionType, Title> getSections() {
        return section;
    }

    public String getUuid() {
        return uuid;
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullname must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
        System.out.println(fullName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume object) {
        int item = fullName.compareTo(object.fullName);
        if (item != 0) {
            return item;
        }
        return uuid.compareTo(object.uuid);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }


    public void addContact(ContactType type, String value) {
        contact.put(type, value);
    }

    public void addSection(SectionType type, Title title) {
        section.put(type, title);
    }

}
