package com.javops.webapp.storage;

import com.javops.webapp.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {


    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(ContactType.PHONE, "11111");

        R4.addContact(ContactType.PHONE, "44444");
        R4.addContact(ContactType.SKYPE, "Skype");

        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "22222");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", null,
                                new Organization.Position(2005, Month.JANUARY, "position1", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "www",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "www"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));

        R2.addContact(ContactType.MAIL, "mail2@ya.ru");
        R2.addContact(ContactType.PHONE, "22222");
        R2.addSection(SectionType.OBJECTIVE, new TextSection("Objective2"));
        R2.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R2.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment21", "Achivment22", "Achivment23"));
        R2.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization21", "http://Organization22.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content2"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content22"))));
        R2.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "wwww",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "www"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization22", "http://Organization23.ru")));
        R3.addContact(ContactType.MAIL, "mail3@ya.ru");
        R3.addContact(ContactType.PHONE, "33333");
        R3.addSection(SectionType.OBJECTIVE, new TextSection("Objective3"));
        R3.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R3.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment31", "Achivment32", "Achivment33"));
        R3.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R3.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization31", "http://Organization32.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content3"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content33"))));
        R3.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", "nnnn",
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", "hhh"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization31", "www")));
    }
}
