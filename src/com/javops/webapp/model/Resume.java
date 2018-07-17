package com.javops.webapp.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;
    private final String fullName;

    private AchievementAndQualification achAndQual = new AchievementAndQualification(new ArrayList<>(), new ArrayList<>());
    private Contacts contacts = new Contacts("phone", "mail", "skype");
    private Education education = new Education(new ArrayList<>());
    private Experience experience = new Experience(new ArrayList<>());
    private Objective objective = new Objective(new ArrayList<>());
    private Personal personal = new Personal(new ArrayList<>());

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

    public void show() {
        contacts.show();
        objective.show();
        personal.show();
        achAndQual.show();
        experience.show();
        education.show();
    }
}
