package com.javops.webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private final String fullName;
    private Map<ContactType, String> contact = new EnumMap(ContactType.class);
    private Map<SectionType, Title> section = new EnumMap(SectionType.class);

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

    public Map<ContactType, String> getContacts() {
        return contact;
    }

    public Map<SectionType, Title> getSections() {
        return section;
    }

    public String getUuid() {
        return uuid;
    }

    public void addContact(ContactType type, String value) {
        contact.put(type, value);
    }

    public void addSection(SectionType type, Title title) {
        section.put(type, title);
    }

    public String getContact(ContactType type) {
        return contact.get(type);
    }

    public Title getSection(SectionType type) {
        return section.get(type);
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contact=" + contact +
                ", section=" + section +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contact, resume.contact) &&
                Objects.equals(section, resume.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contact, section);
    }

    @Override
    public int compareTo(Resume object) {
        int item = fullName.compareTo(object.fullName);
        if (item != 0) {
            return item;
        }
        return uuid.compareTo(object.uuid);
    }
}
