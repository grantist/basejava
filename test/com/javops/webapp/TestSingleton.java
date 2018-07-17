package com.javops.webapp;

import com.javops.webapp.model.SectionType;

/**
 * Created by TRACTEL_RND on 10.07.2018.
 */
public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {

        if (instance == null) {
            instance = new TestSingleton();

        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance);
        System.out.println(instance.ordinal());
        for ( SectionType type : SectionType.values() ) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton {
        INSTANCE;
    }
}

