package com.javops.webapp.model;

import java.util.ArrayList;

/**
 * Created by TRACTEL_RND on 12.07.2018.
 */
public class AchievementAndQualification extends SectionStringList {

    private ArrayList<String> achievements = new ArrayList<String>();
    private ArrayList<String> qualifications = new ArrayList<String>();


    public AchievementAndQualification(ArrayList<String> achievements, ArrayList<String> qualifications) {
        this.achievements = achievements;
        this.qualifications = qualifications;
    }

    @Override
    void show() {
        super.show();
    }
}

