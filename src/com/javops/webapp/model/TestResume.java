package com.javops.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TRACTEL_RND on 20.07.2018.
 */
public class TestResume extends Resume {

    public TestResume(String fullName) {
        super(fullName);
    }

    public static void main(String[] args) {

        Resume resume = new Resume("1", "Petr Petrov");
        Map<ContactType, String> contactMap = new HashMap<>();

        ArrayList<String> listAchievements = new ArrayList<String>();
        ArrayList<String> listQualifications = new ArrayList<String>();
        ArrayList<String> mapExperience = new ArrayList<>();
        ArrayList<String> mapEducation = new ArrayList<>();

        //добавляем контакты
        contactMap.put(ContactType.PHONE, "3333333");
        contactMap.put(ContactType.MAIL, "@goga.com");
        contactMap.put(ContactType.Skype, "SKYPE");
        SectionStringMap contact = new SectionStringMap((HashMap) contactMap);

        SectionString objective = new SectionString(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        SectionString personal = new SectionString(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры");

        //добавляем достижения
        listAchievements.add("* С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        listAchievements.add("* Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        SectionStringList achievements = new SectionStringList(SectionType.ACHIEVEMENT, listAchievements);

        //добавляем квалификацию
        listQualifications.add("* JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 ");
        listQualifications.add("* Version control: Subversion, Git, Mercury, ClearCase, Perforce ");
        SectionStringList qualifications = new SectionStringList(SectionType.QUALIFICATIONS, listQualifications);

        //добавляем опыт
        mapExperience.add("JAVA ONLINE \n 10/2013 Автор проекта\n Создание, организация и проведение Java онлайн проектов и стажировок.");
        mapExperience.add("WRIKE\n 10/2014-01/2016 Старший разработчик (backend)\n Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        SectionStringMap experience = new SectionStringMap(SectionType.EXPERIENCE, mapExperience);

        //добавляем образование
        mapEducation.add("Coursera03\n 2013 - 05 / 201 Functional Programming Principles in Scala by Martin Odersky");
        mapEducation.add("Luxoft \n 03/2011 - 04 / 2011, Курс Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.");
        SectionStringMap education = new SectionStringMap(SectionType.EDUCATION, mapEducation);

        contact.showContact();
        objective.show();
        personal.show();
        achievements.show();
        qualifications.show();
        experience.show();
        education.show();
    }

}
