package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class AchievementAndQualification {

    private ArrayList<String> achievements = new ArrayList();
    private ArrayList<String> qualifications = new ArrayList();

    public AchievementAndQualification(ArrayList<String> achievements, ArrayList<String> qualifications) {
        this.achievements = achievements;
        this.qualifications = qualifications;
    }

    void show() {
        System.out.println(SectionType.ACHIEVEMENT.getTitle());
        for (String ach : achievements) {
            System.out.println("* " + ach);
        }
        System.out.println(SectionType.QUALIFICATIONS.getTitle());
        for (String qua : qualifications) {
            System.out.println("* " + qua);
        }
    }
}

