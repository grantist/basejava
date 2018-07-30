package com.javops.webapp.model;

import java.time.Month;
import java.time.LocalDate;
import java.util.*;

import static com.javops.webapp.model.ContactType.MAIL;
import static com.javops.webapp.model.ContactType.PHONE;
import static com.javops.webapp.model.ContactType.Skype;
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
        resume.addContact(Skype, "fffff");

        resume.addSection(OBJECTIVE, new SectionString("\"Ведущий стажировок"));
        resume.addSection(PERSONAL, new SectionString("Аналитический склад ума"));

        List<String> achievemnets = new ArrayList<String>();
        achievemnets.add("Разработка");
        achievemnets.add("WEB");
        achievemnets.add("Прочее");
        resume.addSection(ACHIEVEMENT, new SectionStringList(achievemnets));

        List<String> qualifications = new ArrayList<String>();
        achievemnets.add("JEE AS");
        achievemnets.add(" GlassFish (v2.1, v3)");
        achievemnets.add("OC4J");
        resume.addSection(QUALIFICATIONS, new SectionStringList(qualifications));

        List<Object> work1 = new ArrayList<Object>();
        work1.add("Java Online Projects");
        work1.add(start);
        work1.add(end);
        work1.add("YANDEX");
        work1.add("Functional Programming");

        List<Object> work2 = new ArrayList<Object>();
        work2.add("Projects");
        work2.add(start);
        work2.add(end);
        work2.add("GOOGLE");
        work2.add("Developer");

        List workplaces = new ArrayList();
        workplaces.add(work1);
        workplaces.add(work2);

        resume.addSection(EXPERIENCE, new WorkPlaceSection(workplaces));

        List<Object> education1 = new ArrayList();
        education1.add("Coursera");
        education1.add(start);
        education1.add(end);
        education1.add("Functional Programming");

        List<Object> education2 = new ArrayList();
        education2.add("CHH");
        education2.add(start);
        education2.add(end);
        education2.add("Java Programming");

        List educations = new ArrayList();
        educations.add(education1);
        educations.add(education2);

        resume.addSection(EDUCATION, new WorkPlaceSection(educations));

        System.out.println(resume.getContacts());
        System.out.println(resume.getSections());
    }
}
