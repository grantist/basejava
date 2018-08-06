package com.javops.webapp.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.javops.webapp.model.ContactType.*;
import static com.javops.webapp.model.SectionType.*;

/**
 * Created by TRACTEL_RND on 20.07.2018.
 */
public class TestResume extends Resume {

    public TestResume(String fullName) {
        super(fullName);
    }

    public static void main(String[] args) {

        LocalDate start = LocalDate.of(2017, Month.NOVEMBER, 30);
        LocalDate end = LocalDate.of(2019, Month.NOVEMBER, 30);

        Resume resume = new Resume("1", "Ivanov");
        resume.addContact(MAIL, "@ttttr");
        resume.addContact(PHONE, "99999");
        resume.addContact(SKYPE, "fffff");

        resume.addSection(OBJECTIVE, new TextSection("\"Ведущий стажировок"));
        resume.addSection(PERSONAL, new TextSection("Аналитический склад ума"));

        List<String> achievemnets = new ArrayList<String>();
        achievemnets.add("Разработка,WEB,Прочее");
        resume.addSection(ACHIEVEMENT, new ListSection(achievemnets));

        List<String> qualifications = new ArrayList<String>();
        achievemnets.add("JEE AS, GlassFish (v2.1, v3), OC4J");
        resume.addSection(QUALIFICATIONS, new ListSection(qualifications));

        Organization workPlace1 = new Organization("YANDEX", "www.yandex.ru", start, end, "Developer", "Developing");
        Organization workPlace2 = new Organization("GOOGLE", "www.google.ru", start, end, "Developer", "Developing");

        List<Organization> workPlaceList = new ArrayList<>();
        workPlaceList.add(workPlace1);
        workPlaceList.add(workPlace2);
        resume.addSection(EXPERIENCE, new OrganizationSection(workPlaceList));

        Organization education1 = new Organization("MSU", "www.msu.ru", start, end, "Student", "Developing");
        Organization education2 = new Organization("RSU", "www.rsu.ru", start, end, "Bachelor", "Developing");

        List<Organization> educationList = new ArrayList<>();
        educationList.add(education1);
        educationList.add(education2);
        resume.addSection(EDUCATION, new OrganizationSection(educationList));

        System.out.println(resume.getContacts());
        System.out.println(resume.getSections());
    }
}
