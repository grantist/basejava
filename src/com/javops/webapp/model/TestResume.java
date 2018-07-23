package com.javops.webapp.model;


import java.time.Month;
import java.time.LocalDate;

/**
 * Created by TRACTEL_RND on 20.07.2018.
 */
public class TestResume extends Resume {

    public TestResume(String fullName) {
        super(fullName);
    }

    public static void main(String[] args) {

        Resume resume = new Resume("1", "Petr Petrov");
        System.out.println(ContactType.MAIL.getTitle() + ": " + "jjj@gggg.com");
        System.out.println(ContactType.PHONE.getTitle() + ": " + "888888888888");
        System.out.println(ContactType.Skype.getTitle() + ": " + "SKYPE");
        System.out.println(SectionType.OBJECTIVE.getTitle());
        System.out.println("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        System.out.println(SectionType.PERSONAL.getTitle());
        System.out.println("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры. ");
        System.out.println(SectionType.ACHIEVEMENT.getTitle());
        System.out.println("* С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        System.out.println(SectionType.QUALIFICATIONS.getTitle());
        System.out.println("* JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
        System.out.println(SectionType.EXPERIENCE.getTitle());

        LocalDate start = LocalDate.of(2017, Month.NOVEMBER, 30);
        LocalDate end = LocalDate.of(2019, Month.NOVEMBER, 30);

        WorkPlace experinece = new WorkPlace("Java Online Projects", start, end, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        System.out.println(experinece.getNameJob());
        System.out.println(start + " - " + end + "  " + experinece.getTitle());
        System.out.println(experinece.getDescription());
        System.out.println("");
        System.out.println(SectionType.EDUCATION.getTitle());
        WorkPlace education = new WorkPlace("Coursera", start, end, "", "Functional Programming Principles in Scala\" by Martin Odersky");
        System.out.println(education.getNameJob());
        System.out.println(start + " - " + end + "  " + education.getDescription());
    }
}
